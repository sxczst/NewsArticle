package org.sxczst.toutiao.news.ui.main.frg

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.sxczst.toutiao.news.R

/**
 * @author      sxczst
 * @date        2021/3/14 14:41
 */
class MineFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_mine, container, false)
    }
}