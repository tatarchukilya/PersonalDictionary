package ru.tatarchuk.personaldictionary.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.tatarchuk.personaldictionary.data.remote.rest.dictionary.model.NewWord
import ru.tatarchuk.personaldictionary.domain.ResultWrapper
import ru.tatarchuk.personaldictionary.domain.usecase.sendnewword.SendNewWordUseCase
import ru.tatarchuk.personaldictionary.utils.TAG

/**
 * @author tatarchukilya@gmail.com
 */
class SendNewWordViewModel(private val useCase: SendNewWordUseCase) : ViewModel() {

    fun addWord(word: String, transcription: String, translation: String, example: String?) {
        viewModelScope.launch {
            when (val result =
                useCase.addWord(createData(word, transcription, translation, example))) {
                is ResultWrapper.Success -> {
                    Log.i(TAG, "success ${result.value}")
                }
                is ResultWrapper.Error -> {
                    Log.i(TAG, "error ${result.error}")
                }
            }
        }
    }

    private fun createData(
        word: String,
        transcription: String,
        translation: String,
        example: String?
    ): NewWord {
        val exampleList = example?.let {
            listOf(it)
        } ?: listOf()

        return NewWord(
            word,
            transcription,
            listOf(translation),
            exampleList
        )
    }
}