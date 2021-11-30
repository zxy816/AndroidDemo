package com.zxy.androiddemo.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import java.lang.Exception
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.HttpsURLConnection
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager


/**
 * @author: zxy
 * @date: 2018/7/11
 * @des:
 */
@HiltAndroidApp
class DemoApp : Application() {

    override fun onCreate() {
        super.onCreate()
        handleSSLHandshake()
    }

    /**
     * glide 加载https图片
     */
    private fun handleSSLHandshake() {
        try {
            val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
                override fun getAcceptedIssuers(): Array<X509Certificate?> {
                    return arrayOfNulls(0)
                }

                override fun checkClientTrusted(certs: Array<X509Certificate>, authType: String) {}
                override fun checkServerTrusted(certs: Array<X509Certificate>, authType: String) {}
            })
            val sc = SSLContext.getInstance("TLS")
            sc.init(null, trustAllCerts, SecureRandom())
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.socketFactory)
            HttpsURLConnection.setDefaultHostnameVerifier { _, _ -> true }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
