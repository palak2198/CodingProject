package com.example.codingproject.view.cat

import androidx.recyclerview.widget.RecyclerView
import com.example.codingproject.data.model.CatsResponseItem
import com.example.codingproject.databinding.ItemCatBinding

class CatViewHolder(private val binding: ItemCatBinding): RecyclerView.ViewHolder(binding.root) {

    var itemClickListener: CatAdapter.ItemClickListener?= null
    fun bind(catsResponseItem: CatsResponseItem) {
        binding.tvCatBreed.text = catsResponseItem.name ?: ""
        binding.tvCatBreed.setOnClickListener{
            itemClickListener?.onItemClick(catsResponseItem)
        }
    }
}