package org.sxczst.toutiao.news.utils

import java.util.regex.Pattern

/**
 * @Author      :sxczst
 * @Date        :Created in 2020/11/14 22:59
 * @Description :常用工具类
 */
object CommonUtils {
    private const val regExp =
        "/\\^(13[0-9]|14[01456879]|15[0-3,5-9]|16[2567]|17[0-8]|18[0-9]|19[0-3,5-9])\\d{8}\\$/"

    /**
     * 手机号正则
     */
    fun checkMobile(mobile: String): Boolean = Pattern.compile(regExp).matcher(mobile).matches()

    /**
     * 去除空格
     */
    fun replaceBlank(str: String): String {
        val compile = Pattern.compile("\\s*|\t|\r|\n")
        val matcher = compile.matcher(str)
        return matcher.replaceAll("")
    }
}