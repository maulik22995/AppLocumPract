package com.maulik.togadiya.view.splash

import androidx.lifecycle.observe
import com.maulik.togadiya.R
import com.maulik.togadiya.base.BaseActivity
import com.maulik.togadiya.databinding.ActivitySplashBinding
import com.maulik.togadiya.extension.navigateToAndFinish
import com.maulik.togadiya.view.home.HomeActivity
import com.maulik.togadiya.view.login.LoginActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity :
    BaseActivity<ActivitySplashBinding, SplashActivityState, SplashActivityViewModel>(R.layout.activity_splash) {

    override val viewModel: SplashActivityViewModel by viewModel()

    override fun observeViewStat(state: SplashActivityState) {
        state.delayState.observe(this) {
            when (it) {
                true -> {
                    navigateToAndFinish<HomeActivity>()
                }
                false -> {
                    navigateToAndFinish<LoginActivity>()
                }
            }
        }
    }

}