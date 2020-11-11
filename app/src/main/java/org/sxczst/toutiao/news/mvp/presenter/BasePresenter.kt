package org.sxczst.toutiao.news.mvp.presenter

/**
 * @Author      :sxczst
 * @Date        :Created in 2020/11/11 19:52
 * @Description :
 */
open class BasePresenter<V> {
    private var mBaseView: V? = null

    /**
     *@param mBaseView 绑定的视图
     */
    fun bindView(mBaseView: V) {
        this.mBaseView = mBaseView;
    }

    /**
     * 解除视图绑定
     */
    fun unBindView() {
        this.mBaseView = null
    }

    /**
     * 返回当前视图
     */
    fun getBaseView() = mBaseView
}