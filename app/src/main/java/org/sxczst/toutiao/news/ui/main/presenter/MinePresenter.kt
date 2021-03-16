package org.sxczst.toutiao.news.ui.main.presenter

import org.sxczst.toutiao.news.http.HttpUtils
import org.sxczst.toutiao.news.http.ResponseListener
import org.sxczst.toutiao.news.http.UserApi
import org.sxczst.toutiao.news.mvp.model.BaseModel
import org.sxczst.toutiao.news.mvp.presenter.BasePresenter
import org.sxczst.toutiao.news.ui.main.model.CommonModel
import org.sxczst.toutiao.news.ui.main.model.UserInfoModel
import org.sxczst.toutiao.news.ui.main.view.MineView

/**
 * @author      sxczst
 * @date        2021/3/14 15:55
 */
class MinePresenter : BasePresenter<MineView>() {

    /**
     * 获取我的列表
     */
    fun getCommonList(type: Int) {
        HttpUtils.sendHttp(HttpUtils.createApi(UserApi::class.java).getCommonList(type),
            object : ResponseListener<BaseModel<List<CommonModel>>> {
                override fun onSuccess(data: BaseModel<List<CommonModel>>) {
                    if (data.code == 100) {
                        getBaseView()?.setData(data)
                    }
                }

                override fun onFail(error: String) {
                    getBaseView()?.setError(error)
                }
            })
    }

    /**
     * 获取用户信息
     */
    fun getUserInfo(token: String) {
        HttpUtils.sendHttp(HttpUtils.createApi(UserApi::class.java).getUserInfo(token),
            object : ResponseListener<BaseModel<UserInfoModel>> {
                override fun onSuccess(data: BaseModel<UserInfoModel>) {
                    if (data.code == 100) {
                        getBaseView()?.updateUserInfo(data.data)
                    }
                }

                override fun onFail(error: String) {
                    getBaseView()?.setError(error)
                }
            })
    }
}