package org.sxczst.toutiao.news.view

import android.view.View
import kotlinx.android.synthetic.main.dialog_photo.view.*
import org.sxczst.toutiao.news.R

/**
 * @author      sxczst
 * @date        2021/3/18 22:09
 */
class PhotoDialog : BaseDialogFragment() {
    private var dialogFragmentListener: DialogFragmentListener? = null

    override fun initData() {
    }

    override fun initView(view: View) {
        view.tv_select_from_album.setOnClickListener {
            dialogFragmentListener?.onDialog(1)
            dismiss()
        }
        view.tv_photograph.setOnClickListener {
            dialogFragmentListener?.onDialog(2)
            dismiss()
        }
        view.tv_cancel.setOnClickListener {
            dismiss()
        }
    }

    override fun getLayout() = R.layout.dialog_photo

    fun setDialogFragmentListener(dialogFragmentListener: DialogFragmentListener) {
        this.dialogFragmentListener = dialogFragmentListener
    }
}