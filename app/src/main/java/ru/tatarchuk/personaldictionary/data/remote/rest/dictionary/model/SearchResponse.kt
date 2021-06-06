package ru.tatarchuk.personaldictionary.data.remote.rest.dictionary.model

data class SearchResponse(
    val result: List<Word>,
    val status: Int
)