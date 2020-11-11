package org.sxczst.toutiao.news.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.sxczst.toutiao.news.mvp.presenter.BasePresenter
import org.sxczst.toutiao.news.mvp.view.BaseView

/**
 *
 */
abstract class BaseActivity<V, P : BasePresenter<V>> : AppCompatActivity(), BaseView {
    private var mPresenter: P? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        if (mPresenter == null) {
            mPresenter = createPresenter()
        }
        mPresenter?.bindView(this as V)
        init()
        initData()
    }

    protected abstract fun getLayoutId(): Int

    protected abstract fun initData()

    protected abstract fun init()

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
}