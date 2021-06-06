package ru.tatarchuk.personaldictionary.di.module.remote

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import ru.tatarchuk.personaldictionary.data.remote.rest.dictionary.DictionaryRetrofitApi
import ru.tatarchuk.personaldictionary.data.remote.rest.dictionary.DictionaryTranslateApi
import ru.tatarchuk.personaldictionary.data.remote.rest.dictionary.DictionaryTranslateApiImpl
import javax.inject.Named
import javax.inject.Singleton

/**
 * @author tatarchukilya@gmail.com
 */
@Module
object DictionaryModule {

    private const val DICTIONARY_TRANSLATE = "https://nblackie.ru"

    @JvmStatic
    @Provides
    @Singleton
    @Named(DICTIONARY_TRANSLATE)
    fun provideDictionaryTranslateRetrofit(httpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient)
        .baseUrl(DICTIONARY_TRANSLATE)
        .build()

    @JvmStatic
    @Provides
    @Singleton
    fun provideDictionaryRetrofitApi(@Named(DICTIONARY_TRANSLATE) retrofit: Retrofit): DictionaryRetrofitApi =
        retrofit.create(DictionaryRetrofitApi::class.java)

    @JvmStatic
    @Provides
    @Singleton
    fun provideDictionaryApi(api: DictionaryRetrofitApi): DictionaryTranslateApi =
        DictionaryTranslateApiImpl(api)
}