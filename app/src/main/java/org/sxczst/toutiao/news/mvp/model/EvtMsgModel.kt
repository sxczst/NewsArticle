package org.sxczst.toutiao.news.mvp.model

/**
 * @Author      :sxczst
 * @Date        :Created in 2020/11/20 19:32
 * @Description :事件消息
 */
data class EvtMsgModel<T>(var code: Int, var msg: T)