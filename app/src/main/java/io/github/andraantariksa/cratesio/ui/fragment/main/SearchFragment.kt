package io.github.andraantariksa.cratesio.ui.fragment.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import io.github.andraantariksa.cratesio.R
import io.github.andraantariksa.cratesio.databinding.FragmentMainSearchBinding

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private lateinit var binding: FragmentMainSearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main_search, container, false)
        setupView()
        return binding.root
    }

    private fun setupView() {
    }

}