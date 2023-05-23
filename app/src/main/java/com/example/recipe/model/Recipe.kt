package com.example.recipe.model

import com.google.gson.annotations.SerializedName
import org.json.JSONArray

data class Recipe(
    val image: String,
    val label: String,
    val ingredients: JSONArray,
    val calories: Double,
    val rating: Double
)
