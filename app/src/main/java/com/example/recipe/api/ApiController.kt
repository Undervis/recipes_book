package com.example.recipe.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory


object ApiController {
    private var retrofit: Retrofit? = null
    private var baseUrl = "https://api.edamam.com/"

    fun getClient(): Retrofit {
        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit!!
    }
}