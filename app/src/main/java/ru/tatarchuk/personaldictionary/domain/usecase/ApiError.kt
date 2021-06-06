package ru.tatarchuk.personaldictionary.domain.usecase

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author tatarchukilya@gmail.com
 */
data class ApiError(
    @SerializedName("status")
    @Expose
    val status: Int,
    @SerializedName("message")
    @Expose
    val message: String = "",
    @SerializedName("reason")
    @Expose
    val reason: String = ""
)
