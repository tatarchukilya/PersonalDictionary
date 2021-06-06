package ru.tatarchuk.personaldictionary.presentation.dictionary.chuld.search.recycler

import ru.tatarchuk.personaldictionary.presentation.dictionary.chuld.search.recycler.SearchViewType.Companion.EMPTY
import ru.tatarchuk.personaldictionary.presentation.recycler.ListItem

/**
 * @author tatarchukilya@gmail.com
 */
class EmptyItem : ListItem {

    override fun viewType() = EMPTY
}