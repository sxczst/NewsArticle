package org.sxczst.toutiao.news.ui.main.model

import com.flyco.tablayout.listener.CustomTabEntity

/**
 * @Author      :sxczst
 * @Date        :Created in 2020/11/11 23:28
 * @Description : 底部标签数据类
 */
data class TitleModel(
    val title: String,
    val select: Int,
    val unSelect: Int
) : CustomTabEntity {
    override fun getTabUnselectedIcon(): Int = unSelect
    override fun getTabSelectedIcon(): Int = select
    override fun getTabTitle(): String = title
}