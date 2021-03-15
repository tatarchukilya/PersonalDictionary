package ru.tatarchuk.personaldictionary.data.remote.rest.google

import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import ru.tatarchuk.personaldictionary.data.remote.rest.google.model.GoogleBody

/**
 * @author tatarchukilya@gmail.com
 */
interface GoogleTranslateApi {

    suspend fun getTranslation(input: String) : Flow<GoogleBody>
}