package org.sxczst.toutiao.news.view

import android.content.Context
import android.graphics.Color
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.my_check_box.view.*
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
    private var isUnSelected = android.R.drawable.checkbox_off_background

    /**
     * Span 文本点击回调
     */
    private var mClickableSpanText: ClickableSpanText? = null

    init {
        // 加载布局文件
        val view = View.inflate(context, R.layout.my_check_box, null)
        addView(view)
        // 局部文字变色
        initSpan()
        // 默认未选中
        setChecked(false)
    }

    /**
     * 局部文字变色以及点击事件
     * 其他实现方法：得到关键字 设置颜色和点击事件
     */
    fun initSpan() {
        val span = SpannableString(resources.getString(R.string.register_protocol))
        // 两个字符串的颜色变化，不同的点击事件。
        span.setSpan(object : ClickableSpan() {
            override fun onClick(widget: View) {
                // 用户协议的点击事件
                mClickableSpanText?.onClick(1)
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.color = ContextCompat.getColor(context, R.color.c_222222)
                // 取掉下划线
                ds.isUnderlineText = false
            }
        }, 7, 13, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        span.setSpan(object : ClickableSpan() {
            override fun onClick(widget: View) {
                // 隐私政策的点击事件
                mClickableSpanText?.onClick(2)
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.color = ContextCompat.getColor(context, R.color.c_222222)
                // 取掉下划线
                ds.isUnderlineText = false
            }
        }, 14, 20, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        // 设置模式
        text.movementMethod = LinkMovementMethod.getInstance()
        // 设为透明
        text.highlightColor = Color.TRANSPARENT
        text.text = span
    }

    /**
     * 改变复选框状态
     */
    fun changeState() {
        // 取反
        isChecked = !isChecked
        if (isChecked) {
            image.setImageResource(isSelected)
        } else {
            image.setImageResource(isUnSelected)
        }
    }

    /**
     * 获取当前复选框的 状态
     */
    fun isChecked() = isChecked

    /**
     * 设置 复选框的状态
     */
    fun setChecked(isChecked: Boolean) {
        this.isChecked = isChecked
        if (isChecked) {
            image.setImageResource(isSelected)
        } else {
            image.setImageResource(isUnSelected)
        }
    }

    /**
     * Span 点击回调
     */
    interface ClickableSpanText {
        fun onClick(type: Int)
    }

    /**
     * 设置点击回调监听
     */
    fun setClickableSpanText(clickableSpanText: ClickableSpanText) {
        mClickableSpanText = clickableSpanText
    }
}