package com.example.recipe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class RecipeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)

        window.statusBarColor = resources.getColor(R.color.bg)
        var tvRecLabel = findViewById<TextView>(R.id.tvRecLabel)
        var tvRecDesc = findViewById<TextView>(R.id.tvRecDesc)
        var tvRecCalories = findViewById<TextView>(R.id.tvRecCalories)
        var tvRecRating = findViewById<TextView>(R.id.tvRecRating)
        var imgRecImg = findViewById<ImageView>(R.id.imgRecPhoto)
        var btnBack = findViewById<Button>(R.id.btnBack)

        imgRecImg.clipToOutline = true
        Picasso.get().load(intent.getStringExtra("image")).into(imgRecImg)
        tvRecLabel.text = intent.getStringExtra("label")
        tvRecDesc.text = intent.getStringExtra("desc")
        tvRecRating.text = intent.getStringExtra("rating")
        tvRecCalories.text = intent.getStringExtra("calories")

        btnBack.setOnClickListener {
            finish()
        }
    }
}