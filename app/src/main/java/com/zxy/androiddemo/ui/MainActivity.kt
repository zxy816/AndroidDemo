package com.zxy.androiddemo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.LabelVisibilityMode
import com.zxy.androiddemo.R
import com.zxy.androiddemo.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        lifecycle.addObserver(ViewLifeObserver())
        //取消标题栏显示
        this.supportActionBar?.hide()
        //自定义nav背景资源时
        binding.navView.itemIconTintList = null
        //NavigationView
        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_paging, R.id.navigation_home, R.id.navigation_paging))
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navView.labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_LABELED
        binding.navView.setupWithNavController(navController)

    }
}
