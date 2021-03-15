package ru.tatarchuk.personaldictionary.data.remote.rest.google

import retrofit2.http.GET
import retrofit2.http.Query
import ru.tatarchuk.personaldictionary.data.remote.rest.google.model.GoogleBody
import ru.tatarchuk.personaldictionary.utils.Lang

/**
 * @author tatarchukilya@gmail.com
 */
interface GoogleRetrofitApi {

    @GET("/language/translate/v2?")
    suspend fun getTranslation(
        @Query("target") @Lang target: String,
        @Query("source") @Lang source: String,
        @Query("key") key: String,
        @Query("q") input: String
    ) : GoogleBody
}