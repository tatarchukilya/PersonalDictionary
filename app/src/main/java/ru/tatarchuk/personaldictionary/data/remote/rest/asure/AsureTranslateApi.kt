package ru.tatarchuk.personaldictionary.data.remote.rest.asure

import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import ru.tatarchuk.personaldictionary.data.remote.rest.asure.model.AsureResponseBody

/**
 * @author tatarchukilya@gmail.com
 */
interface AsureTranslateApi {

    suspend fun getTranslation(input: String): Flow<AsureResponseBody>
}