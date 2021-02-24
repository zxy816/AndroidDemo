package com.zxy.androiddemo.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.zxy.androiddemo.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    fun setToolbar(isShow: Boolean, back: Boolean = false, title: String = "") {
        binding.toolbar.toolbarBack.visibility = if (back) View.VISIBLE else View.GONE
        binding.toolbar.toolbarTitle.text = title
        binding.toolbar.toolbarBack.setOnClickListener {
            onBackPressed()
        }
    }
}
