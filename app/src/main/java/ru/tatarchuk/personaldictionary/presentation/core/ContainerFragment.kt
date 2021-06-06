package ru.tatarchuk.personaldictionary.presentation.core

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.tatarchuk.personaldictionary.R
import ru.tatarchuk.personaldictionary.utils.TAG

/**
 * @author tatarchukilya@gmail.com
 */
abstract class ContainerFragment : NavigationFragment() {

    protected abstract fun createMainFragment(): NavigationFragment

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_container, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (childFragmentManager.findFragmentById(R.id.child_fragment_container) == null) {
            childFragmentManager.beginTransaction()
                .add(R.id.child_fragment_container, createMainFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    protected fun addFragment(fragment: NavigationFragment) {
        childFragmentManager.beginTransaction()
            .add(R.id.child_fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onBackPressed(): Boolean {
        if (childFragmentManager.backStackEntryCount > 1) {
            childFragmentManager.popBackStack()
            return true
        }
        return false
    }

    companion object {

        private const val TAG_EXTRA = "tag_arg_key"
    }
}