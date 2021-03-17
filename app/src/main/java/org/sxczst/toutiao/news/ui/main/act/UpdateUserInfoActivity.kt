package org.sxczst.toutiao.news.ui.main.act

import org.sxczst.toutiao.news.R
import org.sxczst.toutiao.news.base.BaseActivity
import org.sxczst.toutiao.news.ui.main.presenter.UpdateUserInfoPresenter
import org.sxczst.toutiao.news.ui.main.view.UpdateUserInfoView

/**
 * @author      sxczst
 * @date        2021/3/17 22:28
 */
class UpdateUserInfoActivity : BaseActivity<UpdateUserInfoView, UpdateUserInfoPresenter>(),
    UpdateUserInfoView {
    override fun getLayoutId() = R.layout.activity_update_user_info

    override fun initData() {
    }

    override fun initView() {
    }

    override fun createPresenter() = UpdateUserInfoPresenter()

    override fun <T> setData(data: T) {
    }

    override fun setError(error: String) {
    }
}