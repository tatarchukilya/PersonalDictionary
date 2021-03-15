package ru.tatarchuk.personaldictionary.data.remote.rest.asure

import kotlinx.coroutines.flow.flow
import ru.tatarchuk.personaldictionary.BuildConfig
import ru.tatarchuk.personaldictionary.data.remote.rest.asure.model.AsureRequestBody
import ru.tatarchuk.personaldictionary.data.remote.rest.asure.model.AsureRequestBodyItem
import ru.tatarchuk.personaldictionary.utils.Lang

/**
 * @author tatarchukilya@gmail.com
 */
class AsureTranslateApiImpl(private val api: AsureRetrofitApi) : AsureTranslateApi {

    override suspend fun getTranslation(input: String) = flow {
        emit(api.getTranslation(HEADERS, VERSION, Lang.EN, Lang.RU, createBody(input)))
    }

    companion object {
        private const val VERSION = "3.0"
        private val HEADERS = HashMap<String, String>().apply {
            put("Ocp-Apim-Subscription-Key", BuildConfig.ASURE_TRANSLATE_API_KEY)
            put("Content-Type", "application/json")
        }

        @JvmStatic
        @JvmName("create")
        private fun createBody(word: String): AsureRequestBody =
            AsureRequestBody().apply {
                add(AsureRequestBodyItem(word))
            }
    }
}