package org.sxczst.toutiao.news.view

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
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
        context.obtainStyledAttributes(attrs, R.styleable.SettingsItem)

    init {
        leftTitle = settingsArray.getString(R.styleable.SettingsItem_leftTitle)
        rightTitle = settingsArray.getString(R.styleable.SettingsItem_rightTitle)
        contentTitle = settingsArray.getString(R.styleable.SettingsItem_contentTitle)

        isShowButton = settingsArray.getBoolean(R.styleable.SettingsItem_isShowButton, false)
        isShowImage = settingsArray.getBoolean(R.styleable.SettingsItem_isShowImage, false)
        settingsArray.recycle()
        initView()
    }

    private fun initView() {
        val view = LayoutInflater.from(context).inflate(R.layout.item_settings_view, this)
    }

}