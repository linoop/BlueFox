package com.linoop.bluefox.presentation.views

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.linoop.bluefox.R
import com.linoop.bluefox.databinding.ActivityMainBinding
import com.linoop.bluefox.databinding.LayoutMessageBinding
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
            application, "70eecb89-e638-48fb-90b1-b5b96031581f",
            Analytics::class.java, Crashes::class.java
        )
    }

    fun goBack() = onBackPressedDispatcher.onBackPressed()

    fun showMessage(title: String, message: String) {
        runOnUiThread {
            val dialogBuilder = MaterialAlertDialogBuilder(this)
            val dialogView = LayoutInflater.from(this).inflate(R.layout.layout_message, null)
            val dialogBinding = LayoutMessageBinding.bind(dialogView)
            dialogBuilder.setView(dialogBinding.root)
            dialogBuilder.background = ColorDrawable(Color.TRANSPARENT)
            dialogBuilder.setCancelable(false)
            val dialog = dialogBuilder.create()
            dialogBinding.title.text = title
            dialogBinding.message.text = message
            dialogBinding.buttonYes.text = getString(R.string.ok)
            dialogBinding.buttonYes.setOnClickListener { dialog.dismiss() }
            dialogBinding.buttonNo.visibility = View.GONE
            dialog.show()
        }
    }
}