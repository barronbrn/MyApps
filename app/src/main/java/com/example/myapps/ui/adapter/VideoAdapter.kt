package com.example.myapps.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.myapps.R
import com.example.myapps.data.models.VideoItem
import com.example.myapps.databinding.ItemVideoBinding

class VideoAdapter(private val onClick: (String) -> Unit) : ListAdapter<VideoItem, VideoAdapter.VideoViewHolder>(VideoDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val binding = ItemVideoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VideoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class VideoViewHolder(private val binding: ItemVideoBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val videoItem = getItem(position)
                    videoItem.videoUrl?.let { url ->
                        onClick(url)
                    }
                }
            }
        }

        fun bind(item: VideoItem) {
            binding.tvVideoTitle.text = item.title

            val context = binding.root.context
            val drawableId = context.resources.getIdentifier(
                item.thumbnailUrl,
                "drawable",
                context.packageName
            )
            binding.ivVideoThumbnail.load(drawableId) {
                placeholder(R.drawable.ic_video_placeholder)
                error(R.drawable.ic_video_placeholder)
            }

        }
    }


    class VideoDiffCallback : DiffUtil.ItemCallback<VideoItem>() {
        override fun areItemsTheSame(oldItem: VideoItem, newItem: VideoItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: VideoItem, newItem: VideoItem): Boolean {
            return oldItem == newItem
        }
    }
}