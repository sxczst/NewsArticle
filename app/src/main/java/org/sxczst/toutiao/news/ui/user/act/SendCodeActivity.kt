package org.sxczst.toutiao.news.ui.user.act

import org.sxczst.toutiao.news.R
import org.sxczst.toutiao.news.base.BaseActivity
import org.sxczst.toutiao.news.ui.user.presenter.SendCodePresenter
import org.sxczst.toutiao.news.ui.user.view.SendCodeView

/**
 * @Author      :sxczst
 * @Date        :Created in 2020/11/15 8:28
 * @Description :发送手机验证码
 */
class SendCodeActivity : BaseActivity<SendCodeView, SendCodePresenter>() {
    override fun getLayoutId(): Int = R.layout.activity_send_code

    override fun initData() {
    }

    override fun initView() {
    }

    override fun createPresenter(): SendCodePresenter? = SendCodePresenter()

    override fun <T> setData(data: T) {
    }

    override fun setError(error: String) {
    }
}