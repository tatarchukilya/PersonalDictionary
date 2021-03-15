package ru.tatarchuk.personaldictionary.di.module.remote

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import ru.tatarchuk.personaldictionary.data.remote.rest.asure.AsureRetrofitApi
import ru.tatarchuk.personaldictionary.data.remote.rest.asure.AsureTranslateApi
import ru.tatarchuk.personaldictionary.data.remote.rest.asure.AsureTranslateApiImpl
import javax.inject.Named
import javax.inject.Singleton

/**
 * @author tatarchukilya@gmail.com
 */
@Module
object AsureRemoteModule {

    private const val ASURE_TRANSLATE = "https://api.cognitive.microsofttranslator.com"

    @JvmStatic
    @Provides
    @Singleton
    @Named(ASURE_TRANSLATE)
    fun provideAsureTranslateRetrofit(httpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient)
        .baseUrl(ASURE_TRANSLATE)
        .build()

    @JvmStatic
    @Provides
    @Singleton
    fun provideAsureRetrofitApi(@Named(ASURE_TRANSLATE) retrofit: Retrofit): AsureRetrofitApi =
        retrofit.create(AsureRetrofitApi::class.java)

    @JvmStatic
    @Provides
    @Singleton
    fun provideAsureApi(asureApi: AsureRetrofitApi): AsureTranslateApi =
        AsureTranslateApiImpl(asureApi)

}