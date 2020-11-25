package org.sxczst.toutiao.news.ui.user.act

import org.sxczst.toutiao.news.R
import org.sxczst.toutiao.news.base.BaseActivity
import org.sxczst.toutiao.news.ui.user.presenter.RegisterPresenter
import org.sxczst.toutiao.news.ui.user.view.RegisterView

/**
 * @Author      :sxczst
 * @Date        :Created in 2020/11/20 20:13
 * @Description :
 */
class LoginNoPassActivity : BaseActivity<RegisterView, RegisterPresenter>(), RegisterView {
    override fun getLayoutId(): Int = R.layout.activity_login_no_pass

    override fun initData() {
    }

    override fun initView() {
    }

    override fun createPresenter(): RegisterPresenter? = RegisterPresenter()

    override fun <T> setData(data: T) {
    }

    override fun setError(error: String) {
    }
}