package com.soumen.mvptest.dashboard.fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.soumen.mvptest.R
import com.soumen.mvptest.extras.AppCommonValues

/**
 * Created by IN-LT-51 on 07-11-2017.
 */
class ProfileFragment: Fragment() {

    @BindView(R.id.txtUserId)
    lateinit var txtUserId: TextView
    @BindView(R.id.txtUserPassword)
    lateinit var txtUserPassword: TextView
    @BindView(R.id.txtUserEmail)
    lateinit var txtUserEmail: TextView
    @BindView(R.id.txtUserPhone)
    lateinit var txtUserPhone: TextView

    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view: View = inflater!!.inflate(R.layout.fragment_profile, container, false)
        Log.e("onCreateView", "of profile Fragment called")
        ButterKnife.bind(this, view)
        setUpTextValues()
        return view
    }

    private fun setUpTextValues() {
        txtUserId.text = AppCommonValues.userEntity!!.getUserId()
        txtUserPassword.text = AppCommonValues.userEntity!!.getPassword()
        txtUserEmail.text = AppCommonValues.userEntity!!.getEmail()
        txtUserPhone.text = AppCommonValues.userEntity!!.getPhone().toString()
    }

    override fun onDetach() {
        super.onDetach()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}