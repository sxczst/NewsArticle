package org.sxczst.toutiao.news.view

/**
 * @Author      :sxczst
 * @Date        :Created in 2020/11/15 9:43
 * @Description :
 */
interface CountDownListener {

    fun countDown(time: Long)

    fun isOverTime(isOverTime: Boolean)
}