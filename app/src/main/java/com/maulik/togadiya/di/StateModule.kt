package com.maulik.togadiya.di

import com.maulik.togadiya.view.home.HomeActivityState
import com.maulik.togadiya.view.login.LoginActivityState
import com.maulik.togadiya.view.splash.SplashActivityState
import com.maulik.togadiya.view.splash.SplashActivityViewModel
import org.koin.dsl.module

val stateModule = module {
    factory {
        SplashActivityState()
    }

    factory {
        LoginActivityState()
    }

    factory {
        HomeActivityState()
    }
}