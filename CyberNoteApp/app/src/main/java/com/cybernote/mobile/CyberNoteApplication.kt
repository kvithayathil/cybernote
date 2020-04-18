package com.cybernote.mobile

import android.app.Application
import android.content.Context
import com.cybernote.mobile.inject.ApplicationComponent
import com.cybernote.mobile.inject.DaggerApplicationComponent
import timber.log.Timber

class CyberNoteApplication: Application() {

    val applicationComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

    override fun onCreate() {
        super.onCreate()
        setUpLogging()
    }

    private fun setUpLogging() {
        Timber.plant(Timber.DebugTree())
    }
}


fun Context.getApplicationComponent(): ApplicationComponent = this.applicationContext.getApplicationComponent()