package org.sxczst.toutiao.news.ui.main.act

import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import org.sxczst.toutiao.news.R
import org.sxczst.toutiao.news.base.BaseActivity
import org.sxczst.toutiao.news.ui.main.presenter.MainPresenter
import org.sxczst.toutiao.news.ui.main.view.MainView

class MainActivity : BaseActivity<MainView, MainPresenter>(), MainView {
    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initData() {
    }

    override fun init() {
        tv_test.setOnClickListener {
            getPresenter()?.getTest("test")
        }
    }

    override fun createPresenter() = MainPresenter()

    override fun <T> setData(data: T) {
        Log.e(TAG, "setData: test : =====>$data")
    }

    override fun setError(error: String) {

    }

    companion object {
        private const val TAG = "MainActivity"
    }
}