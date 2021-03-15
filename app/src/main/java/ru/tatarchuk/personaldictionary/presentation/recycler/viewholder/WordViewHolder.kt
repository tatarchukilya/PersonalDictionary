package ru.tatarchuk.personaldictionary.presentation.recycler.viewholder

import android.view.View
import android.widget.TextView
import ru.tatarchuk.personaldictionary.R
import ru.tatarchuk.personaldictionary.presentation.recycler.item.WordItem

/**
 * @author tatarchukilya@gmail.com
 */
class WordViewHolder(itemView: View) : BaseViewHolder<WordItem>(itemView) {

    private var wordView: TextView = itemView.findViewById(R.id.word_text_view)
    private var translationsView: TextView = itemView.findViewById(R.id.translation_text_view)

    override fun onBind(item: WordItem) {
        itemView.setOnClickListener { item.onClick.invoke() }
        wordView.text = item.word
        translationsView.text = item.translation
    }

    override fun onUnbind() {
        itemView.setOnClickListener(null)
    }
}