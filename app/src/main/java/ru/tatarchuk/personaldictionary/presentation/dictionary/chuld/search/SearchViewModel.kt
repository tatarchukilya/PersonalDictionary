package ru.tatarchuk.personaldictionary.presentation.dictionary.chuld.search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.tatarchuk.personaldictionary.data.remote.rest.dictionary.model.Word
import ru.tatarchuk.personaldictionary.domain.ResultWrapper
import ru.tatarchuk.personaldictionary.domain.usecase.search.SearchUseCase
import ru.tatarchuk.personaldictionary.presentation.dictionary.chuld.search.recycler.EmptyItem
import ru.tatarchuk.personaldictionary.presentation.recycler.ListItem
import ru.tatarchuk.personaldictionary.presentation.dictionary.chuld.search.recycler.SearchEmptyResultItem
import ru.tatarchuk.personaldictionary.presentation.dictionary.chuld.search.recycler.SearchWordItem
import ru.tatarchuk.personaldictionary.presentation.viewmodel.SingleLiveEvent
import ru.tatarchuk.personaldictionary.utils.TAG

/**
 * @author tatarchukilya@gmail.com
 */
class SearchViewModel(private val useCase: SearchUseCase) : ViewModel() {

    private var searchJob: Job? = null

    private val debounce = 300L
    private val _error = MutableLiveData<Pair<Int, Int>>()
    private val _words = MutableLiveData<List<ListItem>>()
    private val _progress = MutableLiveData<Boolean>()
    private var emptyResult = listOf<ListItem>(SearchEmptyResultItem())
    private var searchResult = listOf<Word>()
    private val newWord = SingleLiveEvent<Word>()

    fun word(): LiveData<List<ListItem>> = _words
    fun error(): LiveData<Pair<Int, Int>> = _error
    fun progress(): LiveData<Boolean> = _progress

    fun search(input: String) {
        searchJob?.cancel()
        searchResult = listOf()
        _words.postValue(listOf())
        if (input.isEmpty()) {
            _progress.value = false
            return
        }
        searchJob = viewModelScope.launch {
            _progress.postValue(true)
            delay(debounce)
            when (val result = useCase.search(input)) {
                is ResultWrapper.Success<List<Word>> -> {
                    searchResult = result.value
                    setResult(searchResult)
                }
                is ResultWrapper.Error -> {
                    Log.i(TAG, "Error")
                }
            }
            _progress.postValue(false)
        }
    }

    private fun setResult(list: List<Word>) {
        val result = mutableListOf<ListItem>()
        result.add(EmptyItem())
        if (list.isEmpty()) {
            _words.postValue(emptyResult)
        } else {
            result.addAll(list.mapIndexed { index, word ->
                SearchWordItem(word.word, word.translation.joinToString()) { wordClick(index) }})

//            _words.postValue(list.mapIndexed { index, word ->
//                SearchWordItem(word.word, word.translation.joinToString()) { wordClick(index) }
//            })
        }
        _words.postValue(result)
    }

    private fun wordClick(position: Int) {
        newWord.postValue(searchResult[position])
    }

    override fun onCleared() {
        searchJob?.cancel()
        Log.i(TAG, "onCleared")
    }
}