package org.sxczst.toutiao.news.ui.user.act

import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_send_code.*
import org.sxczst.toutiao.news.R
import org.sxczst.toutiao.news.base.BaseActivity
import org.sxczst.toutiao.news.base.Constants
import org.sxczst.toutiao.news.base.Constants.COUNT_TIME
import org.sxczst.toutiao.news.base.Constants.COUNT_TIME_INTERVAL
import org.sxczst.toutiao.news.base.Constants.TOKEN
import org.sxczst.toutiao.news.mvp.model.EvtMsgModel
import org.sxczst.toutiao.news.ui.user.model.CodeModel
import org.sxczst.toutiao.news.ui.user.model.RegisterModel
import org.sxczst.toutiao.news.ui.user.presenter.SendCodePresenter
import org.sxczst.toutiao.news.ui.user.view.SendCodeView
import org.sxczst.toutiao.news.utils.AuthCodeTimer
import org.sxczst.toutiao.news.utils.CommonUtils
import org.sxczst.toutiao.news.utils.SharedPreferencesUtils
import org.sxczst.toutiao.news.view.CountDownListener

/**
 * @Author      :sxczst
 * @Date        :Created in 2020/11/15 8:28
 * @Description :发送手机验证码
 */
class SendCodeActivity : BaseActivity<SendCodeView, SendCodePresenter>(), SendCodeView,
    CountDownListener, TextWatcher {

    private var mAuthCodeTimer: AuthCodeTimer? = null
    private var phone: String? = null
    private var code: String? = null

    /**
     * 用户操作类型
     */
    private var actionType: Int = 0

    override fun getLayoutId(): Int = R.layout.activity_send_code

    override fun initData() {
        getHttpSendCode()
    }

    fun getHttpSendCode() {
        if (!TextUtils.isEmpty(phone)) {
            // 程序员自己保证phone不为空
            getPresenter()?.getCode(CommonUtils.replaceBlank(phone!!))
        }
    }

    override fun initView() {
        btn_back.setOnClickListener {
            finish()
        }

        if (intent != null) {
            phone = intent.getStringExtra(Constants.MOBILE)
            actionType = intent.getIntExtra(Constants.USER_ACTION, 0)
        }

        tv_modify.setOnClickListener {
            finish()
        }

        tv_show_mobile.text = "验证码已发送至 $phone"

        tv_reacquire.setOnClickListener {
            getHttpSendCode()
        }

        iv_next.setOnClickListener {
            val code = CommonUtils.replaceBlank(et_code.text.toString())
            if (TextUtils.isEmpty(code)) {
                // 请输入验证码
                showToast("请输入验证码!")
                return@setOnClickListener
            }
            if (code == this.code) {
                // 进行注册业务
                getPresenter()?.getRegister(CommonUtils.replaceBlank(phone!!), code, actionType)
            } else {
                // 提示验证码错误
                showToast("验证码错误!")
            }
        }
    }

    override fun createPresenter(): SendCodePresenter? = SendCodePresenter()

    override fun onRegister(registerModel: RegisterModel) {
        // 保存Token
        SharedPreferencesUtils.saveToken(
            this, TOKEN, registerModel.token
        )
        when (actionType) {
            Constants.ACTION_LOGIN -> {
                // 登录操作
                postMsg(EvtMsgModel(102, registerModel.token))
            }
            else -> {
                /**
                 * 收到Token，
                 * 注册成功，
                 * 关闭上一Activity
                 */
                postMsg(EvtMsgModel(101, registerModel.token))
            }
        }
        // 关闭自己
        finish()
    }

    override fun isRegister(): Boolean = true

    override fun <T> setData(data: T) {
        if (data != null) {
            mAuthCodeTimer = AuthCodeTimer(COUNT_TIME, COUNT_TIME_INTERVAL, this)
            mAuthCodeTimer?.start()
            val codeModel = data as CodeModel
            code = codeModel.verificationCode
        }
    }

    override fun setError(error: String) {

    }

    override fun countDown(time: Long) {
        // 跟新当前数值
        val s = "重新获取(${time / 1000})秒"
        tv_reacquire.text = s

        // 不可用
        tv_reacquire.isEnabled = false
    }

    override fun isOverTime(isOverTime: Boolean) {
        if (isOverTime) {
            tv_reacquire.text = "重新获取"
            tv_reacquire.isEnabled = true
        }
    }

    override fun afterTextChanged(s: Editable?) {
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        val code = s.toString()
        if (code.length == 4) {
            if (code == this.code) {
                // 进行注册业务

            } else {
                // 提示验证码错误
            }
        }
    }
}