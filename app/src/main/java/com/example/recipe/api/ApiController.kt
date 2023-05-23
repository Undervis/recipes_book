package com.example.recipe.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory


class ApiController {

private val baseUrl = "https://api.edamam.com"

    fun createRecipeApi(): RecipeApi{
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(
                ScalarsConverterFactory.create()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(RecipeApi::class.java)
    }
}