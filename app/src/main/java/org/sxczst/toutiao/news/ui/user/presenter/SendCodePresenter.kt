package org.sxczst.toutiao.news.ui.user.presenter

import org.sxczst.toutiao.news.http.HttpUtils
import org.sxczst.toutiao.news.http.ResponseListener
import org.sxczst.toutiao.news.http.UserApi
import org.sxczst.toutiao.news.mvp.model.BaseModel
import org.sxczst.toutiao.news.mvp.presenter.BasePresenter
import org.sxczst.toutiao.news.ui.user.model.CodeModel
import org.sxczst.toutiao.news.ui.user.model.RegisterModel
import org.sxczst.toutiao.news.ui.user.view.SendCodeView

/**
 * @Author      :sxczst
 * @Date        :Created in 2020/11/15 8:33
 * @Description :
 */
class SendCodePresenter : BasePresenter<SendCodeView>() {

    fun getCode(phoneNumber: String) {
        HttpUtils.sendHttp(
            HttpUtils.createApi(UserApi::class.java).getCode(phoneNumber),
            object : ResponseListener<BaseModel<CodeModel>> {
                override fun onSuccess(data: BaseModel<CodeModel>) {
                    if (data.code == 100) {
                        getBaseView()?.setData(data.data)
                    }
                }

                override fun onFail(error: String) {
                    getBaseView()?.setError(error)
                }
            }
        )

    }


    /**
     * 账号注册
     */
    fun getRegister(phone: String, code: String, type: Int) {
        HttpUtils.sendHttp(HttpUtils.createApi(UserApi::class.java)
            .getRegister(phone, code, 1, type),
            object : ResponseListener<BaseModel<RegisterModel>> {
                override fun onSuccess(data: BaseModel<RegisterModel>) {
                    if (data.code == 100) {
                        getBaseView()?.onRegister(data.data)
                    }
                }

                override fun onFail(error: String) {
                    getBaseView()?.setError(error)
                }
            })
    }


}