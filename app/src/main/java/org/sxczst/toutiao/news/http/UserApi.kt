package org.sxczst.toutiao.news.http

import io.reactivex.Observable
import org.sxczst.toutiao.news.mvp.model.BaseModel
import org.sxczst.toutiao.news.ui.main.model.MainModel
import retrofit2.http.GET

/**
 * @Author      :sxczst
 * @Date        :Created in 2020/11/11 22:21
 * @Description :
 */
interface UserApi {

    @GET("journalismApi")
    fun getTest(): Observable<BaseModel<MainModel>>
}