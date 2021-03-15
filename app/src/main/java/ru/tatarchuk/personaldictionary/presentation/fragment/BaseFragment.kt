package ru.tatarchuk.personaldictionary.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import ru.tatarchuk.personaldictionary.DictionaryApp

/**
 * @author tatarchukilya@gmail.com
 */
abstract class BaseFragment : Fragment() {

    @LayoutRes
    abstract fun layoutResId(): Int

    protected fun appComponent() = (requireActivity().application as DictionaryApp).appComponent

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = inflater.inflate(layoutResId(), container, false)
}