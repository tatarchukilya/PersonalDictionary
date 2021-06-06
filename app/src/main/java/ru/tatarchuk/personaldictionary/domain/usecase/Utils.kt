package ru.tatarchuk.personaldictionary.domain.usecase

import com.google.gson.GsonBuilder


/**
 * @author tatarchukilya@gmail.com
 */
fun parseHttpError(json: String): ApiError {
    return GsonBuilder().create().fromJson(json, ApiError::class.java);
}