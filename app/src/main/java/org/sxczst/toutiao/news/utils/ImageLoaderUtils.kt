package org.sxczst.toutiao.news.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

/**
 * @author      sxczst
 * @date        2021/3/15 21:44
 */
object ImageLoaderUtils {

    /**
     * 加载普通图片
     */
    fun loadImage(context: Context, url: String, iv: ImageView) {
        Glide.with(context)
            .load(url)
            .into(iv)
    }

    /**
     * 加载圆角图片
     */
    fun loadRoundImage(context: Context, url: String, iv: ImageView, radius: Int) {
        Glide.with(context)
            .load(url)
            .apply(RequestOptions.bitmapTransform(RoundedCorners(radius)))
            .into(iv)
    }

    /**
     * 加载圆形图片
     */
    fun loadCircleImage(context: Context, url: String, iv: ImageView) {
        Glide.with(context)
            .load(url)
            .apply(RequestOptions.circleCropTransform())
            .into(iv)
    }
}