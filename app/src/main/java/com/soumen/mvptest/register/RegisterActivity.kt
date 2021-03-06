package com.soumen.mvptest.register

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.soumen.mvptest.R
import com.soumen.mvptest.extras.AppCommonValues
import com.soumen.mvptest.register.model.RegistrationResultModel
import com.soumen.mvptest.register.presenter.IRegisterPresentation
import com.soumen.mvptest.register.presenter.RegisterPresentationImpl
import com.soumen.mvptest.register.view.IRegisterView
import com.soumen.mvptest.roomcommonops.AppDatabase
import kotlinx.android.synthetic.main.activity_login.*

class RegisterActivity : AppCompatActivity(), IRegisterView {

    @BindView(R.id.edtRegUserId)
    lateinit var edtRegUserId: EditText
    @BindView(R.id.edtRegUserPassword)
    lateinit var edtRegUserPassword: EditText
    @BindView(R.id.edtRegUserPasswordAgain)
    lateinit var edtRegUserPasswordAgain: EditText
    @BindView(R.id.edtRegUserEmail)
    lateinit var edtRegUserEmail: EditText
    @BindView(R.id.edtRegUserPhone)
    lateinit var edtRegUserPhone: EditText

    /* presenter object */
    lateinit var iRegisterPresentation: IRegisterPresentation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_register)
        ButterKnife.bind(this@RegisterActivity)

        AppCommonValues.context = this@RegisterActivity

        iRegisterPresentation = RegisterPresentationImpl(this)
    }

    override fun onResume() {
        super.onResume()
        AppCommonValues.context = this@RegisterActivity
    }

    @OnClick(R.id.btnRegRegister)
    internal fun onRegistrationButtonClicked() {
        var userId: String = edtRegUserId.text.toString()
        var password: String = edtRegUserPassword.text.toString()
        var passwordAgain: String = edtRegUserPasswordAgain.text.toString()
        var email: String = edtRegUserEmail.text.toString()
        var phone: String = edtRegUserPhone.text.toString()
        var phone2: Long? = null
        if(phone.equals("")){
            phone2 = 0L
        } else {
            phone2 = phone.toLong()
        }
        iRegisterPresentation.doRegister(userId, password, passwordAgain, email, phone2)
    }

    private fun makeFieldsEmpty() {
        edtRegUserId.setText("")
        edtRegUserPassword.setText("")
        edtRegUserPasswordAgain.setText("")
        edtRegUserEmail.setText("")
        edtRegUserPhone.setText("")
    }

    override fun clearRegistrationForm() {
        makeFieldsEmpty()
    }

    override fun onRegistrationCompleted(registrationResultModel: RegistrationResultModel) {
        iRegisterPresentation.resetRegistratonForm()
        if (!registrationResultModel.status) {
            if (registrationResultModel.code == AppCommonValues.REG_INVALID_USER_ID) {
                Toast.makeText(this@RegisterActivity, "Invalid user id", Toast.LENGTH_SHORT).show()
            } else if (registrationResultModel.code == AppCommonValues.REG_INVALID_PASSWORD) {
                Toast.makeText(this@RegisterActivity, "Invalid password, numbers only", Toast.LENGTH_SHORT).show()
            } else if (registrationResultModel.code == AppCommonValues.REG_PASSWORDS_DIDNT_MATCH) {
                Toast.makeText(this@RegisterActivity, "Passwords did not match", Toast.LENGTH_SHORT).show()
            } else if (registrationResultModel.code == AppCommonValues.REG_INVALID_EMAIL) {
                Toast.makeText(this@RegisterActivity, "Invalid email", Toast.LENGTH_SHORT).show()
            } else if (registrationResultModel.code == AppCommonValues.REG_FAILED_CONSTRAINT) {
                Toast.makeText(this@RegisterActivity, "Sorry, this user id exists already", Toast.LENGTH_SHORT).show()
            } else if (registrationResultModel.code == AppCommonValues.REG_FAILED) {
                Toast.makeText(this@RegisterActivity, "Something went wrong, registration failed", Toast.LENGTH_SHORT).show()
            } else if(registrationResultModel.code == AppCommonValues.REG_ALL_FIELDS_REQUIRED) {
                Toast.makeText(this@RegisterActivity, "All fieldsare required", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this@RegisterActivity, "registration successful", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        AppDatabase.destroyInstance()
        super.onDestroy()
    }
}