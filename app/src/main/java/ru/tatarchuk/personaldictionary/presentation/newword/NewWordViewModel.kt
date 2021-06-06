package ru.tatarchuk.personaldictionary.presentation.newword

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import ru.tatarchuk.personaldictionary.domain.usecase.newword.NewWordUseCase

/**
 * @author tatarchukilya@gmail.com
 */
class NewWordViewModel(private val useCase: NewWordUseCase) : ViewModel() {

//    private val progress = MutableLiveData(false)
//    private val items = MutableLiveData(listOf<ListItem>())
//
//    fun search(input: String) {
//        viewModelScope.launch {
//            useCase
//                .getTranslationById(input)
//                .toItems(click)
//                .flowOn(Dispatchers.IO)
//                .onStart {
//                    items.postValue(listOf())
//                    progress.value = true
//                }
//                .catch {
//                    handleError(it)
//                }
//                .onCompletion {
//                    Log.i("<>", "onCompletion")
//                    progress.value = false
//                }
//                .collect {
//                    Log.i("<>", it.toString())
//                    items.postValue(it)
//                }
//        }
//    }
//
//    fun dictionaryTest() {
//        viewModelScope.launch {
//            useCase.getDictionary()
//                .flowOn(Dispatchers.IO)
//                .catch { handleError(it) }
//                .collect {
//                    Log.i("<>", "result: $it")
//                }
//        }
//    }
//
//    fun progress(): LiveData<Boolean> = progress
//
//    fun items(): LiveData<List<ListItem>> = items
//
//    private fun handleError(thr: Throwable) {
//
//    }
//
//    private val click: (String) -> Unit = {
//        Log.i("<>", "click $it")
//    }

    //private fun handleResult()
}