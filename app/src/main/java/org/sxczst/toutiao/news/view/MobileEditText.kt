package org.sxczst.toutiao.news.view

import android.content.Context
import android.graphics.drawable.Drawable
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import org.sxczst.toutiao.news.R

/**
 * @Author      :sxczst
 * @Date        :Created in 2020/11/13 21:06
 * @Description :自定义手机号输入框
 */
class MobileEditText @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = R.attr.editTextStyle
) : AppCompatEditText(context, attrs, defStyleAttr) {
    /**
     * 输入框后面的小图标
     */
    private var draw: Drawable? = null
    private var drawShow: Drawable? = null

    init {
        draw = ContextCompat.getDrawable(context, R.mipmap.ic_launcher)
        draw?.apply {
            setBounds(0, 0, minimumWidth, minimumHeight)
        }
        addTextChangedListener(TextWatcherEditText())
        isShow(false)
    }

    /**
     * 是否显示图片(用于删除输入的内容)
     */
    private fun isShow(isShow: Boolean) {
        drawShow = if (isShow) {
            draw
        } else {
            null
        }
        // 设置图片位置
        setCompoundDrawables(
            compoundDrawables[0],
            compoundDrawables[1],
            drawShow,
            compoundDrawables[3]
        )
    }

    /**
     * 处理点击清空输入框内容的监听
     */
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event?.action == MotionEvent.ACTION_DOWN) {
            // 点击的是否是删除小图标
            val isDelete = event.x > (width - totalPaddingEnd) &&
                    event.x < (width - paddingEnd) &&
                    event.y > 0 &&
                    event.y < height

            if (isDelete) {
                setText("")
            }
        }
        return super.onTouchEvent(event)
    }

    private inner class TextWatcherEditText : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        /**
         * 监听输入内容改变的方法
         */
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            if (TextUtils.isEmpty(text.toString())) {
                isShow(false)
            } else {
                // 输入框有内容则显示监听删除内容动作的图片
                isShow(true)
            }
            var textContent = s.toString()
            val length = textContent.length
            // 137 5397 3040 在第三位和第七为后面添加一个空格
            if (length == 4 || length == 9) {
                textContent = if (textContent.substring(length - 1) == " ") {
                    // 输入框最后字符为空格
                    textContent.substring(0, length - 1)
                } else {
                    textContent.substring(
                        0,
                        length - 1
                    ) + " " + textContent.substring(length - 1)
                }
                setText(textContent)
                // 设置光标位置
                setSelection(textContent.length)
            }
        }
    }

}