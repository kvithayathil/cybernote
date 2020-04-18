package com.cybernote.mobile.inject

import android.content.Context
import android.content.SharedPreferences
import com.cybernote.mobile.data.AppDatabase
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ContextModule::class, PersistenceModule::class])
interface ApplicationComponent {

    val context: Context
    val sharedPreferences: SharedPreferences
    val appDatabase: AppDatabase

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): ApplicationComponent
    }
}