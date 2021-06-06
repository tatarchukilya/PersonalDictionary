package ru.tatarchuk.personaldictionary.presentation.dictionary.chuld.root

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.tatarchuk.personaldictionary.domain.usecase.dictionary.DictionaryUseCase
import ru.tatarchuk.personaldictionary.presentation.recycler.ListItem
import ru.tatarchuk.personaldictionary.presentation.viewmodel.SingleLiveEvent

/**
 * @author tatarchukilya@gmail.com
 */
class DictionaryViewModel(private val useCase: DictionaryUseCase) : ViewModel() {

    val items: MutableLiveData<List<ListItem>> = MutableLiveData(mutableListOf())
    private val showDetailsEvent: SingleLiveEvent<String> = SingleLiveEvent()

    fun getWordList() {
        viewModelScope.launch {
            val words = useCase.getWordList()
            val data = mutableListOf<ListItem>()
//            for (word in words) {
//                data.add(WordItem(word.word, word.translations) { showDetails(word.word) })
//            }
            items.value = data
        }
    }

    private fun showDetails(word: String) {
        showDetailsEvent.value = word
    }
}