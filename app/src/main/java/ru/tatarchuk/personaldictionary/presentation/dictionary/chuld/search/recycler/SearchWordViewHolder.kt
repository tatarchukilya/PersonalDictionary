package ru.tatarchuk.personaldictionary.presentation.dictionary.chuld.search.recycler

import android.view.View
import android.widget.TextView
import ru.tatarchuk.personaldictionary.R
import ru.tatarchuk.personaldictionary.presentation.recycler.BaseViewHolder

/**
 * @author tatarchukilya@gmail.com
 */
class SearchWordViewHolder(view: View) : BaseViewHolder<SearchWordItem>(view),
    View.OnClickListener {

    init {
        itemView.setOnClickListener(this)
    }

    private val word = itemView.findViewById<TextView>(R.id.word_text_view)
    private val translation = itemView.findViewById<TextView>(R.id.translation_text_view)
    private lateinit var click:() -> Unit

    override fun onBind(item: SearchWordItem) {
        word.text = item.word
        translation.text = item.translations
        click = item.click
    }

    override fun onClick(v: View?) {
        click()
    }
}