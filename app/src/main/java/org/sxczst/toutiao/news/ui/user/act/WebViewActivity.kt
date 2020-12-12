package org.sxczst.toutiao.news.ui.user.act

import org.sxczst.toutiao.news.R
import org.sxczst.toutiao.news.base.BaseActivity
import org.sxczst.toutiao.news.ui.user.model.RegisterModel
import org.sxczst.toutiao.news.ui.user.presenter.RegisterPresenter
import org.sxczst.toutiao.news.ui.user.view.RegisterView

/**
 * @Author      :sxczst
 * @Date        :Created in 2020/11/20 20:13
 * @Description :
 */
class WebViewActivity : BaseActivity<RegisterView, RegisterPresenter>(), RegisterView {
    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initData() {
    }

    override fun initView() {
    }

    override fun createPresenter(): RegisterPresenter? = RegisterPresenter()

    override fun onRegister(registerModel: RegisterModel) {
    }

    override fun isRegister(): Boolean = false

    override fun <T> setData(data: T) {
    }

    override fun setError(error: String) {
    }
}