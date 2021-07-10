package io.github.andraantariksa.cratesio.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import io.github.andraantariksa.cratesio.R
import io.github.andraantariksa.cratesio.databinding.FragmentCratesDetailBinding
import io.noties.markwon.Markwon
import io.noties.markwon.image.glide.GlideImagesPlugin

class CratesDetailFragment: Fragment() {
    private lateinit var binding: FragmentCratesDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_crates_detail,
            container,
            false
        )

        setupView()

        return binding.root
    }

    private fun setupView() {
        val markwon = Markwon.builder(requireContext()).usePlugin(GlideImagesPlugin.create(requireContext())).build()
        markwon.setMarkdown(binding.textView2, "")

    }
}