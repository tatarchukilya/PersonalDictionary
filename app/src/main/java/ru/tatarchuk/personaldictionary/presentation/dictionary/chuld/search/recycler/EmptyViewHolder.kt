package ru.tatarchuk.personaldictionary.presentation.dictionary.chuld.search.recycler

import android.view.View
import ru.tatarchuk.personaldictionary.presentation.recycler.BaseViewHolder

/**
 * @author tatarchukilya@gmail.com
 */
class EmptyViewHolder(view: View): BaseViewHolder<EmptyItem>(view) {

    override fun onBind(item: EmptyItem) {
    }
}