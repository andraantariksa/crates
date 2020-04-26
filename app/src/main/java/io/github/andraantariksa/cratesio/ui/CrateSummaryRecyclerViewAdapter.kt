package io.github.andraantariksa.cratesio.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.andraantariksa.cratesio.R
import io.github.andraantariksa.cratesio.data.network.model.CrateSummary.JustUpdated
import kotlinx.android.synthetic.main.summary_section_item.view.*

// TODO
class CrateSummaryRecyclerViewAdapter<T>(
    private val crateSummarySection: List<T>
) : RecyclerView.Adapter<CrateSummaryRecyclerViewAdapter.ViewHolder>() {
    override fun getItemCount(): Int {
        return crateSummarySection.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val justUpdatedItem: T = crateSummarySection[position]
        // TODO
        holder.textViewCrateTitle.text = "${justUpdatedItem}"
        holder.textViewCrateMaxVersion.text = "(${justUpdatedItem})"
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val context: Context = parent.context
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.summary_section_item,
                parent,
                false
            )
        )
    }

    class ViewHolder(
        view: View
    ) : RecyclerView.ViewHolder(view) {
        val textViewCrateTitle = view.textViewCrateTitle
        val textViewCrateMaxVersion = view.textViewCrateMaxVersion
    }
}