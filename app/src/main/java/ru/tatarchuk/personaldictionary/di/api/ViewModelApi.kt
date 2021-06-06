package ru.tatarchuk.personaldictionary.di.api

import ru.tatarchuk.personaldictionary.presentation.dictionary.chuld.root.DictionaryViewModel
import ru.tatarchuk.personaldictionary.presentation.newword.NewWordViewModel
import ru.tatarchuk.personaldictionary.presentation.dictionary.chuld.search.SearchViewModel
import ru.tatarchuk.personaldictionary.presentation.viewmodel.*

/**
 * @author tatarchukilya@gmail.com
 */
interface ViewModelApi {

    fun getDictionaryViewModelFactory(): ViewModelProviderFactory<DictionaryViewModel>

    fun getSingleWordViewModelFactory(): ViewModelProviderFactory<SingleWordViewModel>

    fun getAddWordViewModelFactory(): ViewModelProviderFactory<NewWordViewModel>

    fun getSendNewWordViewModelFactory() : ViewModelProviderFactory<SendNewWordViewModel>

    fun getSearchViewModelFactory() : ViewModelProviderFactory<SearchViewModel>
}