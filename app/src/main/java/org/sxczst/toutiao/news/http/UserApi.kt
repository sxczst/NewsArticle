package org.sxczst.toutiao.news.http

import io.reactivex.Observable
import org.sxczst.toutiao.news.mvp.model.BaseModel
import org.sxczst.toutiao.news.ui.main.model.CommonModel
import org.sxczst.toutiao.news.ui.main.model.MainModel
import org.sxczst.toutiao.news.ui.main.model.UserInfoModel
import org.sxczst.toutiao.news.ui.user.model.CodeModel
import org.sxczst.toutiao.news.ui.user.model.RegisterModel
import retrofit2.http.*

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
    @POST("user/news/sendCode")
    fun getCode(@Field("phoneNumber") phone: String): Observable<BaseModel<CodeModel>>

    /**
     * 注册接口
     */
    @FormUrlEncoded
    @POST("user/news/register")
    fun getRegister(
        @Field("phoneNumber") phone: String,
        @Field("verificationCode") code: String,
        // 当前设备唯一标识
        @Field("onlyIdentifier") ider: Int,
        /**
         * 1. 账号注册
         * 2. 手机登录
         * 3. 密码登录
         * 4. 微信登录
         * 5. QQ登录
         * 6. 一键登录
         * 7. 邮箱登录
         */
        @Field("type") type: Int
    ): Observable<BaseModel<RegisterModel>>

    /**
     * 密码登录接口
     */
    @FormUrlEncoded
    @POST("user/news/register")
    fun getPassLogin(
        @Field("phoneNumber") phone: String,
        @Field("passWord") code: String,
        // 当前设备唯一标识
        @Field("onlyIdentifier") ider: Int,
        /**
         * 1. 账号注册
         * 2. 手机登录
         * 3. 密码登录
         * 4. 微信登录
         * 5. QQ登录
         * 6. 一键登录
         * 7. 邮箱登录
         */
        @Field("type") type: Int
    ): Observable<BaseModel<RegisterModel>>

    /**
     * 找回密码接口
     */
    @FormUrlEncoded
    @POST("user/forget/password")
    fun getFindPass(
        @Field("phoneNumber") phone: String,
        @Field("passWord") password: String,
        @Field("verificationCode") code: String
    ): Observable<BaseModel<RegisterModel>>

    /**
     * 获取我的列表
     */
    @GET("user/news/myList")
    fun getCommonList(@Query("type") type: Int)
            : Observable<BaseModel<List<CommonModel>>>

    /**
     * 获取用户信息
     */
    @GET("user/news/mineInformation")
    fun getUserInfo(@Header("token") token: String)
            : Observable<BaseModel<UserInfoModel>>

}