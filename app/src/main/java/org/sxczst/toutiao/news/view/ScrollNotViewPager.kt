package org.sxczst.toutiao.news.view

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

/**
 * @Author      :sxczst
 * @Date        :Created in 2020/11/11 23:47
 * @Description : 不可滑动的ViewPager
 */
class ScrollNotViewPager(context: Context, attrs: AttributeSet) : ViewPager(context, attrs) {

    /**
     * 不向下传递事件
     */
    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        return false
    }

    /**
     * 不分发事件
     */
    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return false
    }
}