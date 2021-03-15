package ru.tatarchuk.personaldictionary.presentation.recycler.item

import ru.tatarchuk.personaldictionary.R

/**
 * @author tatarchukilya@gmail.com
 */
data class WordItem(
    val word: String = "",
    val translation: String = "",
    val onClick: () -> Unit
) : BaseItem {

    override fun layoutResId() = R.layout.view_word
}