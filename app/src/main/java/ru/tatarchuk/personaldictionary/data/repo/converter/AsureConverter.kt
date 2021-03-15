package ru.tatarchuk.personaldictionary.data.repo.converter

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import ru.tatarchuk.personaldictionary.data.remote.rest.asure.model.AsureResponseBody

/**
 * @author tatarchukilya@gmail.com
 */
fun Flow<AsureResponseBody>.getTranslate() = flow {
    collect {
        emit(it[0].translations[0].text)
    }
}