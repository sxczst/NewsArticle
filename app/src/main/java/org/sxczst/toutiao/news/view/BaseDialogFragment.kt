package org.sxczst.toutiao.news.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment

/**
 * @author      sxczst
 * @date        2021/3/18 22:02
 */
abstract class BaseDialogFragment : DialogFragment() {
    private lateinit var mView: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog?.apply {
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            setCanceledOnTouchOutside(true)
            setCancelable(true)
        }
        mView = inflater.inflate(getLayout(), container, false)
        initView(mView)
        initData()
        return mView
    }

    protected abstract fun initData()

    protected abstract fun initView(view: View)

    protected abstract fun getLayout(): Int

}