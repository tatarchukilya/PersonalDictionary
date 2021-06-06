package ru.tatarchuk.personaldictionary.presentation.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import ru.tatarchuk.personaldictionary.R
import ru.tatarchuk.personaldictionary.presentation.newword.recycler.NewWordViewType
import ru.tatarchuk.personaldictionary.presentation.newword.recycler.ChildViewHolder

/**
 * @author tatarchukilya@gmail.com
 */
fun createDictionaryViewHolders(
    parent: ViewGroup,
    viewType: Int
): BaseViewHolder<out ListItem> {
    return when (viewType) {
        NewWordViewType.Child.id -> ChildViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.nested_item_view, parent, false)
        )
        else -> throw IllegalArgumentException("Illegal view type $viewType")
    }
}
