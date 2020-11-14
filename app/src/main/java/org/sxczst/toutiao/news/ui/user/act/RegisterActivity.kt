package org.sxczst.toutiao.news.ui.user.act

import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*
import org.sxczst.toutiao.news.R
import org.sxczst.toutiao.news.base.BaseActivity
import org.sxczst.toutiao.news.ui.user.presenter.RegisterPresenter
import org.sxczst.toutiao.news.ui.user.view.RegisterView
import org.sxczst.toutiao.news.view.MyCheckBox

/**
 * @Author      :sxczst
 * @Date        :Created in 2020/11/13 18:51
 * @Description :用户注册
 */
class RegisterActivity : BaseActivity<RegisterView, RegisterPresenter>(), RegisterView {

    override fun getLayoutId(): Int = R.layout.activity_register

    override fun initData() {
    }

    override fun initView() {
        my_check_box.setOnClickListener {
            my_check_box.changeState()
        }
        // 用户协议、隐私政策的点击事件
        my_check_box.setClickableSpanText(object : MyCheckBox.ClickableSpanText {
            override fun onClick(type: Int) {
                if (type == 1) {
                    // 用户协议
                    Toast.makeText(application, "用户协议", Toast.LENGTH_SHORT).show()
                } else if (type == 2) {
                    // 隐私政策
                    Toast.makeText(application, "隐私政策", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    override fun createPresenter(): RegisterPresenter? = RegisterPresenter()

    override fun <T> setData(data: T) {
    }

    override fun setError(error: String) {
    }
}