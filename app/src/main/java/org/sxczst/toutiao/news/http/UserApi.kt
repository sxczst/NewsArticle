package org.sxczst.toutiao.news.http

import io.reactivex.Observable
import org.sxczst.toutiao.news.mvp.model.BaseModel
import org.sxczst.toutiao.news.ui.main.model.MainModel
import org.sxczst.toutiao.news.ui.user.model.CodeModel
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET

/**
 * @Author      :sxczst
 * @Date        :Created in 2020/11/11 22:21
 * @Description :
 */
interface UserApi {

    @GET("todayVideo")
    fun getTest(): Observable<BaseModel<MainModel>>


    /**
     * 获取验证码
     */
    @FormUrlEncoded
    @GET("user/news/sendCode")
    fun getCode(@Field("phoneNumber") phone: String): Observable<BaseModel<CodeModel>>
}