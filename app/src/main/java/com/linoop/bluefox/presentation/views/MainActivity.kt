package com.linoop.bluefox.presentation.views

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.linoop.bluefox.databinding.ActivityMainBinding
import com.linoop.bluefox.presentation.viewModels.MainViewModel
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        AppCenter.start(
            application, "7a08bce0-13b6-4ab1-949c-e8de30da2dfa",
            Analytics::class.java, Crashes::class.java
        )
    }

    fun goBack(){
        onBackPressedDispatcher.onBackPressed()
    }
}