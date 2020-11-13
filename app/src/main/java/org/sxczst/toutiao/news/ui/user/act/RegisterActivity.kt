package org.sxczst.toutiao.news.ui.user.act

import org.sxczst.toutiao.news.R
import org.sxczst.toutiao.news.base.BaseActivity
import org.sxczst.toutiao.news.ui.user.presenter.RegisterPresenter
import org.sxczst.toutiao.news.ui.user.view.RegisterView

/**
 * @Author      :sxczst
 * @Date        :Created in 2020/11/13 18:51
 * @Description :用户注册
 */
class RegisterActivity : BaseActivity<RegisterView, RegisterPresenter>() {

    override fun getLayoutId(): Int = R.layout.activity_register

    override fun initData() {
        TODO("Not yet implemented")
    }

    override fun initView() {
        TODO("Not yet implemented")
    }

    override fun createPresenter(): RegisterPresenter? = RegisterPresenter()

    override fun <T> setData(data: T) {
        TODO("Not yet implemented")
    }

    override fun setError(error: String) {
        TODO("Not yet implemented")
    }
}