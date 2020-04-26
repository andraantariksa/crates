package io.github.andraantariksa.cratesio.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.PagerAdapter
import io.github.andraantariksa.cratesio.R
import io.github.andraantariksa.cratesio.data.network.model.CrateSummary.CrateSummary
import kotlinx.android.synthetic.main.crates_summary_slider.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class CrateSummarySliderAdapter(
    private val context: Context,
    private val viewModel: SummaryViewModel,
    override val coroutineContext: CoroutineContext,
    private val viewLifecycleOwner: LifecycleOwner
) : PagerAdapter(), CoroutineScope {
    private val menuTitle = arrayListOf<String>(
        "New Crates",
        "Most Downloaded",
        "Just Updated",
        "Most Recent Downloads",
        "Popular Keywords",
        "Popular Categories"
    )

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object` as RelativeLayout
    }

    override fun getCount(): Int {
        return menuTitle.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.crates_summary_slider, container, false)

        launch {
            val crateSummary = viewModel.crateSummary.await()
            crateSummary.observe(viewLifecycleOwner, Observer {
                view.recyclerViewCrates.layoutManager = LinearLayoutManager(context)
                view.recyclerViewCrates.adapter =
                    CrateSummaryRecyclerViewAdapter(mapCrateSummary(it, position))
            })
        }

        container.addView(view)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as RelativeLayout)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return menuTitle[position]
    }

    private fun mapCrateSummary(crateSummary: CrateSummary, position: Int): List<Any> {
        return when (position) {
            0 -> crateSummary.newCrates
            1 -> crateSummary.mostDownloaded
            2 -> crateSummary.justUpdated
            3 -> crateSummary.mostRecentlyDownloaded
            4 -> crateSummary.popularKeywords
            5 -> crateSummary.popularCategories
            else -> error("Invalid crate summary position")
        }
    }
}