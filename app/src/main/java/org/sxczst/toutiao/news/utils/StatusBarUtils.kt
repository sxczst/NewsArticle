package org.sxczst.toutiao.news.utils

import android.app.Activity
import android.os.Build
import android.view.View
import androidx.core.content.ContextCompat
import org.sxczst.toutiao.news.base.Constants

/**
 * @Author      :sxczst
 * @Date        :Created in 2020/11/13 18:34
 * @Description :状态栏颜色
 */
object StatusBarUtils {

    fun setStatusBar(activity: Activity, barType: Int, colorIds: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (barType == Constants.HOME_BAR) {
                // 首页状态栏样式
                activity.window.decorView.systemUiVisibility =
                    View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
            } else {
                // 其他页面状态栏样式
                activity.window.decorView.systemUiVisibility =
                    View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }
            // 设置颜色
            activity.window.statusBarColor = ContextCompat.getColor(activity, colorIds)
        }
    }
}