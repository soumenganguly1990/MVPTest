package com.soumen.mvptest.dashboard

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import butterknife.BindView
import butterknife.ButterKnife
import com.soumen.mvptest.R
import com.soumen.mvptest.extras.AppCommonValues
import com.soumen.mvptest.dashboard.adapters.ViewPagerAdapter
import com.soumen.mvptest.dashboard.fragments.AllUserFragment
import com.soumen.mvptest.dashboard.fragments.ProfileFragment


class DashboardActivity : AppCompatActivity() {

    @BindView(R.id.tabDashboard)
    lateinit var tabDashboard: TabLayout
    @BindView(R.id.vwPager)
    lateinit var vwPager: ViewPager

    /* fragments */
    lateinit var profileFragment: ProfileFragment
    lateinit var allUserFragment: AllUserFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        setContentView(R.layout.activity_dashboard)
        ButterKnife.bind(this)

        AppCommonValues.context = this
        setupViewPager()
        tabDashboard.setupWithViewPager(vwPager)
        setUpListeners()
    }

    override fun onResume() {
        super.onResume()
        AppCommonValues.context = this@DashboardActivity
    }

    private fun setupViewPager() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        profileFragment = ProfileFragment()
        allUserFragment = AllUserFragment()
        adapter!!.addFragment(profileFragment!!, AppCommonValues.TAB_PROFILE)
        adapter!!.addFragment(allUserFragment!!, AppCommonValues.TAB_ALL_USERS)
        vwPager!!.adapter = adapter!!
    }

    private fun setUpListeners() {
        tabDashboard.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                vwPager.setCurrentItem(tab.position, false)
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {
            }
            override fun onTabReselected(tab: TabLayout.Tab) {
            }
        })
    }

    fun requestAllUserListUpdation() {
        AllUserFragment.reloadFragmentUponRequest(allUserFragment)
    }
}