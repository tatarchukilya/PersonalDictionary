package ru.tatarchuk.personaldictionary.presentation.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * @author tatarchukilya@gmail.com
 */
class RecyclerAdapter(
    private val factoryMethod: (
        ViewGroup,
        Int
    ) -> BaseViewHolder<out ListItem>
) :
    RecyclerView.Adapter<BaseViewHolder<ListItem>>() {

    var items = mutableListOf<ListItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    @Suppress("UNCHECKED_CAST")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<ListItem> =
        factoryMethod(parent, viewType) as BaseViewHolder<ListItem>

    override fun onBindViewHolder(holder: BaseViewHolder<ListItem>, position: Int) {
        holder.onBind(items[position])
    }

    override fun onViewRecycled(holder: BaseViewHolder<ListItem>) {
        holder.unbind()
    }

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int) = items[position].viewType()

    fun setNewList(items: List<ListItem>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun add(item: ListItem) {
        items.add(item)
        notifyItemChanged(items.lastIndex)
    }

    fun addItems(items: List<ListItem>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }
}