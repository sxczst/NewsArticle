package org.sxczst.toutiao.news.ui.user.presenter

import org.sxczst.toutiao.news.http.HttpUtils
import org.sxczst.toutiao.news.http.ResponseListener
import org.sxczst.toutiao.news.http.UserApi
import org.sxczst.toutiao.news.mvp.model.BaseModel
import org.sxczst.toutiao.news.mvp.presenter.BasePresenter
import org.sxczst.toutiao.news.ui.user.model.RegisterModel
import org.sxczst.toutiao.news.ui.user.view.LoginView

/**
 * @Author      :sxczst
 * @Date        :Created in 2020/12/5 16:25
 * @Description :
 */
class LoginPresenter : BasePresenter<LoginView>() {
    /**
     * 登录操作
     */
    fun getLogin(phone: String, pass: String) {
        HttpUtils.sendHttp(
            HttpUtils.createApi(UserApi::class.java).getPassLogin(
                phone,
                pass,
                1,
                3
            ),
            object : ResponseListener<BaseModel<RegisterModel>> {
                override fun onSuccess(data: BaseModel<RegisterModel>) {
                    if (data != null) {
                        if (data.code == 100) {
                            getBaseView()?.setData(data.data)
                        }
                    }
                }

                override fun onFail(error: String) {
                    getBaseView()?.setError(error)
                }
            }
        )
    }

    /**
     * 修改密码
     */
    fun getFindPass(phone: String, code: String, password: String) {
        HttpUtils.sendHttp(
            HttpUtils.createApi(UserApi::class.java).getFindPass(
                phone,
                password,
                code
            ),
            object : ResponseListener<BaseModel<RegisterModel>> {
                override fun onSuccess(data: BaseModel<RegisterModel>) {
                    if (data != null) {
                        if (data.code == 100) {
                            getBaseView()?.setData(data.data)
                        }
                    }
                }

                override fun onFail(error: String) {
                    getBaseView()?.setError(error)
                }
            }
        )
    }
}