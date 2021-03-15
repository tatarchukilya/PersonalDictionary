package ru.tatarchuk.personaldictionary.di.module.remote

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import ru.tatarchuk.personaldictionary.data.remote.rest.google.GoogleTranslateApi
import ru.tatarchuk.personaldictionary.data.remote.rest.google.GoogleTranslateApiImpl
import ru.tatarchuk.personaldictionary.data.remote.rest.google.GoogleRetrofitApi
import javax.inject.Named
import javax.inject.Singleton

/**
 * @author tatarchukilya@gmail.com
 */
@Module
object GoogleRemoteModule {

    private const val GOOGLE_TRANSLATE = "https://translation.googleapis.com"

    @JvmStatic
    @Provides
    @Singleton
    @Named(GOOGLE_TRANSLATE)
    fun provideGoogleTranslateRetrofit(httpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient)
        .baseUrl(GOOGLE_TRANSLATE)
        .build()

    @JvmStatic
    @Provides
    @Singleton
    fun provideGoogleRetrofitApi(@Named(GOOGLE_TRANSLATE) retrofit: Retrofit): GoogleRetrofitApi =
        retrofit.create(GoogleRetrofitApi::class.java)

    @JvmStatic
    @Provides
    @Singleton
    fun provideGoogleApi(googleApi: GoogleRetrofitApi): GoogleTranslateApi =
        GoogleTranslateApiImpl(googleApi)
}