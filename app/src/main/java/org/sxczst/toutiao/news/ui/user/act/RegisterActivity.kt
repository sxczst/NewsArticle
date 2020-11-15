package org.sxczst.toutiao.news.ui.user.act

import android.content.Intent
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_register.*
import org.sxczst.toutiao.news.R
import org.sxczst.toutiao.news.base.BaseActivity
import org.sxczst.toutiao.news.base.Constants.MOBILE
import org.sxczst.toutiao.news.ui.user.presenter.RegisterPresenter
import org.sxczst.toutiao.news.ui.user.view.RegisterView
import org.sxczst.toutiao.news.utils.CommonUtils.checkMobile
import org.sxczst.toutiao.news.utils.CommonUtils.replaceBlank
import org.sxczst.toutiao.news.view.MyCheckBox

/**
 * @Author      :sxczst
 * @Date        :Created in 2020/11/13 18:51
 * @Description :用户注册，TextWatcher 监听手机号码的改变
 */
class RegisterActivity : BaseActivity<RegisterView, RegisterPresenter>(), RegisterView,
    TextWatcher {

    /**
     * 存取手机号信息
     */
    private var phoneText: String = ""

    /**
     * 校验电话号码
     */
    private fun checkPhone() {
        // 手机长度，协议是否同意，手机号正则
        if (phoneText.length == 13 && my_check_box.isChecked()
            && checkMobile(replaceBlank(phoneText))
        ) {
            cv_next.setCardBackgroundColor(ContextCompat.getColor(this, R.color.c_e6645f))
        } else {
            cv_next.setCardBackgroundColor(ContextCompat.getColor(this, R.color.c_999999))
        }
    }

    override fun getLayoutId(): Int = R.layout.activity_register

    override fun initData() {
    }

    override fun initView() {

        // 用户协议、隐私政策 复选框
        my_check_box.setOnClickListener {
            my_check_box.changeState()
            checkPhone()
        }
        // 用户协议、隐私政策的点击事件(自定义的回调接口)
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

        // 卡片按钮
        cv_next.setCardBackgroundColor(ContextCompat.getColor(this, R.color.c_999999))
        cv_next.setOnClickListener {
            if (TextUtils.isEmpty(phoneText)) {
                Toast.makeText(application, "请您输入手机号码", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (!my_check_box.isChecked()) {
                Toast.makeText(application, "请您勾选用户协议", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            var intent = Intent(this@RegisterActivity, SendCodeActivity::class.java)
            intent.putExtra(MOBILE, phoneText)
            startActivity(intent)
        }

        // 返回键
        btn_back.setOnClickListener { finish() }

        // 手机号码输入框
        et_phone_number.addTextChangedListener(this)
    }

    override fun createPresenter(): RegisterPresenter? = RegisterPresenter()

    override fun <T> setData(data: T) {
    }

    override fun setError(error: String) {
    }

    override fun afterTextChanged(s: Editable?) {
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        // 手机号赋值
        phoneText = s.toString()
        checkPhone()
    }
}