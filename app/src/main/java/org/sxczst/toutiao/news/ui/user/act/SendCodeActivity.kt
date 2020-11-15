package org.sxczst.toutiao.news.ui.user.act

import kotlinx.android.synthetic.main.activity_send_code.*
import org.sxczst.toutiao.news.R
import org.sxczst.toutiao.news.base.BaseActivity
import org.sxczst.toutiao.news.base.Constants.COUNT_TIME
import org.sxczst.toutiao.news.base.Constants.COUNT_TIME_INTERVAL
import org.sxczst.toutiao.news.ui.user.presenter.SendCodePresenter
import org.sxczst.toutiao.news.ui.user.view.SendCodeView
import org.sxczst.toutiao.news.utils.AuthCodeTimer
import org.sxczst.toutiao.news.view.CountDownListener

/**
 * @Author      :sxczst
 * @Date        :Created in 2020/11/15 8:28
 * @Description :发送手机验证码
 */
class SendCodeActivity : BaseActivity<SendCodeView, SendCodePresenter>(), SendCodeView,
    CountDownListener {

    private var mAuthCodeTimer: AuthCodeTimer? = null

    override fun getLayoutId(): Int = R.layout.activity_send_code

    override fun initData() {
    }

    override fun initView() {
        mAuthCodeTimer = AuthCodeTimer(COUNT_TIME, COUNT_TIME_INTERVAL, this)
        mAuthCodeTimer?.start()
    }

    override fun createPresenter(): SendCodePresenter? = SendCodePresenter()

    override fun <T> setData(data: T) {
    }

    override fun setError(error: String) {
    }

    override fun countDown(time: Long) {
        // 跟新当前数值
        val s = "重新获取(${time / 1000})秒"
        tv_reacquire.text = s

        // 不可用
        tv_reacquire.isEnabled = false
    }

    override fun isOverTime(isOverTime: Boolean) {
        if (isOverTime) {
            tv_reacquire.text = "重新获取"
            tv_reacquire.isEnabled = true
        }
    }
}