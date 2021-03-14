package org.sxczst.toutiao.news.ui.main.frg

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_mine.view.*
import org.sxczst.toutiao.news.R
import org.sxczst.toutiao.news.base.BaseFragment
import org.sxczst.toutiao.news.ui.main.adapter.CommonAdapter
import org.sxczst.toutiao.news.ui.main.model.CommonItemModel
import org.sxczst.toutiao.news.ui.main.model.CommonModel
import org.sxczst.toutiao.news.ui.main.presenter.MinePresenter
import org.sxczst.toutiao.news.ui.main.view.MineView

/**
 * @author      sxczst
 * @date        2021/3/14 14:41
 */
class MineFragment : BaseFragment<MineView, MinePresenter>(), MineView {

    private val mCommonList = mutableListOf<CommonItemModel>()
    private val mCommonList1 = mutableListOf<CommonItemModel>()
    private val mList = mutableListOf<CommonModel>()

    override fun getLayoutId() = R.layout.fragment_mine

    override fun initData() {
    }

    override fun initView(view: View) {
        val item = CommonItemModel("我的关注", "")
        mCommonList.add(item)
        val item1 = CommonItemModel("全民抽奖", "")
        mCommonList1.add(item1)

        val commonModel = CommonModel("常用", mCommonList)
        mList.add(commonModel)
        val commonModel1 = CommonModel("发现", mCommonList1)
        mList.add(commonModel1)

        view.rv_common_list.layoutManager = LinearLayoutManager(activity)
        view.rv_common_list.adapter = CommonAdapter(mList)
    }

    override fun createPresenter() = MinePresenter()

    override fun <T> setData(data: T) {
    }

    override fun setError(error: String) {
    }
}