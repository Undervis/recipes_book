package com.example.recipe.api

import retrofit2.Call
import okhttp3.ResponseBody
import retrofit2.Callback
import retrofit2.http.*

interface RecipeApi {

    @GET("search")
    fun getRecipes(
        @Query("app_id") appId: String = "cb5904b6",
        @Query("app_key") appKey: String = "243bcd69109f59a2a62e5ffd48f185ec",
        @Query("q") query: String = "",
    ): Call<ResponseBody>
}