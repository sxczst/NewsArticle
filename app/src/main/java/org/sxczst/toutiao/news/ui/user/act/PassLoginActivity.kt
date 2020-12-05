package org.sxczst.toutiao.news.ui.user.act

import kotlinx.android.synthetic.main.activity_pass_login.*
import org.sxczst.toutiao.news.R
import org.sxczst.toutiao.news.base.BaseActivity
import org.sxczst.toutiao.news.ui.user.presenter.LoginPresenter
import org.sxczst.toutiao.news.ui.user.view.LoginView

/**
 * @Author      :sxczst
 * @Date        :Created in 2020/11/28 20:18
 * @Description :密码登录页面
 */
class PassLoginActivity : BaseActivity<LoginView, LoginPresenter>(), LoginView {
    override fun getLayoutId(): Int = R.layout.activity_pass_login

    override fun initData() {
        my_check_box.initSpan(R.string.login_agreement)
        my_check_box.isShow(false)

    }

    override fun initView() {
    }

    override fun createPresenter(): LoginPresenter? = LoginPresenter()

    override fun <T> setData(data: T) {
    }

    override fun setError(error: String) {
    }
}