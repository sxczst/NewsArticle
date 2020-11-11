package org.sxczst.toutiao.news.ui.main.presenter

import org.sxczst.toutiao.news.mvp.presenter.BasePresenter
import org.sxczst.toutiao.news.ui.main.view.MainView

/**
 * @Author      :sxczst
 * @Date        :Created in 2020/11/11 20:21
 * @Description :
 */
class MainPresenter : BasePresenter<MainView>() {

    fun getTest(str: String) {
        getBaseView()?.setData(str)
    }
}