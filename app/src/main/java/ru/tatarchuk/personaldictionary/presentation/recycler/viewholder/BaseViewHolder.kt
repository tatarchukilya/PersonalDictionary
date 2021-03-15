package ru.tatarchuk.personaldictionary.presentation.recycler.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ru.tatarchuk.personaldictionary.presentation.recycler.item.BaseItem

/**
 * @author tatarchukilya@gmail.com
 */
abstract class BaseViewHolder<T : BaseItem>(view: View) : RecyclerView.ViewHolder(view) {

    abstract fun onBind(item: T)

    open fun onUnbind() {}
}