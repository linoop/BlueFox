package com.linoop.bluefox.presentation.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.linoop.bluefox.databinding.ActivitySplashBinding


class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.myButton.setOnClickListener { buttonOnClick() }
        startActivity(Intent(this, MainActivity::class.java))
    }

    private fun buttonOnClick() {
        binding.myTextView.text = "Clicked"
    }
}