package ru.tatarchuk.personaldictionary.presentation.dictionary.chuld.search.recycler

import ru.tatarchuk.personaldictionary.presentation.recycler.ListItem

/**
 * @author tatarchukilya@gmail.com
 */
class SearchEmptyResultItem : ListItem {

    override fun viewType() = SearchViewType.EMPTY_RESULT
}