package com.maulik.togadiya.view.login

import androidx.lifecycle.observe
import com.maulik.togadiya.R
import com.maulik.togadiya.base.BaseActivity
import com.maulik.togadiya.databinding.ActivityLoginBinding
import com.maulik.togadiya.extension.hideKeyBoard
import com.maulik.togadiya.extension.navigateTo
import com.maulik.togadiya.extension.navigateToAndFinish
import com.maulik.togadiya.view.home.HomeActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity :
    BaseActivity<ActivityLoginBinding, LoginActivityState, LoginActivityViewModel>(R.layout.activity_login) {
    override val viewModel: LoginActivityViewModel by viewModel()

    override fun observeViewStat(state: LoginActivityState) {
        state.clickEvent.observe(this) {
            when (it) {
                is ClickEvent.loginButton -> {
                    viewModel.state.email.value = etEmail.text.toString()
                    viewModel.state.password.value = etPassword.text.toString()
                    viewModel.isUserInputValid()
                }
            }
        }

        state.validationLiveData.observe(this) { errorMessage ->
            errorMessage.run {
                when {
                    invalidEmail != 0 -> {
                        toast(getString(invalidEmail))
                        etEmail.requestFocus()
                    }
                    emptyEmail != 0 -> {
                        toast(getString(emptyEmail))
                        etEmail.requestFocus()
                    }
                    emptyPassword != 0 -> {
                        toast(getString(emptyPassword))
                        etPassword.requestFocus()
                    }
                    invalidUser != 0 -> {
                        toast(getString(invalidUser))
                    }
                    else -> {
                        hideKeyBoard()
                        defaultPref.data.isLoggedIn = true
                        defaultPref.store()
                        navigateToAndFinish<HomeActivity>()
                    }
                }
            }
        }
    }
}