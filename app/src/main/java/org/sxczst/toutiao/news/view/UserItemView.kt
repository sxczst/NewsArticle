package org.sxczst.toutiao.news.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.item_user_info_view.view.*
import org.sxczst.toutiao.news.R
import org.sxczst.toutiao.news.utils.ImageLoaderUtils

/**
 * @author      sxczst
 * @date        2021/3/17 21:59
 */
class UserItemView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    private var leftTitle: String? = ""
    private var isShowImage = false
    private lateinit var view: View
    private val userItemArray = context.obtainStyledAttributes(attrs, R.styleable.UserItemView)
    private var userOnClickListener: UserOnClickListener? = null

    init {
        leftTitle = userItemArray.getString(R.styleable.UserItemView_user_left_title)
        isShowImage = userItemArray.getBoolean(R.styleable.UserItemView_user_image_show, false)
        userItemArray.recycle()
        initView()
    }

    private fun initView() {
        view = LayoutInflater.from(context).inflate(R.layout.item_user_info_view, this)
        view.tv_left_title.text = leftTitle
        view.setOnClickListener {
            userOnClickListener?.userOnClick(it)
        }
        isShowImage()
    }

    private fun isShowImage() {
        if (isShowImage) {
            view.iv_avatar.visibility = View.VISIBLE
            view.tv_right_content.visibility = View.GONE
        } else {
            view.iv_avatar.visibility = View.GONE
            view.tv_right_content.visibility = View.VISIBLE
        }
    }

    fun setImageView(url: String) {
        ImageLoaderUtils.loadCircleImage(context, url, view.iv_avatar)
    }

    fun setRightContentText(content: String) {
        view.tv_right_content.text = content
    }

    fun setRightContentColor(@ColorRes color: Int) {
        view.tv_right_content.setTextColor(ContextCompat.getColor(context, color))
    }

    fun setUserOnClickListener(userOnClickListener: UserOnClickListener) {
        this.userOnClickListener = userOnClickListener
    }

    interface UserOnClickListener {
        fun userOnClick(view: View)
    }
}