package ru.tatarchuk.personaldictionary.di.module.remote

import android.util.Log
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import ru.tatarchuk.personaldictionary.utils.TAG
import javax.inject.Singleton

/**
 * @author tatarchukilya@gmail.com
 */
@Module
object RemoteModule {

    @JvmStatic
    @Provides
    @Singleton
    fun provideInterceptor() = HttpLoggingInterceptor {
        Log.d(TAG, it)
    }.setLevel(Level.BODY)

    @JvmStatic
    @Provides
    @Singleton
    fun provideOkHttpClient(interceptor: HttpLoggingInterceptor) = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()
}