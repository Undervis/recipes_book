package com.example.recipe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.recipe.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding // Переменная для обращения XML ActivityMain

class LaunchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)

        binding = ActivityMainBinding.inflate(layoutInflater) // Соеденяем с версткой
        setContentView(binding.root) //

        object:CountDownTimer(1000, 1000){
            override fun onTick(p0: Long) {
            }

            override fun onFinish() {
                val intent = Intent(this@LaunchActivity, MainActivity::class.java)
                startActivity(intent)
                this@LaunchActivity.finish()
            }
        }.start()
    }
}