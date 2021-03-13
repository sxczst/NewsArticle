package org.sxczst.toutiao.news.view

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.item_settings_view.view.*
import org.sxczst.toutiao.news.R

/**
 * @author      sxczst
 * @date        2021/3/12 21:01
 */
class SettingsItemView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    private var leftTitle: String? = ""
    private var rightTitle: String? = ""
    private var contentTitle: String? = ""

    private var isShowButton: Boolean = false
    private var isShowImage: Boolean = false

    private var settingsArray: TypedArray =
        context.obtainStyledAttributes(attrs, R.styleable.SettingsItemView)

    private lateinit var view: View

    init {
        leftTitle = settingsArray.getString(R.styleable.SettingsItemView_leftTitle)
        rightTitle = settingsArray.getString(R.styleable.SettingsItemView_rightTitle)
        contentTitle = settingsArray.getString(R.styleable.SettingsItemView_contentTitle)

        isShowButton = settingsArray.getBoolean(R.styleable.SettingsItemView_isShowButton, false)
        isShowImage = settingsArray.getBoolean(R.styleable.SettingsItemView_isShowImage, false)
        settingsArray.recycle()
        initView()
    }

    private fun initView() {
        view = LayoutInflater.from(context).inflate(R.layout.item_settings_view, this)
        view.tv_left_title.text = leftTitle
        setContentTitle(view)
        view.tv_right_title.text = rightTitle
        isShowButton(view)
        isShowImage(view)
    }

    private fun setContentTitle(view: View) {
        view.tv_content_title.text = contentTitle
        if (view.tv_content_title.text.isEmpty()) {
            view.tv_content_title.visibility = GONE
        } else {
            view.tv_content_title.visibility = VISIBLE
        }
    }

    private fun isShowButton(view: View) {
        if (isShowButton) {
            view.btn_off.visibility = VISIBLE
        } else {
            view.btn_off.visibility = GONE
        }
    }

    private fun isShowImage(view: View) {
        if (isShowImage) {
            view.iv_right_back.visibility = VISIBLE
        } else {
            view.iv_right_back.visibility = GONE
        }
    }

    fun setBackgroundSettingsItem(@ColorRes colorIds: Int) {
        view.cl_item.setBackgroundColor(ContextCompat.getColor(context, colorIds))
    }

}