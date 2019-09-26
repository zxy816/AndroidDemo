package com.zxy.androiddemo.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.zxy.androiddemo.R
import kotlinx.android.synthetic.main.toolbar_base.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun setToolbar(isShow: Boolean, str: String) {
        if (isShow){
            toolbar.visibility = View.VISIBLE
        } else{
            toolbar.visibility = View.GONE
        }
        toolbarTitle.text = str
        toolbarBack.setOnClickListener {
        }
    }
}
