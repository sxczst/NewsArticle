package org.sxczst.toutiao.news.http

/**
 * @Author      :sxczst
 * @Date        :Created in 2020/11/11 22:12
 * @Description : 请求的回调监听
 */
interface ResponseListener<T> {
    /**
     * 成功
     */
    fun onSuccess(data: T)

    /**
     * 失败
     */
    fun onFail(error: String)

}