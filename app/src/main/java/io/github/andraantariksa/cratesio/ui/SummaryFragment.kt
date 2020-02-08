package io.github.andraantariksa.cratesio.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.andraantariksa.cratesio.R
import io.github.andraantariksa.cratesio.data.network.model.CrateSummary.CrateSummary
import kotlinx.android.synthetic.main.summary_fragment.*
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance


class SummaryFragment : ScopedFragment(), KodeinAware {

    override val kodein by closestKodein()

    private val viewModelFactory: SummaryViewModelFactory by instance()

    companion object {
        fun newInstance() =
            SummaryFragment()
    }

    private lateinit var viewModel: SummaryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.summary_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(SummaryViewModel::class.java)

        bindUI()


    }

    fun bindUI() = launch {
        val crateSummary = viewModel.crateSummary.await()
        crateSummary.observe(viewLifecycleOwner, Observer {
            initRV(it)
        })
    }

    fun initRV(crateSummary: CrateSummary) {
        recyclerViewCrateSummary.adapter =
            CrateSummaryAdapter(crateSummary.justUpdated)
        recyclerViewCrateSummary.layoutManager = LinearLayoutManager(activity)
    }

}
