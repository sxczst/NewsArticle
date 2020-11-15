package org.sxczst.toutiao.news.utils

import android.os.CountDownTimer
import org.sxczst.toutiao.news.view.CountDownListener

/**
 * @Author      :sxczst
 * @Date        :Created in 2020/11/15 9:45
 * @Description :
 */
class AuthCodeTimer(
    millisInFuture: Long,
    countDownInterval: Long,
    countDownListener: CountDownListener
) : CountDownTimer(millisInFuture, countDownInterval) {

    private val mCountDownListener = countDownListener

    override fun onFinish() {
        mCountDownListener.isOverTime(true)
    }

    override fun onTick(millisUntilFinished: Long) {
        mCountDownListener.isOverTime(false)
        mCountDownListener.countDown(millisUntilFinished)
    }
}