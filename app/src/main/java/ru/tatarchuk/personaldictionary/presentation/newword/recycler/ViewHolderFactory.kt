package ru.tatarchuk.personaldictionary.presentation.newword.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import ru.tatarchuk.personaldictionary.R
import ru.tatarchuk.personaldictionary.presentation.recycler.BaseViewHolder
import ru.tatarchuk.personaldictionary.presentation.recycler.ListItem

/**
 * @author tatarchukilya@gmail.com
 */

public enum class NewWordViewType(val id: Int) {
    Parent(0), Child(1)
}

fun newWordFactoryMethod(
    parent: ViewGroup,
    viewType: Int
): BaseViewHolder<out ListItem> {
    return when (viewType) {

        NewWordViewType.Child.id -> ChildViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.view_child_item, parent, false)
        )

        NewWordViewType.Parent.id -> ParentViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.view_parent_item, parent, false)
        )

        else -> throw IllegalArgumentException("Illegal view type $viewType")
    }
}
