package ru.tatarchuk.personaldictionary.presentation.newword.recycler

import ru.tatarchuk.personaldictionary.presentation.newword.recycler.NewWordViewType.*
import ru.tatarchuk.personaldictionary.presentation.recycler.ListItem

/**
 * @author tatarchukilya@gmail.com
 */
class ParentItem(val id: Int, val name: String) : ListItem {

    override fun viewType() = Parent.id
}
