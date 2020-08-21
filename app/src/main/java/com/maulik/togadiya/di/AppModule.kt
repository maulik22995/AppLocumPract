package com.maulik.togadiya.di

import android.content.Context
import com.maulik.togadiya.preferances.DefaultPreference
import com.maulik.togadiya.preferances.NormalPreference
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {

    single {
        androidContext().getSharedPreferences(androidContext().packageName, Context.MODE_PRIVATE)
    }

    single {
        NormalPreference()
    }
    single {
        DefaultPreference()
    }
}