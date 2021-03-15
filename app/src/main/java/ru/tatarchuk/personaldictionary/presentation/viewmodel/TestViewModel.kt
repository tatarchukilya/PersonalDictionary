package ru.tatarchuk.personaldictionary.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import ru.tatarchuk.personaldictionary.domain.usecase.TestInteractor
import ru.tatarchuk.personaldictionary.utils.TAG

/**
 * @author tatarchukilya@gmail.com
 */
class TestViewModel(
    private val interactor: TestInteractor
) : ViewModel() {

    fun getGoogleTranslation(input: String) {
        viewModelScope.launch {
            interactor.getGoogleTranslations(input)
                .flowOn(Dispatchers.IO)
                .onStart {
                    Log.i(TAG, "onStart")
                }
                .catch {
                    Log.i(TAG, "catch", it)
                }
                .onCompletion {
                    Log.i(TAG, "onCompletion", it)
                }
                .collect {
                    Log.i(TAG, "collect $it")
                }
        }
    }

    fun getAsureTranslation(input: String) {
        viewModelScope.launch {
            interactor.getAsureTranslations(input)
                .flowOn(Dispatchers.IO)
                .onStart {
                    Log.i(TAG, "onStart")
                }
                .catch {
                    Log.i(TAG, "catch", it)
                }
                .onCompletion {
                    Log.i(TAG, "onCompletion", it)
                }
                .collect {
                    //interactor.addWord(WordEntity(input, "", it, ""))
                    Log.i(TAG, it)
                }
        }
    }

    fun getTranslation(input: String) {
        viewModelScope.launch {
            interactor
                .getTranslationById(input)
                .flowOn(Dispatchers.IO)
                .catch {
                    Log.e(TAG, "Load failed", it)
                }
                .collect { word ->
                    Log.i(TAG, "success: ${word.toString()}")
                }
        }
    }
}