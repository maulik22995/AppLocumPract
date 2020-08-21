package com.maulik.togadiya

import android.app.Application
import com.maulik.togadiya.di.appModule
import com.maulik.togadiya.di.netWorkModule
import com.maulik.togadiya.di.stateModule
import com.maulik.togadiya.di.viewModleModule
import org.koin.android.ext.android.getKoin
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.core.scope.ScopeID

class ApplicationClass : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(applicationContext)
            modules(listOf(appModule,netWorkModule, stateModule, viewModleModule))
        }
//        getKoin().createScope(ScopeID(), named("APP"))
    }

}