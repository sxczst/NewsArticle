package org.sxczst.toutiao.news.base

/**
 * @Author      :sxczst
 * @Date        :Created in 2020/11/11 21:54
 * @Description :常量类
 */
object Constants {
    const val BASE_URL = "http://toutiao.apkbus.com/wp-json/custom/v1/"
    const val BASE_URL_TEST = "http://toutiao.apkbus.com/wp-json/custom/v1/"
//    const val BASE_URL_TEST = "https://api.apiopen.top/"

    const val HOME_BAR = 1
    const val COMMON_BAR = 2

    const val MOBILE = "mobile"

    const val WEB_URL = "web_url"
    const val WEB_TITLE = "web_title"

    const val COUNT_TIME: Long = 60 * 1000
    const val COUNT_TIME_INTERVAL: Long = 1 * 1000

    const val TOKEN = "token"

    // 用户操作
    const val USER_ACTION = "user_action"

    // 去注册操作
    const val ACTION_REGISTER = 1

    // 去登录操作
    const val ACTION_LOGIN = 2

    // 去找回密码操作
    const val ACTION_FIND_PASS = 3
}