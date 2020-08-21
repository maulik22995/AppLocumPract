package com.maulik.togadiya.di

import com.maulik.togadiya.view.home.HomeActivityViewModel
import com.maulik.togadiya.view.login.LoginActivityViewModel
import com.maulik.togadiya.view.splash.SplashActivityViewModel
import org.koin.dsl.module

val viewModleModule = module {
    factory {
        SplashActivityViewModel(get(),get())
    }

    factory {
        LoginActivityViewModel(get())
    }

    factory {
        HomeActivityViewModel(get())
    }
}