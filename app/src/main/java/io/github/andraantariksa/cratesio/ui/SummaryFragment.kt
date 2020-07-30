package io.github.andraantariksa.cratesio.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.andraantariksa.cratesio.R
import io.github.andraantariksa.cratesio.data.api.model.CrateSummary.CrateSummary
import io.github.andraantariksa.cratesio.utils.InjectorUtils
import kotlinx.android.synthetic.main.fragment_summary.*
import kotlinx.coroutines.launch


class SummaryFragment : ScopedFragment() {
    private lateinit var viewModelFactory: CratesViewModelFactory
    private lateinit var viewModel: CratesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_summary, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModelFactory = InjectorUtils.provideCratesViewModelFactory(context!!)
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(CratesViewModel::class.java)

        viewModel.crateSummaryLast?.let {
            setupSummaryRecyclerView(it)
        }
        fetchRecyclerViewData()
    }

    fun fetchRecyclerViewData() {
        launch {
            val crateSummaryLiveData = viewModel.crateSummary.await()
            crateSummaryLiveData.observe(viewLifecycleOwner, Observer {
                setupSummaryRecyclerView(it)
            })
        }
    }

    fun setupSummaryRecyclerView(crateSummary: CrateSummary) {
        textViewCratesTotalNum.text = crateSummary.numCrates.toString()
        textViewDownloadsTotalNum.text = crateSummary.numDownloads.toString()

        val newCratesAdapter =
            CrateSummaryRecyclerViewAdapter(crateSummary.newCrates)
        recyclerViewNewCrates.layoutManager = LinearLayoutManager(context)
        recyclerViewNewCrates.adapter = newCratesAdapter

        val mostDownloadedAdapter =
            CrateSummaryRecyclerViewAdapter(crateSummary.mostDownloaded)
        recyclerViewMostDownloaded.layoutManager = LinearLayoutManager(context)
        recyclerViewMostDownloaded.adapter = mostDownloadedAdapter

        val justUpdatedAdapter =
            CrateSummaryRecyclerViewAdapter(crateSummary.justUpdated)
        recyclerViewJustUpdated.layoutManager = LinearLayoutManager(context)
        recyclerViewJustUpdated.adapter = justUpdatedAdapter

        val mostRecentlyDownloaded =
            CrateSummaryRecyclerViewAdapter(crateSummary.mostRecentlyDownloaded)
        recyclerViewMostRecentlyDownloaded.layoutManager = LinearLayoutManager(context)
        recyclerViewMostRecentlyDownloaded.adapter = mostRecentlyDownloaded

        val mostPopularKeywords =
            CrateSummaryRecyclerViewAdapter(crateSummary.mostRecentlyDownloaded)
        recyclerViewPopularKeywords.layoutManager = LinearLayoutManager(context)
        recyclerViewPopularKeywords.adapter = mostPopularKeywords

        val popularCategories =
            CrateSummaryRecyclerViewAdapter(crateSummary.mostRecentlyDownloaded)
        recyclerPopularCategories.layoutManager = LinearLayoutManager(context)
        recyclerPopularCategories.adapter = popularCategories
    }
}
