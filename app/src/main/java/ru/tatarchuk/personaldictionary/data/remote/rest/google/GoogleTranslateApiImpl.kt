package ru.tatarchuk.personaldictionary.data.remote.rest.google

import kotlinx.coroutines.flow.flow
import ru.tatarchuk.personaldictionary.BuildConfig
import ru.tatarchuk.personaldictionary.utils.Lang

/**
 * @author tatarchukilya@gmail.com
 */
class GoogleTranslateApiImpl(
    private val api: GoogleRetrofitApi
) : GoogleTranslateApi {

    override suspend fun getTranslation(input: String) = flow {
        emit(api.getTranslation(Lang.RU, Lang.EN, KEY, input))
    }

    companion object {
        private const val KEY = BuildConfig.GOOGEL_TRANSLATE_API_KEY
        private const val FAILED_KEY = "failed_test_key"
    }
}