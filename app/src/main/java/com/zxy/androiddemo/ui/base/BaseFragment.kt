package com.zxy.androiddemo.ui.base


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.zxy.androiddemo.ui.MainActivity


abstract class BaseFragment : Fragment() {

    lateinit var mainActivity: MainActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity = activity as MainActivity
    }

}
