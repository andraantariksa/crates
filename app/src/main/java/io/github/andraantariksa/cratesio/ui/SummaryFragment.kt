package io.github.andraantariksa.cratesio.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import io.github.andraantariksa.cratesio.R
import io.github.andraantariksa.cratesio.data.network.ConnectivityInterceptorImpl
import io.github.andraantariksa.cratesio.data.network.CratesioAPIService
import io.github.andraantariksa.cratesio.data.network.datasource.CrateSummaryDatasourceImpl
import io.github.andraantariksa.cratesio.data.repository.CrateSummaryRepositoryImpl
import kotlinx.android.synthetic.main.summary_fragment.*


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

        sliderViewPager = viewPagerCrateSlider
        sliderViewPager.adapter =
            CrateSummarySliderAdapter(context!!, viewModel, coroutineContext, viewLifecycleOwner)
        tabLayoutCrateSlider.setupWithViewPager(sliderViewPager)

//        bindUI()
    }

//    fun bindUI() = launch {
//        val crateSummary = viewModel.crateSummary.await()
//        crateSummary.observe(viewLifecycleOwner, Observer {
//            initRV(it)
//        })
//    }
//
//    fun initRV(crateSummary: CrateSummary) {
//        view.recyclerViewCrates.layoutManager = LinearLayoutManager(context)
//    }

}
