package org.sxczst.toutiao.news.ui.user.act

import kotlinx.android.synthetic.main.activity_privacy_settings.*
import org.sxczst.toutiao.news.R
import org.sxczst.toutiao.news.base.BaseActivity
import org.sxczst.toutiao.news.mvp.view.BaseView
import org.sxczst.toutiao.news.ui.user.presenter.PrivacySettingsPresenter

/**
 * @author      sxczst
 * @date        2021/3/13 10:16
 */
class PrivacySettingsActivity : BaseActivity<BaseView, PrivacySettingsPresenter>() {

    override fun getLayoutId(): Int = R.layout.activity_privacy_settings

    override fun initData() {
    }

    override fun initView() {
        siv_recommend_people_you_know.setBackgroundSettingsItem(R.color.c_fffad9)
    }

    override fun createPresenter(): PrivacySettingsPresenter = PrivacySettingsPresenter()

    override fun <T> setData(data: T) {
    }

    override fun setError(error: String) {
    }

}