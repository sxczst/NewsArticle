package org.sxczst.toutiao.news.ui.user.view

import org.sxczst.toutiao.news.mvp.view.BaseView
import org.sxczst.toutiao.news.ui.user.model.RegisterModel

/**
 * @Author      :sxczst
 * @Date        :Created in 2020/11/15 8:32
 * @Description :
 */
interface SendCodeView : BaseView {

    fun onRegister(registerModel: RegisterModel)

    fun isRegister(): Boolean
}