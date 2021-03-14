package org.sxczst.toutiao.news.ui.main.act

import android.content.Intent
import android.graphics.Color
import android.util.Log
import androidx.fragment.app.Fragment
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener
import kotlinx.android.synthetic.main.activity_main.*
import org.sxczst.toutiao.news.R
import org.sxczst.toutiao.news.base.BaseActivity
import org.sxczst.toutiao.news.base.Constants
import org.sxczst.toutiao.news.ui.main.adapter.HomeAdapter
import org.sxczst.toutiao.news.ui.main.frg.HomeFragment
import org.sxczst.toutiao.news.ui.main.frg.MineFragment
import org.sxczst.toutiao.news.ui.main.model.TitleModel
import org.sxczst.toutiao.news.ui.main.presenter.MainPresenter
import org.sxczst.toutiao.news.ui.main.view.MainView
import org.sxczst.toutiao.news.ui.user.act.LoginNoPassActivity
import org.sxczst.toutiao.news.ui.user.act.RegisterActivity
import org.sxczst.toutiao.news.utils.StatusBarUtils

class MainActivity : BaseActivity<MainView, MainPresenter>(), MainView {

    private val titleTabs = ArrayList<CustomTabEntity>()
    private val fragments = ArrayList<Fragment>()

    override fun getLayoutId(): Int = R.layout.activity_main


    override fun initData() {

    }

    override fun initView() {
        tv_test.setOnClickListener {
            getPresenter()?.getTest("test")
//            startActivity(Intent(this, RegisterActivity::class.java))
            startActivity(Intent(this, LoginNoPassActivity::class.java))
        }
        StatusBarUtils.setStatusBar(this, Constants.COMMON_BAR, R.color.c_e6645f)
        val titles = resources.getStringArray(R.array.title)
        val selectIds = resources.obtainTypedArray(R.array.select)
        val unSelectIds = resources.obtainTypedArray(R.array.un_select)

        // 遍历 title
        for (i: Int in titles.indices) {
            titleTabs.add(
                TitleModel(
                    titles[i],
                    selectIds.getResourceId(i, 0),
                    unSelectIds.getResourceId(i, 0)
                )
            )
        }
        fragments.add(HomeFragment())
        fragments.add(HomeFragment())
        fragments.add(HomeFragment())
        fragments.add(MineFragment())
        vp_home.adapter = HomeAdapter(supportFragmentManager, fragments)
        vp_home.offscreenPageLimit = fragments.size
        ctl_home.setTabData(titleTabs)
        ctl_home.setOnTabSelectListener(object : OnTabSelectListener {
            override fun onTabSelect(position: Int) {
                // 禁用动画
                vp_home.setCurrentItem(position, false)
                when (position) {
                    0, 1, 2 -> setLightNavigationBar()
                    3 -> setLightStatusBar()
                }
            }

            override fun onTabReselect(position: Int) {
            }
        })

    }

    override fun createPresenter() = MainPresenter()

    override fun <T> setData(data: T) {
        Log.e(TAG, "setData: test : =====>$data")
    }

    override fun setError(error: String) {

    }

    companion object {
        private const val TAG = "MainActivity"
    }
}