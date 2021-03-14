package org.sxczst.toutiao.news.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_common_view.view.*
import org.sxczst.toutiao.news.R
import org.sxczst.toutiao.news.ui.main.model.CommonModel

/**
 * @author      sxczst
 * @date        2021/3/14 16:06
 */
class CommonAdapter(private val commonList: MutableList<CommonModel>) :
    RecyclerView.Adapter<CommonAdapter.CommonHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CommonHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_common_view, parent, false)
        )


    override fun onBindViewHolder(holder: CommonHolder, position: Int) {
        val commonModel = commonList[position]
        holder.mTitle.text = commonModel.title
        holder.mCommonList.layoutManager = GridLayoutManager(holder.itemView.context, 4)
        holder.mCommonList.adapter = CommonItemAdapter(commonModel.mCommonList)
    }

    override fun getItemCount() = commonList.size

    class CommonHolder(view: View) : RecyclerView.ViewHolder(view) {
        val mTitle: TextView = view.tv_title
        val mCommonList: RecyclerView = view.rv_common_list
    }

}