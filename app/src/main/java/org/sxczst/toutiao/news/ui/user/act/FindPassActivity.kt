package org.sxczst.toutiao.news.ui.user.act

import android.content.Intent
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_find_pass.*
import org.sxczst.toutiao.news.R
import org.sxczst.toutiao.news.base.BaseActivity
import org.sxczst.toutiao.news.base.Constants
import org.sxczst.toutiao.news.mvp.model.EvtMsgModel
import org.sxczst.toutiao.news.ui.user.presenter.LoginPresenter
import org.sxczst.toutiao.news.ui.user.view.LoginView
import org.sxczst.toutiao.news.utils.CommonUtils

/**
 * @Author      :sxczst
 * @Date        :Created in 2020/12/12 8:47
 * @Description :找回密码界面
 */
class FindPassActivity : BaseActivity<LoginView, LoginPresenter>(), LoginView, TextWatcher {
    private var phoneText = ""
    override fun getLayoutId(): Int = R.layout.activity_find_pass

    override fun initData() {
    }

    override fun initView() {
        // 返回键
        btn_back.setOnClickListener { finish() }

        // 手机号码输入框
        et_phone_number.addTextChangedListener(this)

        // 执行按钮
        cv_next.setCardBackgroundColor(ContextCompat.getColor(this, R.color.c_999999))

        cv_next.setOnClickListener {
            if (phoneText.isEmpty()) {
                Toast.makeText(application, "请填写正确电话", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val intent = Intent(this@FindPassActivity, SendCodeActivity::class.java)
            intent.putExtra(Constants.MOBILE, phoneText)
            intent.putExtra(Constants.USER_ACTION, Constants.ACTION_FIND_PASS)
            startActivity(intent)
        }
    }

    override fun isRegister(): Boolean = false

    override fun getMessage(message: EvtMsgModel<*>) {
        super.getMessage(message)
        if (message.code == 103) {
            finish()
        }
    }

    override fun createPresenter(): LoginPresenter? = LoginPresenter()

    override fun <T> setData(data: T) {
    }

    override fun setError(error: String) {
    }

    override fun afterTextChanged(s: Editable?) {
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        phoneText = s.toString()
        checkPhone()
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

}