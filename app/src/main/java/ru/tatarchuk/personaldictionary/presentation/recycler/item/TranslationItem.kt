package ru.tatarchuk.personaldictionary.presentation.recycler.item

import androidx.annotation.LayoutRes
import ru.tatarchuk.personaldictionary.R

/**
 * @author tatarchukilya@gmail.com
 */
class TranslationItem(val strings: List<String>) : BaseItem {

    @LayoutRes
    override fun layoutResId() = R.layout.view_translation

}