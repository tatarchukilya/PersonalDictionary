package ru.tatarchuk.personaldictionary.presentation.viewmodel

import androidx.core.util.Consumer
import androidx.core.util.Supplier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory

/**
 * @author tatarchukilya@gmail.com
 */
class ViewModelProviderFactory<VM>(
    private val supplier: Supplier<VM>,
    private val hookConsumer: Consumer<VM>? = null
) : NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val viewModel = supplier.get()
        hookConsumer?.accept(viewModel)
        @Suppress("UNCHECKED_CAST")
        return viewModel as T
    }
}