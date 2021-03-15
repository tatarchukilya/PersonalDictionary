package ru.tatarchuk.personaldictionary.domain.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import java.util.*

/**
 * @author tatarchukilya@gmail.com
 */

fun Flow<String>.capitalize() = flow {
    collect {
        emit(it.capitalize(Locale.ROOT))
    }
}