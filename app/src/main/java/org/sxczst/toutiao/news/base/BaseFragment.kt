package org.sxczst.toutiao.news.base

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.sxczst.toutiao.news.mvp.presenter.BasePresenter
import org.sxczst.toutiao.news.mvp.view.BaseView

/**
 * @author      sxczst
 * @date        2021/3/14 15:50
 */
abstract class BaseFragment<V, P : BasePresenter<V>> : Fragment(), BaseView {
    private var mPresenter: P? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(getLayoutId(), container, false)
        if (mPresenter == null) {
            mPresenter = createPresenter()
        }
        mPresenter?.bindView(this as V)
        initView(view)
        initData()
        return view
    }

    protected abstract fun getLayoutId(): Int

    protected abstract fun initData()

    protected abstract fun initView(view: View)

    /**
     * 交由子类实现 创建 Presenter 的方法
     */
    protected abstract fun createPresenter(): P?

    /**
     * 供子类使用
     * 获取父类的 Presenter
     */
    fun getPresenter() = mPresenter

    /**
     * 跳转页面
     * @param clz 所跳转的目的Activity类
     */
    fun startActivity(clz: Class<*>) {
        startActivity(Intent(activity, clz))
    }

    override fun onDestroy() {
        super.onDestroy()
        // 视图解除绑定
        mPresenter?.unBindView()
    }

}