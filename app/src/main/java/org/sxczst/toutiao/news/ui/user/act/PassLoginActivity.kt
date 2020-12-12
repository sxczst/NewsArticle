package org.sxczst.toutiao.news.ui.user.act

import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_pass_login.*
import kotlinx.android.synthetic.main.activity_pass_login.btn_back
import kotlinx.android.synthetic.main.activity_pass_login.cv_next
import kotlinx.android.synthetic.main.activity_pass_login.et_phone_number
import kotlinx.android.synthetic.main.activity_pass_login.my_check_box
import kotlinx.android.synthetic.main.activity_pass_login.tv_86
import kotlinx.android.synthetic.main.activity_register.*
import org.sxczst.toutiao.news.R
import org.sxczst.toutiao.news.base.BaseActivity
import org.sxczst.toutiao.news.base.Constants
import org.sxczst.toutiao.news.ui.user.model.RegisterModel
import org.sxczst.toutiao.news.ui.user.presenter.LoginPresenter
import org.sxczst.toutiao.news.ui.user.view.LoginView
import org.sxczst.toutiao.news.utils.CommonUtils
import org.sxczst.toutiao.news.utils.SharedPreferencesUtils

/**
 * @Author      :sxczst
 * @Date        :Created in 2020/11/28 20:18
 * @Description :密码登录页面
 */
class PassLoginActivity : BaseActivity<LoginView, LoginPresenter>(), LoginView, TextWatcher {
    /**
     * 记录手机/邮箱输入框的内容
     */
    private var phone = ""

    /**
     * 记录密码输入框的内容
     */
    private var pass = ""

    override fun getLayoutId(): Int = R.layout.activity_pass_login

    override fun initData() {
    }

    override fun initView() {
        // 初始化协议+隐藏单选按钮
        my_check_box.initSpan(R.string.login_agreement)
        my_check_box.isShow(false)

        // 给手机/邮箱，和密码输入框添加监听
        et_phone_number.addTextChangedListener(this)
        et_pass.addTextChangedListener(this)

        // 返回键
        btn_back.setOnClickListener { finish() }

        // 按钮初始化的颜色
        cv_next.setCardBackgroundColor(ContextCompat.getColor(this, R.color.c_999999))

        // 登录按钮
        cv_next.setOnClickListener { getPresenter()?.getLogin(phone, pass) }

        // 找回密码
        tv_find_pass.setOnClickListener {
            startActivity(FindPassActivity::class.java)
            finish()
        }
    }

    override fun createPresenter(): LoginPresenter? = LoginPresenter()

    override fun isRegister(): Boolean = false

    override fun <T> setData(data: T) {
        if (data != null) {
            val mRegister = data as RegisterModel
            SharedPreferencesUtils.saveToken(
                this@PassLoginActivity,
                Constants.TOKEN,
                mRegister.token
            )
            finish();
        }
    }

    override fun setError(error: String) {
    }

    override fun afterTextChanged(s: Editable?) {
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        phone = et_phone_number.text.toString()
        pass = et_pass.text.toString()
        // TODO: 2020/12/5 这里比对结果不符合预期
        if (phone.contains("@")) {
            // 隐藏+86
            tv_86.visibility = View.INVISIBLE
            // 输入长度改为适用邮箱地址的长度
            et_phone_number.onInputFilter(20)
        } else {
            // 显示
            tv_86.visibility = View.VISIBLE
            // 输入长度改为手机号长度
            et_phone_number.onInputFilter(11)
        }
        if ((phone.isNotEmpty() && CommonUtils.checkMobile(phone))
            && pass.isNotEmpty()
        ) {
            // 高亮提示
            cv_next.setCardBackgroundColor(ContextCompat.getColor(this, R.color.c_e6645f))
            cv_next.isEnabled = true
        } else {
            cv_next.setCardBackgroundColor(ContextCompat.getColor(this, R.color.c_999999))
            // 不满足条件，按钮不可用。
            cv_next.isEnabled = false
        }
    }

    /**
     * 修改输入长度的扩展函数
     */
    private fun EditText.onInputFilter(size: Int) {
        filters = arrayOf(InputFilter.LengthFilter(size))
    }
}