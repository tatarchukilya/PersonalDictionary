package ru.tatarchuk.personaldictionary.presentation.newword.recycler

import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.core.widget.doAfterTextChanged
import ru.tatarchuk.personaldictionary.R
import ru.tatarchuk.personaldictionary.presentation.recycler.BaseViewHolder

/**
 * @author tatarchukilya@gmail.com
 */
class ChildViewHolder(view: View) : BaseViewHolder<ChildItem>(view) {

    private val editText = itemView.findViewById<EditText>(R.id.edit_word)
    private val removeIcon = itemView.findViewById<ImageView>(R.id.remove_icon)

    override fun onBind(item: ChildItem) {
        if (editText.text.toString() != item.word) {
            editText.setText(item.word)
        }
        editText.doAfterTextChanged { text ->
            item.textChange(text.toString())
        }
        removeIcon.setOnClickListener {
            item.click(adapterPosition)
        }
    }
}