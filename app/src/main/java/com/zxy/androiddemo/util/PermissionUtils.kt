package com.zxy.androiddemo.util

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.annotation.NonNull
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.util.*

/**
 * @author: zxy
 * @date: 2020/7/10
 * @des:
 */
class PermissionUtils {
    //添加相应的权限
    private val permissions = arrayOf(
            Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.INTERNET, Manifest.permission.CAMERA)

    interface PermissionCallbacks {
        /**
         * @param isAllGranted 是否全部同意
         */
        fun onPermissionsAllGranted(requestCode: Int, perms: List<String?>?, isAllGranted: Boolean)

        fun onPermissionsDenied(requestCode: Int, perms: List<String?>?)
    }


    fun hasPermissions(@NonNull context: Context?): Boolean {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true
        }
        requireNotNull(context) { "Can't check permissions for null context" }
        for (perm in permissions) {
            if (ContextCompat.checkSelfPermission(context, perm) !== PackageManager.PERMISSION_GRANTED) {
                return false
            }
        }
        return true
    }

    /**
     * 申请权限
     */
    fun requestPermissions(@NonNull activity: Activity, requestCode: Int) {
        val permissionList: MutableList<String> = ArrayList()
        for (permission in permissions) {
            if (ContextCompat.checkSelfPermission(activity, permission) !== PackageManager.PERMISSION_GRANTED) {
                permissionList.add(permission)
            }
        }
        val permissionsArray = permissionList.toTypedArray()
        if (!permissionList.isEmpty()) {
            ActivityCompat.requestPermissions(activity, permissionsArray, requestCode)
        }
    }

    /**
     * 申请权限的回调
     *
     * @param requestCode  请求权限时传入的请求码，用于区别是哪一次请求的
     * @param permissions  所请求的所有权限的数组
     * @param grantResults 权限授予结果，和 permissions 数组参数中的权限一一对应，元素值为两种情况，如下:
     * 授予: PackageManager.PERMISSION_GRANTED
     * 拒绝: PackageManager.PERMISSION_DENIED
     */
    fun onRequestPermissionsResult(requestCode: Int, @NonNull permissions: Array<String>, @NonNull grantResults: IntArray, @NonNull callBack: PermissionCallbacks) {
        //授予权限集合
        val granted: MutableList<String> = ArrayList()
        //拒绝权限集合
        val denied: MutableList<String> = ArrayList()
        for (i in permissions.indices) {
            val perm = permissions[i]
            if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                granted.add(perm)
            } else {
                denied.add(perm)
            }
        }
        if (denied.isEmpty()) {
            callBack.onPermissionsAllGranted(requestCode, granted, denied.isEmpty())
        }
        if (!denied.isEmpty()) {
            callBack.onPermissionsDenied(requestCode, denied)
        }
    }
}