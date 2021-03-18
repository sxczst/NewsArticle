package org.sxczst.toutiao.news.ui.main.act

import android.view.View
import kotlinx.android.synthetic.main.activity_update_user_info.*
import org.sxczst.toutiao.news.R
import org.sxczst.toutiao.news.base.BaseActivity
import org.sxczst.toutiao.news.ui.main.presenter.UpdateUserInfoPresenter
import org.sxczst.toutiao.news.ui.main.view.UpdateUserInfoView
import org.sxczst.toutiao.news.view.DialogFragmentListener
import org.sxczst.toutiao.news.view.PhotoDialog
import org.sxczst.toutiao.news.view.UserItemView

/**
 * @author      sxczst
 * @date        2021/3/17 22:28
 */
class UpdateUserInfoActivity : BaseActivity<UpdateUserInfoView, UpdateUserInfoPresenter>(),
    UpdateUserInfoView {
    private val mPhoto = PhotoDialog()

    override fun getLayoutId() = R.layout.activity_update_user_info

    override fun initData() {
    }

    override fun initView() {
        mPhoto.setDialogFragmentListener(object : DialogFragmentListener {
            override fun onDialog(type: Int) {
                if (type == 1) {
                    selectPhoto()
                }
            }
        })
        uiv_avatar.setUserOnClickListener(object : UserItemView.UserOnClickListener {
            override fun userOnClick(view: View) {
                mPhoto.show(supportFragmentManager, "photoDialog")
            }
        })
    }

    override fun createPresenter() = UpdateUserInfoPresenter()

    override fun <T> setData(data: T) {
    }

    override fun setError(error: String) {
    }

    private fun selectPhoto() {

    }
}