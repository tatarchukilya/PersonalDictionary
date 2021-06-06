package ru.tatarchuk.personaldictionary.presentation.dictionary.chuld.search.recycler

import android.view.View
import android.widget.Button
import android.widget.Toast
import ru.tatarchuk.personaldictionary.R
import ru.tatarchuk.personaldictionary.presentation.recycler.BaseViewHolder

/**
 * @author tatarchukilya@gmail.com
 */
class SearchEmptyResultViewHolder(view: View) : BaseViewHolder<SearchEmptyResultItem>(view) {

    private val suggestButton = itemView.findViewById<Button>(R.id.suggest_button)

    override fun onBind(item: SearchEmptyResultItem) {
        suggestButton.setOnClickListener {
            Toast.makeText(itemView.context, "Coming soon!", Toast.LENGTH_SHORT).show()
        }
    }
}