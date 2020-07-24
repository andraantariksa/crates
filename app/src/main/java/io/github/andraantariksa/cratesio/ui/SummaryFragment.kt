package io.github.andraantariksa.cratesio.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import io.github.andraantariksa.cratesio.R
import io.github.andraantariksa.cratesio.data.api.ConnectivityInterceptorImpl
import io.github.andraantariksa.cratesio.data.api.CratesioAPIService
import io.github.andraantariksa.cratesio.data.api.datasource.CrateSummaryDatasourceImpl
import io.github.andraantariksa.cratesio.data.repository.CrateSummaryRepositoryImpl
import kotlinx.android.synthetic.main.summary_fragment.*
import kotlinx.coroutines.launch


class SummaryFragment : ScopedFragment() {
    companion object {
        fun newInstance() = SummaryFragment()
    }

    private lateinit var viewModel: SummaryViewModel
    private lateinit var sliderViewPager: ViewPager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.summary_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val apiService = CratesioAPIService(ConnectivityInterceptorImpl(this.context!!))
        val crateSummaryDataSource = CrateSummaryDatasourceImpl(apiService)
        val crateSummaryRepository = CrateSummaryRepositoryImpl(crateSummaryDataSource)

        viewModel = SummaryViewModel(crateSummaryRepository)

        launch {
            val crateSummary = viewModel.crateSummary.await()
            crateSummary.observe(viewLifecycleOwner, Observer {
                textViewCratesTotalNum.text = it.numCrates.toString()
                textViewDownloadsTotalNum.text = it.numDownloads.toString()

                val newCratesAdapter =
                    CrateSummaryRecyclerViewAdapter(it.newCrates)
                recyclerViewNewCrates.layoutManager = LinearLayoutManager(context)
                recyclerViewNewCrates.adapter = newCratesAdapter

                val mostDownloadedAdapter =
                    CrateSummaryRecyclerViewAdapter(it.mostDownloaded)
                recyclerViewMostDownloaded.layoutManager = LinearLayoutManager(context)
                recyclerViewMostDownloaded.adapter = mostDownloadedAdapter

                val justUpdatedAdapter =
                    CrateSummaryRecyclerViewAdapter(it.justUpdated)
                recyclerViewJustUpdated.layoutManager = LinearLayoutManager(context)
                recyclerViewJustUpdated.adapter = justUpdatedAdapter

                val mostRecentlyDownloaded =
                    CrateSummaryRecyclerViewAdapter(it.mostRecentlyDownloaded)
                recyclerViewMostRecentlyDownloaded.layoutManager = LinearLayoutManager(context)
                recyclerViewMostRecentlyDownloaded.adapter = mostRecentlyDownloaded

                val mostPopularKeywords =
                    CrateSummaryRecyclerViewAdapter(it.mostRecentlyDownloaded)
                recyclerViewPopularKeywords.layoutManager = LinearLayoutManager(context)
                recyclerViewPopularKeywords.adapter = mostPopularKeywords

                val popularCategories =
                    CrateSummaryRecyclerViewAdapter(it.mostRecentlyDownloaded)
                recyclerPopularCategories.layoutManager = LinearLayoutManager(context)
                recyclerPopularCategories.adapter = popularCategories
            })
        }
    }
}
