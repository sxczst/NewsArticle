package org.sxczst.toutiao.news.ui.main.view

import org.sxczst.toutiao.news.mvp.view.BaseView
import org.sxczst.toutiao.news.ui.main.model.UserInfoModel

/**
 * @author      sxczst
 * @date        2021/3/14 15:56
 */
interface MineView : BaseView {

    fun updateUserInfo(userInfo: UserInfoModel)

}