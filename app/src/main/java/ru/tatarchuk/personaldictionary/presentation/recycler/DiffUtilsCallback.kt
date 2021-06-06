package ru.tatarchuk.personaldictionary.presentation.recycler

import androidx.recyclerview.widget.DiffUtil

/**
 * @author tatarchukilya@gmail.com
 */
abstract class DiffUtilsCallback(
    val oldList: List<ListItem>,
    val newList: List<ListItem>
) : DiffUtil.Callback() {


    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size
}