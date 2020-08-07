package com.zxy.androiddemo.ui

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.zxy.androiddemo.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_base.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun setToolbar(isShow:Boolean, back:Boolean = false, title:String = ""){
        toolbar.visibility  = if (isShow) View.VISIBLE else View.GONE
        toolbarBack.visibility = if (back) View.VISIBLE else View.GONE
        toolbarTitle.text = title
        toolbarBack.setOnClickListener {
            onBackPressed()
        }
    }

}
