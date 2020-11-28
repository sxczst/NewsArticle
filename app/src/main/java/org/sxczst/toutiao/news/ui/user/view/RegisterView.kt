package org.sxczst.toutiao.news.ui.user.view

import org.sxczst.toutiao.news.mvp.view.BaseView
import org.sxczst.toutiao.news.ui.user.model.RegisterModel

/**
 * @Author      :sxczst
 * @Date        :Created in 2020/11/13 18:51
 * @Description :用户注册
 */
interface RegisterView : BaseView {
    fun onRegister(registerModel: RegisterModel)

    fun isRegister(): Boolean
}