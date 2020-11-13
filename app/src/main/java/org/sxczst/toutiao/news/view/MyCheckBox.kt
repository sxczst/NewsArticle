package org.sxczst.toutiao.news.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import org.sxczst.toutiao.news.R

/**
 * @Author      :sxczst
 * @Date        :Created in 2020/11/13 22:12
 * @Description :自定义用户协议复选框
 */
class MyCheckBox @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    /**
     * 是否选中
     */
    private var isChecked = false

    /**
     * 选中状态的图片
     */
    private var isSelected = R.mipmap.ic_launcher

    /**
     * 未选中状态的图片
     */
    private var isUnSelected = R.mipmap.ic_launcher

    init {
        // 加载布局文件
        val view = View.inflate(context, R.layout.my_check_box, null)
    }
}