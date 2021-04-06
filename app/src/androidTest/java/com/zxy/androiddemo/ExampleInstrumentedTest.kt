package com.zxy.androiddemo

import android.os.CountDownTimer
import android.os.Looper
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    private lateinit var countDownTimer: CountDownTimer;

    @Test
    public fun test() {
        statTime();
    }

    private fun statTime() {
        Looper.prepare()
        countDownTimer = object : CountDownTimer(60 * 1000, 1000) {
            override fun onTick(mMillisInFuture: Long) {
                println("===== ${mMillisInFuture / 1000}")
            }

            override fun onFinish() {

            }
        }

        countDownTimer.start()

        Looper.loop()
    }

}
