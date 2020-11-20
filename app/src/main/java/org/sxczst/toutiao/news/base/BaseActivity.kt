package org.sxczst.toutiao.news.base

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import org.sxczst.toutiao.news.R
import org.sxczst.toutiao.news.mvp.model.EvtMsgModel
import org.sxczst.toutiao.news.mvp.presenter.BasePresenter
import org.sxczst.toutiao.news.mvp.view.BaseView
import org.sxczst.toutiao.news.utils.StatusBarUtils

/**
 *
 */
abstract class BaseActivity<V, P : BasePresenter<V>> : AppCompatActivity(), BaseView {
    private var mPresenter: P? = null
    private var mToast: Toast? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        StatusBarUtils.setStatusBar(this, Constants.COMMON_BAR, R.color.c_ffffff)
        if (mPresenter == null) {
            mPresenter = createPresenter()
        }
        mPresenter?.bindView(this as V)
        initView()
        initData()
    }

    protected abstract fun getLayoutId(): Int

    protected abstract fun initData()

    protected abstract fun initView()

    /**
     * 交有子类实现 创建 Presenter 的方法
     */
    protected abstract fun createPresenter(): P?

    /**
     * 供子类使用
     * 获取父类的 Presenter
     */
    fun getPresenter() = mPresenter

    override fun onDestroy() {
        super.onDestroy()
        // 视图解除绑定
        mPresenter?.unBindView()
    }

    /**
     * Toast 提示
     */
    fun showToast(mes: String) {
        if (mToast == null) {
            mToast = Toast.makeText(application, mes, Toast.LENGTH_SHORT)
        }
        mToast?.show()
    }

    /**
     * 跳转页面
     * @param clz 所跳转的目的Activity类
     */
    fun startActivity(clz: Class<*>) {
        startActivity(Intent(this, clz))
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    open fun getMessage(message: EvtMsgModel<*>) {

    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    open fun getMessageSticky(message: EvtMsgModel<*>) {

    }

    /**
     * 发送消息
     */
    open fun postMsg(message: EvtMsgModel<*>) {
        EventBus.getDefault().post(message)
    }
}