package org.sxczst.toutiao.news.ui.user.presenter

import org.sxczst.toutiao.news.http.HttpUtils
import org.sxczst.toutiao.news.http.ResponseListener
import org.sxczst.toutiao.news.http.UserApi
import org.sxczst.toutiao.news.mvp.model.BaseModel
import org.sxczst.toutiao.news.mvp.presenter.BasePresenter
import org.sxczst.toutiao.news.ui.user.model.CodeModel
import org.sxczst.toutiao.news.ui.user.view.RegisterView

/**
 * @Author      :sxczst
 * @Date        :Created in 2020/11/15 8:33
 * @Description :
 */
class SendCodePresenter : BasePresenter<RegisterView>() {
    fun getCode(phoneNumber: String) {
        HttpUtils.sendHttp(
            HttpUtils.createApi(UserApi::class.java).getCode(phoneNumber),
            object : ResponseListener<BaseModel<CodeModel>> {
                override fun onSuccess(data: BaseModel<CodeModel>) {

                }

                override fun onFail(error: String) {

                }
            }
        )

    }


}