package org.sxczst.toutiao.news.ui.user.act

import android.content.Intent
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_login_no_pass.*
import org.sxczst.toutiao.news.R
import org.sxczst.toutiao.news.base.BaseActivity
import org.sxczst.toutiao.news.base.Constants
import org.sxczst.toutiao.news.mvp.model.EvtMsgModel
import org.sxczst.toutiao.news.ui.user.model.RegisterModel
import org.sxczst.toutiao.news.ui.user.presenter.RegisterPresenter
import org.sxczst.toutiao.news.ui.user.view.RegisterView
import org.sxczst.toutiao.news.utils.CommonUtils
import org.sxczst.toutiao.news.view.MyCheckBox

/**
 * @Author      :sxczst
 * @Date        :Created in 2020/11/20 20:13
 * @Description :
 */
class LoginNoPassActivity : BaseActivity<RegisterView, RegisterPresenter>(), RegisterView,
    TextWatcher {
    private var phoneText = ""
    override fun getLayoutId(): Int = R.layout.activity_login_no_pass

    override fun initData() {
    }

    override fun initView() {
        my_check_box.initSpan(R.string.login_agreement)
        my_check_box.isShow(false)

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
            val intent = Intent(this@LoginNoPassActivity, SendCodeActivity::class.java)
            intent.putExtra(Constants.MOBILE, phoneText)
            intent.putExtra(Constants.USER_ACTION, Constants.ACTION_REGISTER)
            startActivity(intent)
        }

        // 返回键
        btn_back.setOnClickListener { finish() }

        // 手机号码输入框
        et_phone_number.addTextChangedListener(this)

        // 账号注册
        tv_register_an_account.setOnClickListener {
            startActivity(RegisterActivity::class.java)
        }

        // 密码登录
        tv_password_login.setOnClickListener {
            startActivity(PassLoginActivity::class.java)
            finish()
        }

        // 隐私设置
        tv_privacy_setting.setOnClickListener {
            startActivity(PrivacySettingsActivity::class.java)
        }
    }


    /**
     * 校验电话号码
     */
    private fun checkPhone() {
        // 手机长度，协议是否同意，手机号正则
        if (phoneText.length == 13
            && CommonUtils.checkMobile(CommonUtils.replaceBlank(phoneText))
        ) {
            cv_next.setCardBackgroundColor(ContextCompat.getColor(this, R.color.c_e6645f))
        } else {
            cv_next.setCardBackgroundColor(ContextCompat.getColor(this, R.color.c_999999))
        }
    }

    override fun createPresenter(): RegisterPresenter? = RegisterPresenter()
    override fun onRegister(registerModel: RegisterModel) {

    }

    override fun isRegister(): Boolean = true

    override fun <T> setData(data: T) {
    }

    override fun setError(error: String) {
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_no, R.anim.slide_out_top)
    }

    override fun getMessage(message: EvtMsgModel<*>) {
        super.getMessage(message)
        if (message.code == 102) {
            finish()
        }
    }

    override fun afterTextChanged(s: Editable?) {
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        phoneText = s.toString()
        checkPhone()
    }
}