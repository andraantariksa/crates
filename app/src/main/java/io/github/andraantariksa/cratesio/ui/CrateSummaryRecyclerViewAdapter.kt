package io.github.andraantariksa.cratesio.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.github.andraantariksa.cratesio.R
import io.github.andraantariksa.cratesio.data.api.model.CrateSummary.Summary
import kotlinx.android.synthetic.main.item_crate_summary.view.*

class CrateSummaryRecyclerViewAdapter<T : Summary>(
    private val crateSummarySection: List<T>
) : RecyclerView.Adapter<CrateSummaryRecyclerViewAdapter.ViewHolder>() {
    override fun getItemCount(): Int {
        return crateSummarySection.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val crateInformation = crateSummarySection[position]
        holder.textViewCrateTitle.text = crateInformation.title
        holder.textViewCrateMaxVersion.text = crateInformation.subtitle
        holder.actionType = crateInformation.actionType
        holder.actionTargetName = crateInformation.actionTargetName
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val context: Context = parent.context
        return ViewHolder(
            LayoutInflater
                .from(context)
                .inflate(
                    R.layout.item_crate_summary,
                    parent,
                    false
                )
        )
    }

    class ViewHolder(
        val view: View
    ) : RecyclerView.ViewHolder(view), View.OnClickListener {
        val textViewCrateTitle: TextView = view.textViewCrateTitle
        val textViewCrateMaxVersion: TextView = view.textViewCrateSubtitle

        lateinit var actionType: ActionType
        lateinit var actionTargetName: String

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val intent = Intent()
            when (actionType) {
                ActionType.Crates -> {
                    intent.setClass(view.context, CrateDetailActivity::class.java)
                    intent.putExtra("actionType", actionType)
                    intent.putExtra("actionTargetName", actionTargetName)
                    view.context.startActivity(intent)
                }
                else -> {
                    throw NotImplementedError()
                }
            }
        }
    }
}
