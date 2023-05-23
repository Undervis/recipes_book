package com.example.recipe

import com.example.recipe.api.ApiController
import kotlinx.coroutines.*

class RecipeLoader {

    private val recipeApi = ApiController().createRecipeApi()
    private var job: Job? = null

    fun loadRecipes(toString: String) {
        job?.cancel()
        job = CoroutineScope(Dispatchers.IO).launch {
            delay(300L)
            recipeApi.getRecipes(
            type = "public",
            appKey = "",
            appId = "",
            query = "query"
            )
        }
    }
}