package org.sxczst.toutiao.news.ui.main.act

import android.content.Intent
import android.view.View
import com.luck.picture.lib.PictureSelector
import com.luck.picture.lib.config.PictureConfig
import com.luck.picture.lib.config.PictureMimeType
import kotlinx.android.synthetic.main.activity_update_user_info.*
import org.sxczst.toutiao.news.R
import org.sxczst.toutiao.news.base.BaseActivity
import org.sxczst.toutiao.news.ui.main.presenter.UpdateUserInfoPresenter
import org.sxczst.toutiao.news.ui.main.view.UpdateUserInfoView
import org.sxczst.toutiao.news.view.DialogFragmentListener
import org.sxczst.toutiao.news.view.GenderDialog
import org.sxczst.toutiao.news.view.PhotoDialog
import org.sxczst.toutiao.news.view.UserItemView

/**
 * @author      sxczst
 * @date        2021/3/17 22:28
 */
class UpdateUserInfoActivity : BaseActivity<UpdateUserInfoView, UpdateUserInfoPresenter>(),
    UpdateUserInfoView {
    private val mPhoto = PhotoDialog()
    private val mGender = GenderDialog()

    override fun getLayoutId() = R.layout.activity_update_user_info

    override fun initData() {
    }

    override fun initView() {
        uiv_avatar.setUserOnClickListener(object : UserItemView.UserOnClickListener {
            override fun userOnClick(view: View) {
                mPhoto.show(supportFragmentManager, "photoDialog")
                mPhoto.setDialogFragmentListener(object : DialogFragmentListener {
                    override fun onDialog(type: Int) {
                        selectPhoto()
                    }
                })
            }
        })
        uiv_gender.setUserOnClickListener(object : UserItemView.UserOnClickListener {
            override fun userOnClick(view: View) {
                mGender.show(supportFragmentManager, "genderDialog")
                mGender.setDialogFragmentListener(object : DialogFragmentListener {
                    override fun onDialog(type: Int) {

                    }
                })
            }
        })

    }

    override fun createPresenter() = UpdateUserInfoPresenter()

    override fun <T> setData(data: T) {
    }

    override fun setError(error: String) {
    }

    /**
     * 选择照片第三方库使用
     */
    private fun selectPhoto() {
        PictureSelector.create(this)
            .openGallery(PictureMimeType.ofImage())
            .maxSelectNum(1)
            .isEnableCrop(true)
            .isCamera(true)
            .imageFormat(PictureMimeType.PNG)
            .isZoomAnim(true)
            .isCompress(true)
            .circleDimmedLayer(true)
            .showCropFrame(false)
            .showCropGrid(false)
            .forResult(PictureConfig.CHOOSE_REQUEST)
    }

    /**
     * 选择照片回调
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            when (requestCode) {
                PictureConfig.CHOOSE_REQUEST -> {
                    val mutableList = PictureSelector.obtainMultipleResult(data)
                    mutableList[0]?.let {
                        uiv_avatar.setImageView(it.cutPath)
                    }
                }
            }
        }
    }
}