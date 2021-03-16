package org.sxczst.toutiao.news.ui.main.model

/**
 * @author      sxczst
 * @date        2021/3/16 21:18
 */
data class UserInfoModel(
    val user_login: String,
    val user_url: String,
    val releaseNum: Int,
    val followNum: Int,
    val fansNum: Int
)