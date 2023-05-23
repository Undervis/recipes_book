package com.example.recipe

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recipe.databinding.ItemBinding

class ItemAdapter(val data: List<String>): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(data[position])

    }
    class ItemViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val binding = ItemBinding.bind(view)

        fun bind(name: String){
            binding.tvName.text = name // tvName - верстка
        }
    }
}