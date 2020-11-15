package org.sxczst.toutiao.news.view

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import org.sxczst.toutiao.news.R

/**
 * @Author      :sxczst
 * @Date        :Created in 2020/11/15 10:01
 * @Description :自定义验证码输入框
 */
class CodeEditText @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = R.attr.editTextStyle
) : AppCompatEditText(context, attrs, defStyleAttr) {
    init {
        addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                var textStr = s.toString()
                val length = textStr.length
                if (length == 2) {
                    if (textStr.substring(1) == " ") {
                        setText("")
                        isCursorVisible = false
                    } else {
                        textStr = "${textStr.substring(0, 1)}  ${textStr.substring(1, 2)}"
                        setText(textStr)
                        setSelection(textStr.length)
                        isCursorVisible = true
                    }
                } else if (length == 5) {
                    if (textStr.substring(4) == " ") {
                        textStr = textStr.substring(0, 3)
                        setText(textStr)
                        setSelection(textStr.length)
                    } else {
                        textStr = "${textStr.substring(0, 4)}  ${textStr.substring(4, 5)}"
                        setText(textStr)
                        setSelection(textStr.length)
                    }
                } else if (length == 8) {
                    if (textStr.substring(7) == " ") {
                        textStr = textStr.substring(0, 6)
                        setText(textStr)
                        setSelection(textStr.length)
                    } else {
                        textStr = "${textStr.substring(0, 7)}  ${textStr.substring(7, 8)}"
                        setText(textStr)
                        setSelection(textStr.length)
                    }
                }
            }
        })
    }
}