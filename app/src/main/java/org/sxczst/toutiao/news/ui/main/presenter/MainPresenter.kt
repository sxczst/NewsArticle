package org.sxczst.toutiao.news.ui.main.presenter

import org.sxczst.toutiao.news.http.HttpUtils
import org.sxczst.toutiao.news.http.ResponseListener
import org.sxczst.toutiao.news.http.UserApi
import org.sxczst.toutiao.news.mvp.model.BaseModel
import org.sxczst.toutiao.news.mvp.presenter.BasePresenter
import org.sxczst.toutiao.news.ui.main.model.MainModel
import org.sxczst.toutiao.news.ui.main.view.MainView

/**
 * @Author      :sxczst
 * @Date        :Created in 2020/11/11 20:21
 * @Description :
 */
class MainPresenter : BasePresenter<MainView>() {

    fun getTest(str: String) {
        HttpUtils.sendHttp(HttpUtils.createApi(UserApi::class.java).getTest(), object :
            ResponseListener<BaseModel<MainModel>> {
            override fun onSuccess(data: BaseModel<MainModel>) {
                getBaseView()?.setData(data)
            }

            override fun onFail(error: String) {
                getBaseView()?.setError(error)
            }
        })
    }
}