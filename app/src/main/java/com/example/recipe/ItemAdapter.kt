package com.example.recipe

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recipe.databinding.ItemBinding
import com.example.recipe.model.Recipe
import com.squareup.picasso.Picasso

class ItemAdapter(val data: List<Recipe>): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val viewItem = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        val edImage = viewItem.findViewById<ImageView>(R.id.edImg)
        val tvLabel = viewItem.findViewById<TextView>(R.id.tvLabel)
        val tvRating = viewItem.findViewById<TextView>(R.id.tvRating)
        val tvCalories = viewItem.findViewById<TextView>(R.id.tvCalories)
        edImage.setOnClickListener {
            val intent = Intent(parent.context, RecipeActivity::class.java)
            intent.putExtra("image", edImage.tag.toString())
            intent.putExtra("label", tvLabel.text.toString())
            intent.putExtra("desc", tvLabel.tag.toString())
            intent.putExtra("rating", tvRating.text.toString())
            intent.putExtra("calories", tvCalories.text.toString())
            parent.context.startActivity(intent)
        }
        return ItemViewHolder(viewItem)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val recipe = data[position]
        holder.edImage.clipToOutline = true
        holder.edImage.tag = recipe.image
        Picasso.get().load(recipe.image).into(holder.edImage)
        holder.tvLabel.text = recipe.label
        var description: String = ""
        for(i in 0 until recipe.ingredients.length()) {
            description += recipe.ingredients[i].toString() + "\n"
        }
        holder.tvLabel.tag = description
        holder.tvRating.text = String.format("%.1f", recipe.rating)
        holder.tvCalories.text = String.format("%.1f", recipe.calories)
    }
    class ItemViewHolder(view: View): RecyclerView.ViewHolder(view){
        var edImage = view.findViewById<ImageView>(R.id.edImg)!!
        var tvLabel = view.findViewById<TextView>(R.id.tvLabel)!!
        var tvRating = view.findViewById<TextView>(R.id.tvRating)!!
        var tvCalories = view.findViewById<TextView>(R.id.tvCalories)!!
    }
}