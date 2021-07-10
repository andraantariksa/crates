package io.github.andraantariksa.cratesio.ui.fragment.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import io.github.andraantariksa.cratesio.R
import io.github.andraantariksa.cratesio.databinding.FragmentMainSummaryBinding
import io.github.andraantariksa.cratesio.ui.viewmodel.CratesSummaryViewModel
import io.github.andraantariksa.cratesio.ui.manager.LinearLayoutNoScrollManager
import io.github.andraantariksa.cratesio.ui.adapter.NewCratesRecyclerViewAdapter

@AndroidEntryPoint
class SummaryFragment : Fragment() {
    val viewModelCrates by viewModels<CratesSummaryViewModel>()
    private lateinit var binding: FragmentMainSummaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupLiveData()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_main_summary,
            container,
            false
        )

        binding.recyclerViewNewCrates.layoutManager = LinearLayoutNoScrollManager(context)
        binding.recyclerViewNewCrates.adapter = NewCratesRecyclerViewAdapter(
            viewLifecycleOwner,
            viewModelCrates
        )

        viewModelCrates.fetchCratesSummary()

        return binding.root
    }

    fun setupLiveData() {
//        viewModelCrates.cratesSummary.observe(this, Observer {
//
//        })
    }
}