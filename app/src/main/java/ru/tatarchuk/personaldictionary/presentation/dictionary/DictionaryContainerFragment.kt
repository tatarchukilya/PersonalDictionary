package ru.tatarchuk.personaldictionary.presentation.dictionary

import ru.tatarchuk.personaldictionary.R
import ru.tatarchuk.personaldictionary.presentation.core.ContainerFragment
import ru.tatarchuk.personaldictionary.presentation.dictionary.chuld.root.DictionaryFragment
import ru.tatarchuk.personaldictionary.presentation.dictionary.chuld.search.SearchFragment

/**
 * @author tatarchukilya@gmail.com
 */
class DictionaryContainerFragment : ContainerFragment(), DictionaryRouter {

    override fun createMainFragment() = DictionaryFragment()

    override fun showSearch(posX: Int, posY: Int) {
        childFragmentManager.beginTransaction()
            .add(R.id.child_fragment_container, SearchFragment())
            .setReorderingAllowed(true)
            .addToBackStack(null)
            .commit()
    }
}