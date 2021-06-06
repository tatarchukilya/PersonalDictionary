package ru.tatarchuk.personaldictionary.presentation.test

import ru.tatarchuk.personaldictionary.R
import ru.tatarchuk.personaldictionary.presentation.core.ContainerFragment

/**
 * @author tatarchukilya@gmail.com
 */
class FirstContainerFragment : ContainerFragment(), ContainerRouter {

    override fun createMainFragment() = FirstFragment()

    override fun addSecond() {
        childFragmentManager.beginTransaction()
            .add(R.id.child_fragment_container, SecondFragment())
            .addToBackStack(null)
            .commit()
    }

    override fun addThird() {
        childFragmentManager.beginTransaction()
            .add(R.id.child_fragment_container, ThirdFragment())
            .addToBackStack(null)
            .commit()
    }
}