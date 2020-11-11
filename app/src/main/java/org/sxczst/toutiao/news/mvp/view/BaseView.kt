package org.sxczst.toutiao.news.mvp.view

/**
 * @Author      :sxczst
 * @Date        :Created in 2020/11/11 19:51
 * @Description :
 */
interface BaseView {
    /**
     * 设置视图数据
     */
    fun <T> setData(data: T)

    /**
     * 设置错误信息
     */
    fun setError(error: String)
}