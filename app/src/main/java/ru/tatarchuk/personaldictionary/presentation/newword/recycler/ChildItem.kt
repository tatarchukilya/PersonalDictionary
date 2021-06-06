package ru.tatarchuk.personaldictionary.presentation.newword.recycler

import ru.tatarchuk.personaldictionary.presentation.newword.recycler.NewWordViewType.*
import ru.tatarchuk.personaldictionary.presentation.recycler.ListItem
import java.util.*

/**
 * @author tatarchukilya@gmail.com
 */
class ChildItem(
    val id: UUID = UUID.randomUUID(),
    val parentId: Int,
    val word: String,
    val click: (Int) -> Unit,
    val textChange: (String) -> Unit
) : ListItem {
    override fun viewType() = Child.id
}