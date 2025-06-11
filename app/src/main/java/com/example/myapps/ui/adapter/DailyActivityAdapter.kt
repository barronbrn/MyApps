package com.example.myapps.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.myapps.R
import com.example.myapps.data.models.DailyActivity
import com.example.myapps.databinding.ItemDailyActivityBinding

class DailyActivityAdapter : ListAdapter<DailyActivity, DailyActivityAdapter.DailyActivityViewHolder>(DailyActivityDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyActivityViewHolder {
        val binding = ItemDailyActivityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DailyActivityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DailyActivityViewHolder, position: Int) {
        val activity = getItem(position)
        holder.bind(activity)
    }

    inner class DailyActivityViewHolder(private val binding: ItemDailyActivityBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(activity: DailyActivity) {
            binding.tvActivityTitle.text = activity.title
            binding.tvActivityTime.text = activity.time
            binding.tvActivityDescription.text = activity.description

            val context = binding.root.context
            val drawableId = context.resources.getIdentifier(
                activity.imageUrl,
                "drawable",
                context.packageName
            )

            binding.ivActivityImage.load(drawableId) {
                placeholder(R.drawable.ic_activity_placeholder)
                error(R.drawable.ic_activity_placeholder)
            }
        }
    }

    class DailyActivityDiffCallback : DiffUtil.ItemCallback<DailyActivity>() {
        override fun areItemsTheSame(oldItem: DailyActivity, newItem: DailyActivity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: DailyActivity, newItem: DailyActivity): Boolean {
            return oldItem == newItem
        }
    }
}