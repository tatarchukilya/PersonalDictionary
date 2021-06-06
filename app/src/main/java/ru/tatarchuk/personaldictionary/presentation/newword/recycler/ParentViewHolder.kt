package ru.tatarchuk.personaldictionary.presentation.newword.recycler

import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import ru.tatarchuk.personaldictionary.R
import ru.tatarchuk.personaldictionary.presentation.recycler.RecyclerAdapter
import ru.tatarchuk.personaldictionary.presentation.recycler.BaseViewHolder

/**
 * @author tatarchukilya@gmail.com
 */
class ParentViewHolder(view: View) : BaseViewHolder<ParentItem>(view) {

    private val editWordView: EditText = itemView.findViewById(R.id.edit_word)

    private val adapter = RecyclerAdapter { parent: ViewGroup, viewType: Int ->
        newWordFactoryMethod(parent, viewType)
    }

    override fun onBind(item: ParentItem) {

    }

    public fun add() {

    }
}