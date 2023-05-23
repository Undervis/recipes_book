package com.example.recipe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recipe.api.ApiController
import com.example.recipe.api.RecipeApi
import com.example.recipe.databinding.ActivityMainBinding
import com.example.recipe.model.Recipe
import kotlinx.coroutines.*
import org.json.JSONObject
import java.net.ConnectException

class MainActivity : AppCompatActivity() {

    private var recipesList: List<Recipe> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.statusBarColor = resources.getColor(R.color.bg)
        val recyclerView = findViewById<RecyclerView>(R.id.rRecipe)
        val searchBtn = findViewById<ImageButton>(R.id.searchBtn)
        val progress = findViewById<ProgressBar>(R.id.progressBar2)
        val rdRecipeSearch = findViewById<EditText>(R.id.rdRecipeSearch)

        searchBtn.setOnClickListener {
            val findRecipes = MainScope()
            findRecipes.launch {
                progress.visibility = View.VISIBLE
                val client = ApiController.getClient().create(RecipeApi::class.java)
                withContext(Dispatchers.IO) {
                    try {
                        val response =
                            client.getRecipes(query = rdRecipeSearch.text.toString()).execute()
                        val recipesObj = JSONObject(response.body()!!.string())
                        val recipesArray = recipesObj.getJSONArray("hits")
                        for (i in 0 until recipesArray.length()) {
                            val recipeObjPre = JSONObject(recipesArray[i].toString())
                            val recipeObj = recipeObjPre.getJSONObject("recipe")
                            val recipe = Recipe(
                                recipeObj.getString("image"),
                                recipeObj.getString("label"),
                                recipeObj.getJSONArray("ingredientLines"),
                                recipeObj.getDouble("calories"),
                                recipeObj.getDouble("yield")
                            )
                            recipesList = recipesList + recipe
                        }
                        runOnUiThread {
                            val adapter = ItemAdapter(recipesList)
                            recyclerView.adapter = adapter
                            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                            progress.visibility = View.GONE
                        }
                    } catch (E: ConnectException) {
                        runOnUiThread {
                            Toast.makeText(this@MainActivity, E.message, Toast.LENGTH_LONG).show()
                        }
                    }


                }
            }
        }
    }
}