package org.sxczst.toutiao.news.ui.main.frg

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_mine.view.*
import org.sxczst.toutiao.news.R
import org.sxczst.toutiao.news.base.BaseFragment
import org.sxczst.toutiao.news.mvp.model.EvtMsgModel
import org.sxczst.toutiao.news.ui.main.act.UpdateUserInfoActivity
import org.sxczst.toutiao.news.ui.main.adapter.CommonAdapter
import org.sxczst.toutiao.news.ui.main.model.CommonModel
import org.sxczst.toutiao.news.ui.main.model.UserInfoModel
import org.sxczst.toutiao.news.ui.main.presenter.MinePresenter
import org.sxczst.toutiao.news.ui.main.view.MineView
import org.sxczst.toutiao.news.ui.user.act.LoginNoPassActivity
import org.sxczst.toutiao.news.utils.ImageLoaderUtils

/**
 * @author      sxczst
 * @date        2021/3/14 14:41
 */
class MineFragment : BaseFragment<MineView, MinePresenter>(), MineView {

    private val mList = mutableListOf<CommonModel>()

    private lateinit var mView: View

    override fun isRegister(): Boolean {
        return true
    }

    override fun getLayoutId() = R.layout.fragment_mine

    override fun initData() {
        getPresenter()?.getCommonList(1)
        if (isTokenNotNull()) {
            getToken()?.let {
                getPresenter()?.getUserInfo(it)
            }
            mView.g_login.visibility = View.VISIBLE
            mView.btn_login.visibility = View.GONE
        } else {
            mView.g_login.visibility = View.GONE
            mView.btn_login.visibility = View.VISIBLE
        }
    }

    override fun initView(view: View) {
        mView = view
        view.btn_login.setOnClickListener {
            startActivity(LoginNoPassActivity::class.java)
            activity?.overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom)
        }
        view.iv_avatar.setOnClickListener {
            startActivity(UpdateUserInfoActivity::class.java)
        }
    }

    override fun createPresenter() = MinePresenter()

    override fun <T> setData(data: T) {
        mList.addAll(data as List<CommonModel>)
        mView.rv_common_list.layoutManager = LinearLayoutManager(activity)
        mView.rv_common_list.adapter = CommonAdapter(mList)
    }

    override fun updateUserInfo(userInfo: UserInfoModel) {
        mView.g_login.visibility = View.VISIBLE
        mView.btn_login.visibility = View.GONE
        activity?.let { ImageLoaderUtils.loadCircleImage(it, userInfo.user_url, mView.iv_avatar) }
        mView.tv_name.text = userInfo.user_login
        mView.tv_number.text =
            "头条 ${userInfo.releaseNum} 关注 ${userInfo.followNum} 粉丝 ${userInfo.fansNum}"
    }

    override fun setError(error: String) {
    }

    override fun getMessage(message: EvtMsgModel<*>) {
        super.getMessage(message)
        if (message.code == 104) {
            val token = message.msg as String
            getPresenter()?.getUserInfo(token)
        }
    }
}