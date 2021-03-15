package ru.tatarchuk.personaldictionary.presentation.recycler.item

import androidx.annotation.LayoutRes

/**
 * @author tatarchukilya@gmail.com
 */
interface BaseItem {

    @LayoutRes
    fun layoutResId(): Int
}