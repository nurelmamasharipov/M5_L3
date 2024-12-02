package com.example.m5_l2.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.m5_l2.data.local.LoveEntity
import com.example.m5_l2.databinding.LoveItemBinding

class HistoryAdapter(
    private val onLongClick: (LoveEntity) -> Unit
) : ListAdapter<LoveEntity, HistoryAdapter.ViewHolder>(DiffCallback()) {

    class ViewHolder(private val binding: LoveItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(pair: LoveEntity, onLongClick: (LoveEntity) -> Unit) {
            binding.tvFirstName.text = pair.firstName
            binding.tvSecondName.text = pair.secondName
            binding.tvPercentage.text = "${pair.percentage}%"
            itemView.setOnLongClickListener {
                onLongClick(pair)
                true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = LoveItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), onLongClick)
    }

    class DiffCallback : DiffUtil.ItemCallback<LoveEntity>() {
        override fun areItemsTheSame(oldItem: LoveEntity, newItem: LoveEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: LoveEntity, newItem: LoveEntity): Boolean {
            return oldItem == newItem
        }
    }
}
