package ru.tatarchuk.personaldictionary.data.remote.rest.asure

import retrofit2.http.Body
import retrofit2.http.HeaderMap
import retrofit2.http.POST
import retrofit2.http.Query
import ru.tatarchuk.personaldictionary.data.remote.rest.asure.model.AsureRequestBody
import ru.tatarchuk.personaldictionary.data.remote.rest.asure.model.AsureResponseBody

/**
 * @author tatarchukilya@gmail.com
 */
interface AsureRetrofitApi {

//        @Headers(
//        "Ocp-Apim-Subscription-Key: ${BuildConfig.ASURE_TRANSLATE_API_KEY}",
//        "Content-Type: application/json"
//    )
    @POST("/translate?")
    suspend fun getTranslation(
        @HeaderMap headers: Map<String, String>,
        @Query("api-version") version: String,
        @Query("from") from: String,
        @Query("to") to: String,
        @Body body: AsureRequestBody
    ): AsureResponseBody
}