package org.sxczst.toutiao.news.mvp.model

/**
 * @Author      :sxczst
 * @Date        :Created in 2020/11/11 19:54
 * @Description :
 */
data class BaseModel<T>(
    val code: Int,
    val message: String,
    val data: T
)