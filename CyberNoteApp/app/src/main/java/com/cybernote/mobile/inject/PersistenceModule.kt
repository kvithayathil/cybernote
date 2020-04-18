package com.cybernote.mobile.inject

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import com.cybernote.mobile.data.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.Reusable
import javax.inject.Singleton

@Module
abstract class PersistenceModule {

    companion object {

        @Provides
        @Reusable
        @JvmStatic
        fun providesSharedPreferences(context: Context): SharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(context)

        @Provides
        @Singleton
        @JvmStatic
        fun providesAppDatabase(context: Context) = AppDatabase.getInstance(context)
    }
}