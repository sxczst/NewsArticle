package org.sxczst.toutiao.news.ui.user.act

import org.sxczst.toutiao.news.R
import org.sxczst.toutiao.news.base.BaseActivity
import org.sxczst.toutiao.news.ui.user.presenter.LoginPresenter
import org.sxczst.toutiao.news.ui.user.view.LoginView

/**
 * @Author      :sxczst
 * @Date        :Created in 2020/12/12 9:36
 * @Description :设置新密码页面
 */
class SetNewPassActivity : BaseActivity<LoginView, LoginPresenter>(), LoginView {
    override fun getLayoutId(): Int = R.layout.activity_set_new_pass

    override fun initData() {
    }

    override fun initView() {
    }

    override fun createPresenter(): LoginPresenter? = LoginPresenter()
    override fun isRegister(): Boolean = false

    override fun <T> setData(data: T) {
    }

    override fun setError(error: String) {
    }
}