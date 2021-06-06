package ru.tatarchuk.personaldictionary.presentation.newword.recycler

import ru.tatarchuk.personaldictionary.presentation.recycler.DiffUtilsCallback

/**
 * @author tatarchukilya@gmail.com
 */
class ListDiffUtilsCallback(oldList: List<ChildItem>, newList: List<ChildItem>) :
    DiffUtilsCallback(oldList, newList) {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldItemPosition == newItemPosition

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition] == newList[newItemPosition]
}