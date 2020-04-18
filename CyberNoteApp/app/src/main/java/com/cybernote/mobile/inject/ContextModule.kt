package com.cybernote.mobile.inject

import android.app.Application
import android.content.Context
import com.cybernote.mobile.CyberNoteApplication
import dagger.Module
import dagger.Provides

@Module
abstract class ContextModule {

    companion object {
        @Provides
        @JvmStatic
        fun providesApplication(context: Context): Application = context as CyberNoteApplication
    }
}