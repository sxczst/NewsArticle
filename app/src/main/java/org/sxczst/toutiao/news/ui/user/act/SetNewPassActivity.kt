package org.sxczst.toutiao.news.ui.user.act

import android.text.Editable
import android.text.TextWatcher
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_set_new_pass.*
import org.sxczst.toutiao.news.R
import org.sxczst.toutiao.news.base.BaseActivity
import org.sxczst.toutiao.news.base.Constants
import org.sxczst.toutiao.news.mvp.model.EvtMsgModel
import org.sxczst.toutiao.news.ui.user.presenter.LoginPresenter
import org.sxczst.toutiao.news.ui.user.view.LoginView

/**
 * @Author      :sxczst
 * @Date        :Created in 2020/12/12 9:36
 * @Description :设置新密码页面
 */
class SetNewPassActivity : BaseActivity<LoginView, LoginPresenter>(), LoginView, TextWatcher {

    private var code: String = ""
    private var phone: String = ""
    private var newPass: String = ""

    override fun getLayoutId(): Int = R.layout.activity_set_new_pass

    override fun initData() {
    }

    override fun initView() {
        cv_next.isEnabled = false
        cv_next.setCardBackgroundColor(ContextCompat.getColor(this, R.color.c_999999))
        et_phone_number.addTextChangedListener(this)
        if (intent != null) {
            code = intent.getStringExtra(Constants.CODE) ?: ""
            phone = intent.getStringExtra(Constants.MOBILE) ?: ""
        }
        btn_back.setOnClickListener {
            finish()
        }
        cv_next.setOnClickListener {
            if (code.isNotEmpty()
                && phone.isNotEmpty()
                && newPass.isNotEmpty()
            ) {
                getPresenter()?.getFindPass(phone, code, newPass)
            }
        }
    }

    override fun createPresenter(): LoginPresenter? = LoginPresenter()
    override fun isRegister(): Boolean = false

    override fun <T> setData(data: T) {
        if (data != null) {
            postMsg(EvtMsgModel(103, code))
            finish()
        }
    }

    override fun setError(error: String) {

    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }

    override fun afterTextChanged(s: Editable?) {
        newPass = s.toString()
        if (newPass.length >= 4) {
            cv_next.isEnabled = true
            cv_next.setCardBackgroundColor(ContextCompat.getColor(this, R.color.c_e6645f))
        } else {
            cv_next.isEnabled = false
            cv_next.setCardBackgroundColor(ContextCompat.getColor(this, R.color.c_999999))
        }
    }
}