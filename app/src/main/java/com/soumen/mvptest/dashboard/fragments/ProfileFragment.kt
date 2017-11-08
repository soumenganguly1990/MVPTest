package com.soumen.mvptest.dashboard.fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.soumen.mvptest.R
import com.soumen.mvptest.dashboard.DashboardActivity
import com.soumen.mvptest.dashboard.presenter.IProfilePresenter
import com.soumen.mvptest.dashboard.presenter.ProfilePresenterImpl
import com.soumen.mvptest.dashboard.view.IProfileView
import com.soumen.mvptest.extras.AppCommonValues
import com.soumen.mvptest.roomcommonops.entities.UserEntity

/**
 * Created by IN-LT-51 on 07-11-2017.
 */
class ProfileFragment: Fragment(), IProfileView {

    @BindView(R.id.linViewProfile)
    lateinit var linViewProfile: LinearLayout
    @BindView(R.id.linUpdateProfile)
    lateinit var linUpdateProfile: LinearLayout

    @BindView(R.id.txtUserId)
    lateinit var txtUserId: TextView
    @BindView(R.id.txtUserPassword)
    lateinit var txtUserPassword: TextView
    @BindView(R.id.txtUserEmail)
    lateinit var txtUserEmail: TextView
    @BindView(R.id.txtUserPhone)
    lateinit var txtUserPhone: TextView

    @BindView(R.id.txtUserIdProf)
    lateinit var txtUserIdProf: TextView
    @BindView(R.id.edtUserPassword)
    lateinit var edtUserPassword: EditText
    @BindView(R.id.edtUserEmail)
    lateinit var edtUserEmail: EditText
    @BindView(R.id.edtUserPhone)
    lateinit var edtUserPhone: EditText

    lateinit var iProfilePresenter: IProfilePresenter

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
        iProfilePresenter = ProfilePresenterImpl(this)
        return view
    }

    private fun setUpTextValues() {
        txtUserId.text = AppCommonValues.userEntity!!.getUserId()
        txtUserPassword.text = AppCommonValues.userEntity!!.getPassword()
        txtUserEmail.text = AppCommonValues.userEntity!!.getEmail()
        txtUserPhone.text = AppCommonValues.userEntity!!.getPhone().toString()

        txtUserIdProf.text = AppCommonValues.userEntity!!.getUserId()
        edtUserEmail.setText(AppCommonValues.userEntity!!.getEmail())
        edtUserPassword.setText(AppCommonValues.userEntity!!.getPassword())
        edtUserPhone.setText(AppCommonValues.userEntity!!.getPhone().toString())
    }

    @OnClick(R.id.btnUpdateProf)
    fun onUpdateButtonClicked() {
        linViewProfile.visibility = View.GONE
        linUpdateProfile.visibility = View.VISIBLE
    }

    @OnClick(R.id.btnUpdateProfNow)
    fun onUpdateNowButtonClicked() {
        var user: UserEntity = UserEntity()
        user.setUserId(txtUserIdProf.text.toString())
        user.setEmail(edtUserEmail.text.toString())
        user.setPassword(edtUserPassword.text.toString())
        user.setPhone(edtUserPhone.text.toString().toLong())
        iProfilePresenter.updateUserInDb(user)
    }

    override fun updateUserProfile(status: Int) {
        if(status == 1) {
            saveUpdatedUserModel()
            requestListFragmentUpdate()
            refreshSelf()
            Toast.makeText(this.activity, "Updated!!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this.activity, "Could not be updated!!", Toast.LENGTH_SHORT).show()
        }
    }

    fun saveUpdatedUserModel() {
        var user: UserEntity = UserEntity()
        user.setUserId(txtUserIdProf.text.toString())
        user.setEmail(edtUserEmail.text.toString())
        user.setPassword(edtUserPassword.text.toString())
        user.setPhone(edtUserPhone.text.toString().toLong())
        AppCommonValues.userEntity = user
    }

    fun requestListFragmentUpdate() {
        if(AppCommonValues.context is DashboardActivity) {
            (AppCommonValues.context as DashboardActivity).requestAllUserListUpdation()
        }
    }

    fun refreshSelf() {
        val ft = fragmentManager.beginTransaction()
        ft.detach(this).attach(this).commit()
    }

    override fun onDetach() {
        super.onDetach()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}