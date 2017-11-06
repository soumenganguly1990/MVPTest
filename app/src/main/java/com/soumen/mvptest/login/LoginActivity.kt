package com.soumen.mvptest.login

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.soumen.mvptest.R
import com.soumen.mvptest.extras.AppCommonValues
import com.soumen.mvptest.login.entity.LoginStatus
import com.soumen.mvptest.login.presenter.ILoginPresenter
import com.soumen.mvptest.login.presenter.LoginpresenterImpl
import com.soumen.mvptest.login.view.ILoginView
import com.soumen.mvptest.register.RegisterActivity
import com.soumen.mvptest.roomcommonops.AppDatabase


class LoginActivity : AppCompatActivity(), ILoginView {

    @BindView(R.id.edtUserId)
    lateinit var edtUSerId: EditText
    @BindView(R.id.edtPassword)
    lateinit var edtPassword: EditText

    /* Presenter class object */
    lateinit var iLoginPresenter: ILoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        ButterKnife.bind(this)

        AppCommonValues.context = this@LoginActivity

        iLoginPresenter = LoginpresenterImpl(this)

        AppDatabase.getAppDatabase(AppCommonValues.context!!)
    }

    @OnClick(R.id.btnReset)
    internal fun onResetButtonClicked() {
        iLoginPresenter.resetLoginForm()
    }

    @OnClick(R.id.btnLogin)
    internal fun loginButtonClicked() {
        var userId: String = edtUSerId.text.toString().trim()
        var password: String = edtPassword.text.toString().trim()
        iLoginPresenter.loginFromDb(userId, password)
    }

    @OnClick(R.id.btnRegister)
    internal fun onRegisterClicked() {
        startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
    }

    private fun makeFormEmpty() {
        edtUSerId.setText("")
        edtPassword.setText("")
    }

    override fun onResetLoginFields() {
        makeFormEmpty()
    }

    override fun onLoginResultRetrieved(loginStatus: LoginStatus) {
        if(loginStatus.status) {
            Toast.makeText(this@LoginActivity, "Login Successful", Toast.LENGTH_SHORT).show()
        } else {
            if(loginStatus.code == AppCommonValues.LOGIN_FORM_FAILURE) {
                Toast.makeText(this@LoginActivity, "Login failed", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@LoginActivity, "All fileds are required", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroy() {
        AppDatabase.destroyInstance()
        super.onDestroy()
    }
}