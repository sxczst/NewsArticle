package org.sxczst.toutiao.news.view

import android.view.View
import kotlinx.android.synthetic.main.dialog_gender.view.*
import org.sxczst.toutiao.news.R

/**
 * @author      sxczst
 * @date        2021/3/18 22:23
 */
class GenderDialog : BaseDialogFragment() {
    private var dialogFragmentListener: DialogFragmentListener? = null

    override fun initData() {
    }

    override fun initView(view: View) {
        view.tv_male.setOnClickListener {
            dialogFragmentListener?.onDialog(1)
            dismiss()
        }
        view.tv_female.setOnClickListener {
            dialogFragmentListener?.onDialog(2)
            dismiss()
        }
        view.tv_cancel.setOnClickListener {
            dismiss()
        }
    }

    override fun getLayout() = R.layout.dialog_gender

    fun setDialogFragmentListener(dialogFragmentListener: DialogFragmentListener) {
        this.dialogFragmentListener = dialogFragmentListener
    }
}