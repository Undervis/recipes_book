package com.example.recipe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import com.example.recipe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val recipeLoader = RecipeLoader()
    binding.rdRecipeSearch.doAfterTextChanged {
        binding.progressBar2.isVisible = true
        recipeLoader.loadRecipes(it.toString())
    }
        binding.progressBar2.isVisible = false
    }
}