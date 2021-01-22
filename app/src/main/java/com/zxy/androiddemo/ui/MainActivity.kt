package com.zxy.androiddemo.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.zxy.androiddemo.R
import com.zxy.androiddemo.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_base.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    fun setToolbar(isShow: Boolean, back: Boolean = false, title: String = "") {
        toolbar.visibility = if (isShow) View.VISIBLE else View.GONE
        toolbarBack.visibility = if (back) View.VISIBLE else View.GONE
        toolbarTitle.text = title
        toolbarBack.setOnClickListener {
            onBackPressed()
        }
    }
}
