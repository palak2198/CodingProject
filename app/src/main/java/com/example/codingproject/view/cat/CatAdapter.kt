package com.example.codingproject.view.cat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.codingproject.data.model.CatsResponseItem
import com.example.codingproject.databinding.ItemCatBinding
import javax.inject.Inject

class CatAdapter @Inject constructor(): RecyclerView.Adapter<CatViewHolder>() {
    private var listOfCats: ArrayList<CatsResponseItem> = ArrayList()
    var itemClickListener: ItemClickListener?= null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val binding =
            ItemCatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CatViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listOfCats.size
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.bind(listOfCats[position])
        holder.itemClickListener = itemClickListener
    }

    fun addAll(list: List<CatsResponseItem>) {
        listOfCats.addAll(list)
    }

    interface ItemClickListener {
        fun onItemClick(catsResponseItem: CatsResponseItem)
    }
}