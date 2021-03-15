package ru.tatarchuk.personaldictionary.presentation.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.tatarchuk.personaldictionary.presentation.recycler.item.BaseItem
import ru.tatarchuk.personaldictionary.presentation.recycler.viewholder.BaseViewHolder

/**
 * @author tatarchukilya@gmail.com
 */
class RecyclerAdapter(private val factoryMethod: (ViewGroup, Int) -> BaseViewHolder<out BaseItem>) :
    RecyclerView.Adapter<BaseViewHolder<BaseItem>>() {

    private var items = mutableListOf<BaseItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    @Suppress("UNCHECKED_CAST")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<BaseItem> =
        factoryMethod(parent, viewType) as BaseViewHolder<BaseItem>


    override fun onBindViewHolder(holder: BaseViewHolder<BaseItem>, position: Int) {
        holder.onBind(items[position])
    }

    override fun onViewDetachedFromWindow(holder: BaseViewHolder<BaseItem>) {
        holder.onUnbind()
    }

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int) = items[position].layoutResId()

    fun add(item: BaseItem) {
        items.add(item)
        notifyDataSetChanged()
    }

    fun addItems(_items: List<BaseItem>) {
        items.addAll(_items)
        notifyDataSetChanged()
    }
}