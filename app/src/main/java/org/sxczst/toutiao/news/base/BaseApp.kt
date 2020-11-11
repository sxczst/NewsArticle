package org.sxczst.toutiao.news.base

import android.app.Application
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger

/**
 * @Author      :sxczst
 * @Date        :Created in 2020/11/11 21:08
 * @Description :App 的单例，完成一些初始化工作
 */
class BaseApp : Application() {
    override fun onCreate() {
        super.onCreate()

        // 日志框架的初始化
        Logger.addLogAdapter(AndroidLogAdapter())
    }
}