package ru.tatarchuk.personaldictionary.presentation.core

import androidx.annotation.IntDef
import ru.tatarchuk.personaldictionary.presentation.core.FragmentContainerType.Companion.DICTIONARY
import ru.tatarchuk.personaldictionary.presentation.core.FragmentContainerType.Companion.EMPTY
import ru.tatarchuk.personaldictionary.presentation.core.FragmentContainerType.Companion.EXERCISE

/**
 * @author tatarchukilya@gmail.com
 */
@IntDef(EMPTY, DICTIONARY, EXERCISE)
annotation class FragmentContainerType {
    companion object {
        const val EMPTY = -1
        const val DICTIONARY = 0
        const val EXERCISE = 1
    }
}
