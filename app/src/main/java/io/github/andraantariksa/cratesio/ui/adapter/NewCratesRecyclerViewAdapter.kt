package io.github.andraantariksa.cratesio.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import io.github.andraantariksa.cratesio.R
import io.github.andraantariksa.cratesio.ui.viewmodel.CratesSummaryViewModel
import io.github.andraantariksa.cratesio.databinding.CratesSummaryItemBinding

class NewCratesRecyclerViewAdapter(
        val parentLifecycleOwner: LifecycleOwner,
        private val cratesSummaryViewModel: CratesSummaryViewModel) :
        RecyclerView.Adapter<NewCratesRecyclerViewAdapter.ViewHolder>() {
    private lateinit var binding: CratesSummaryItemBinding

    init {
        setupNewCratesUpdate(parentLifecycleOwner)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.crates_summary_item,
                parent,
                false)

        return ViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return cratesSummaryViewModel.cratesSummary.value?.newCrates?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = cratesSummaryViewModel.cratesSummary.value!!.newCrates[position]
        holder.title.text = data.name
        holder.subtitle.text = "v${data.maxVersion}"
    }

    private fun setupNewCratesUpdate(lifecycleOwner: LifecycleOwner) {
        cratesSummaryViewModel.cratesSummary.observe(lifecycleOwner, {
            notifyDataSetChanged()
        })
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView = view.findViewById(R.id.textViewTitle) as TextView
        var subtitle: TextView = view.findViewById(R.id.textViewSubtitle) as TextView
    }
}