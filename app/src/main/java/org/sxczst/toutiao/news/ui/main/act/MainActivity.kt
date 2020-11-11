package org.sxczst.toutiao.news.ui.main.act

import org.sxczst.toutiao.news.R
import org.sxczst.toutiao.news.base.BaseActivity
import org.sxczst.toutiao.news.ui.main.presenter.MainPresenter
import org.sxczst.toutiao.news.ui.main.view.MainView

class MainActivity : BaseActivity<MainView, MainPresenter>() {
    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initData() {
    }

    override fun init() {
    }

    override fun createPresenter() = MainPresenter()

    override fun <T> setData(data: T) {
    }

    override fun setError(error: String) {
    }
}