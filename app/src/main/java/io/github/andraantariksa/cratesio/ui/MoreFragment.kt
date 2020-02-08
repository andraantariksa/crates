package io.github.andraantariksa.cratesio.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.andraantariksa.cratesio.R
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein

class MoreFragment : Fragment(), KodeinAware {

    override val kodein by closestKodein()

    companion object {
        fun newInstance() = MoreFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_more, container, false)
    }

}
