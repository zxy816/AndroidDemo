package com.zxy.androiddemo.http

import android.app.AlertDialog
import android.content.Context
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.zxy.androiddemo.R

/**
 * @author: zxy
 * @date: 2021/11/30
 * @des:
 */
class DialogUtils {
    private var dialog: AlertDialog? = null
    private var msgTextView: TextView? = null

    fun showProgress(context: Context?, tipMsg: String?) {
        val builder = AlertDialog.Builder(context)
        val view: View = LayoutInflater.from(context).inflate(R.layout.widget_dialog_view, null)
        msgTextView = view.findViewById(R.id.tv_msg)
        builder.setView(view)
        dialog = builder.create()
        if (!TextUtils.isEmpty(tipMsg)) {
            with(msgTextView) { this?.setText(tipMsg) }
        }
        if (dialog != null && !dialog!!.isShowing) {
            dialog!!.show()
        }
    }

    fun dismissProgress() {
        if (dialog != null && dialog!!.isShowing) {
            dialog!!.dismiss()
        }
    }
}