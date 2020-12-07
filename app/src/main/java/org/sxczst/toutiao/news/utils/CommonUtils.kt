package org.sxczst.toutiao.news.utils

import java.util.regex.Pattern

/**
 * @Author      :sxczst
 * @Date        :Created in 2020/11/14 22:59
 * @Description :常用工具类
 */
object CommonUtils {
    private val regExp =
        "^(13[0-9]|14[5|7]|15[0|1|2|3|4|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}\$".toRegex()

    /**
     * 手机号正则
     */
    fun checkMobile(mobile: String): Boolean =
        Pattern.compile(regExp.toString()).matcher(mobile).matches()

    /**
     * 去除空格
     */
    fun replaceBlank(str: String): String {
        val compile = Pattern.compile("\\s*|\t|\r|\n")
        val matcher = compile.matcher(str)
        return matcher.replaceAll("")
    }
}