package com.example.recipe.api

import com.example.recipe.model.RecipeResponseData
import retrofit2.http.*

interface RecipeApi {

    @GET("api/recipes/v2")
    suspend fun getRecipes(
        @Query("type") type: String,
        @Query("app_id") appId: String,
        @Query("app_key") appKey: String,
        @Query("q") query: String,
    ): RecipeResponseData
}