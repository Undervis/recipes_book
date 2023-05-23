package com.example.recipe.model

import com.google.gson.annotations.SerializedName

data class HitsData(
    @SerializedName("recipe")
    val recipe: Recipe
)
