package org.sxczst.toutiao.news.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_common_item_view.view.*
import org.sxczst.toutiao.news.R
import org.sxczst.toutiao.news.ui.main.model.CommonItemModel

/**
 * @author      sxczst
 * @date        2021/3/14 16:43
 */
class CommonItemAdapter(private val commonItemList: MutableList<CommonItemModel>) :
    RecyclerView.Adapter<CommonItemAdapter.CommonItemHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CommonItemHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_common_item_view, parent, false)
        )

    override fun onBindViewHolder(holder: CommonItemHolder, position: Int) {
        val commonItemModel = commonItemList[position]
        holder.mTitle.text = commonItemModel.title
    }

    override fun getItemCount() = commonItemList.size

    class CommonItemHolder(view: View) : RecyclerView.ViewHolder(view) {
        val mTitle: TextView = view.tv_title
        val mIvContent: ImageView = view.iv_content
    }
}