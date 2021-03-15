package org.sxczst.toutiao.news.ui.main.frg

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_mine.view.*
import org.sxczst.toutiao.news.R
import org.sxczst.toutiao.news.base.BaseFragment
import org.sxczst.toutiao.news.ui.main.adapter.CommonAdapter
import org.sxczst.toutiao.news.ui.main.model.CommonModel
import org.sxczst.toutiao.news.ui.main.presenter.MinePresenter
import org.sxczst.toutiao.news.ui.main.view.MineView
import org.sxczst.toutiao.news.ui.user.act.LoginNoPassActivity

/**
 * @author      sxczst
 * @date        2021/3/14 14:41
 */
class MineFragment : BaseFragment<MineView, MinePresenter>(), MineView {

    private val mList = mutableListOf<CommonModel>()

    private lateinit var mView: View

    override fun getLayoutId() = R.layout.fragment_mine

    override fun initData() {
        getPresenter()?.getCommonList(1)
    }

    override fun initView(view: View) {
        mView = view
        view.btn_login.setOnClickListener {
            startActivity(LoginNoPassActivity::class.java)
            activity?.overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom)
        }
    }

    override fun createPresenter() = MinePresenter()

    override fun <T> setData(data: T) {
        mList.addAll(data as List<CommonModel>)
        mView.rv_common_list.layoutManager = LinearLayoutManager(activity)
        mView.rv_common_list.adapter = CommonAdapter(mList)
    }

    override fun setError(error: String) {
    }
}