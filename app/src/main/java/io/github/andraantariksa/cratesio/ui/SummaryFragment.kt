package io.github.andraantariksa.cratesio.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import io.github.andraantariksa.cratesio.R
import io.github.andraantariksa.cratesio.data.viewmodel.CratesSummaryViewModel
import io.github.andraantariksa.cratesio.databinding.FragmentSummaryBinding
import io.github.andraantariksa.cratesio.ui.misc.LinearLayoutNoScrollManager
import io.github.andraantariksa.cratesio.ui.recyclerview.NewCratesRecyclerViewAdapter

class SummaryFragment : Fragment() {
    private lateinit var viewModelCrates: CratesSummaryViewModel
    private lateinit var binding: FragmentSummaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModelCrates = CratesSummaryViewModel(requireContext())
        setupLiveData()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_summary,
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