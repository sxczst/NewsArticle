package org.sxczst.toutiao.news.utils

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import org.sxczst.toutiao.news.base.Constants

/**
 * @Author      :sxczst
 * @Date        :Created in 2020/11/13 18:34
 * @Description :状态栏颜色
 */
object StatusBarUtils {

    private var flags: Int = View.SYSTEM_UI_FLAG_LAYOUT_STABLE

    /**
     * 修改状态栏颜色
     * @param colorIds 颜色资源Id
     */
    fun setStatusBar(activity: Activity, barType: Int, @ColorRes colorIds: Int) {
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

    fun setStatus(activity: Activity, barType: Int, @ColorRes colorIds: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            var window = activity.window
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.TRANSPARENT
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                flags = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            }
            activity.window.decorView.systemUiVisibility = flags
            /**
             * 设置暗色，文字为深色背景透明 View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
             * 设置亮色，文字为白色背景透明 View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
             */
            setUIVisibility(window, barType)
            setColor(window, ContextCompat.getColor(activity, colorIds))
        }
    }

    private fun setUIVisibility(window: Window, status: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.decorView.systemUiVisibility = status
        }
    }

    private fun setColor(window: Window, color: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = color
        }
    }
}