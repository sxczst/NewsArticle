package org.sxczst.toutiao.news.http

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.sxczst.toutiao.news.base.Constants
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @Author      :sxczst
 * @Date        :Created in 2020/11/11 21:11
 * @Description :网络工具类
 */
object HttpUtils {
    private var mOkHttpClient: OkHttpClient? = null
    private fun isTest(isTest: Boolean): String =
        if (isTest) Constants.BASE_URL_TEST else Constants.BASE_URL

    fun <T> createApi(clazz: Class<T>): T =
        Retrofit.Builder()
            .baseUrl(isTest(true))
            .client(getClient())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(clazz)

    private fun getClient(): OkHttpClient? {
        if (mOkHttpClient == null) {
            mOkHttpClient = OkHttpClient.Builder()
                .addInterceptor(getInterceptor())
                .retryOnConnectionFailure(true)
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .build()
        }
        return mOkHttpClient;
    }

    /**
     * 创建拦截器
     * 打印 Json 数据
     */
    private fun getInterceptor(): Interceptor {
        // 打印Json

        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    /**
     * @param ob 被观察者，携带数据
     * @param listener 回调
     */
    fun <T> sendHttp(ob: Observable<T>, listener: ResponseListener<T>) {
        /**
         * 线程操作
         * 1. IO 流
         * 2. 主线程
         */
        ob.subscribeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<T> {
                override fun onComplete() {
                }

                override fun onSubscribe(d: Disposable?) {
                }

                override fun onNext(value: T) {
                    listener.onSuccess(value)
                }

                override fun onError(e: Throwable?) {
                    listener.onFail(e?.message.toString())
                }
            })
    }
}