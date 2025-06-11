package com.example.myapps.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.myapps.R
import com.example.myapps.data.models.MusicItem
import com.example.myapps.databinding.ItemMusicBinding

class MusicAdapter : ListAdapter<MusicItem, MusicAdapter.MusicViewHolder>(MusicDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val binding = ItemMusicBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MusicViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class MusicViewHolder(private val binding: ItemMusicBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MusicItem) {
            binding.tvMusicTitle.text = item.title
            binding.tvMusicArtist.text = item.artist

            val context = binding.root.context
            val drawableId = context.resources.getIdentifier(
                item.thumbnailUrl,
                "drawable",
                context.packageName
            )
            binding.ivMusicThumbnail.load(drawableId) {
                placeholder(R.drawable.ic_music_placeholder)
                error(R.drawable.ic_music_placeholder)
            }

        }
    }

    class MusicDiffCallback : DiffUtil.ItemCallback<MusicItem>() {
        override fun areItemsTheSame(oldItem: MusicItem, newItem: MusicItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MusicItem, newItem: MusicItem): Boolean {
            return oldItem == newItem
        }
    }
}