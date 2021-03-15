package ru.tatarchuk.personaldictionary.presentation.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import ru.tatarchuk.personaldictionary.R
import ru.tatarchuk.personaldictionary.presentation.recycler.item.BaseItem
import ru.tatarchuk.personaldictionary.presentation.recycler.viewholder.BaseViewHolder
import ru.tatarchuk.personaldictionary.presentation.recycler.viewholder.WordViewHolder

/**
 * @author tatarchukilya@gmail.com
 */
fun createDictionaryViewHolders(parent: ViewGroup, viewType: Int): BaseViewHolder<out BaseItem> {
    return when (viewType) {
        R.layout.view_word -> WordViewHolder(
            LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        )
        else -> throw IllegalArgumentException("Illegal view type $viewType")
    }
}