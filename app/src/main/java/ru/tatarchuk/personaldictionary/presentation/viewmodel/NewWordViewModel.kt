package ru.tatarchuk.personaldictionary.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.tatarchuk.personaldictionary.data.repo.model.FirestoreModel
import ru.tatarchuk.personaldictionary.domain.usecase.newword.NewWordInteractor
import ru.tatarchuk.personaldictionary.utils.TAG

/**
 * @author tatarchukilya@gmail.com
 */
class NewWordViewModel(private val interactor: NewWordInteractor) : ViewModel() {

    private var searchJob: Job? = null

    fun search(input: String) {
        searchJob?.cancel()
        searchJob = viewModelScope.launch(Dispatchers.IO) {
            val result: FirestoreModel
            try {
                result = interactor.getWordData(input)
                Log.i(TAG, result.toString())
            } catch (e: Exception) {
                Log.i(TAG, "failed", e)
            }
        }
    }
}