package ru.tatarchuk.personaldictionary.presentation.dictionary.chuld.search.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.IntDef
import ru.tatarchuk.personaldictionary.R
import ru.tatarchuk.personaldictionary.presentation.dictionary.chuld.search.recycler.SearchViewType.Companion.EMPTY
import ru.tatarchuk.personaldictionary.presentation.recycler.BaseViewHolder
import ru.tatarchuk.personaldictionary.presentation.recycler.ListItem
import ru.tatarchuk.personaldictionary.presentation.dictionary.chuld.search.recycler.SearchViewType.Companion.EMPTY_RESULT
import ru.tatarchuk.personaldictionary.presentation.dictionary.chuld.search.recycler.SearchViewType.Companion.WORD

/**
 * @author tatarchukilya@gmail.com
 */

@IntDef(EMPTY, WORD, EMPTY_RESULT)
@Retention(AnnotationRetention.SOURCE)
annotation class SearchViewType {
    companion object {
        const val EMPTY = -1
        const val WORD = 0
        const val EMPTY_RESULT = 1
    }
}

fun createSearchViewHolders(
    parent: ViewGroup,
    @SearchViewType viewType: Int
): BaseViewHolder<out ListItem> {
    return when (viewType) {
        EMPTY -> EmptyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.view_empty, parent, false)
        )
        WORD -> SearchWordViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.view_search_single_word, parent, false)
        )
        EMPTY_RESULT -> SearchEmptyResultViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.view_search_empty_result, parent, false)
        )
        else -> throw IllegalArgumentException("Illegal view type $viewType")
    }
}
