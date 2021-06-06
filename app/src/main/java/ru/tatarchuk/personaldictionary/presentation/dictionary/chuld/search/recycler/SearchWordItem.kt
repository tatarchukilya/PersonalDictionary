package ru.tatarchuk.personaldictionary.presentation.dictionary.chuld.search.recycler

import ru.tatarchuk.personaldictionary.presentation.recycler.ListItem

/**
 * @author tatarchukilya@gmail.com
 */
class SearchWordItem(val word: String, val translations: String, val click: () -> Unit) :
    ListItem {

    override fun viewType() = SearchViewType.WORD
}