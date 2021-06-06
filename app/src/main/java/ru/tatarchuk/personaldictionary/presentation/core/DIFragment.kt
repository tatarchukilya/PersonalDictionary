package ru.tatarchuk.personaldictionary.presentation.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import ru.tatarchuk.personaldictionary.DictionaryApp
import ru.tatarchuk.personaldictionary.di.api.ViewModelApi

/**
 * @author tatarchukilya@gmail.com
 */
abstract class DIFragment : NavigationFragment() {

    @LayoutRes
    protected abstract fun layoutResId(): Int

    protected val viewModelApi: ViewModelApi by lazy {
        (requireActivity().application as DictionaryApp).appComponent
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = inflater.inflate(layoutResId(), container, false)
}
