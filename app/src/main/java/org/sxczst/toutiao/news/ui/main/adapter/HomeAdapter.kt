package org.sxczst.toutiao.news.ui.main.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 * @Author      :sxczst
 * @Date        :Created in 2020/11/11 23:36
 * @Description :
 */
class HomeAdapter(fm: FragmentManager, fragments: ArrayList<Fragment>) : FragmentPagerAdapter(fm) {
    private val fragments: ArrayList<Fragment> = fragments
    override fun getItem(position: Int): Fragment = fragments[position]
    override fun getCount(): Int = fragments.size
}