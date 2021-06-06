package ru.tatarchuk.personaldictionary.domain

/**
 * @author tatarchukilya@gmail.com
 */
sealed class ResultWrapper<out T> {
    data class Success<out T>(val value: T) : ResultWrapper<T>()
    data class Error(val error: Pair<Int, Int>) : ResultWrapper<Nothing>()
}
