package ru.tatarchuk.personaldictionary.presentation.core

import androidx.annotation.StringDef
import ru.tatarchuk.personaldictionary.presentation.core.FragmentType.Companion.DICTIONARY
import ru.tatarchuk.personaldictionary.presentation.core.FragmentType.Companion.EXERCISE
import ru.tatarchuk.personaldictionary.presentation.core.FragmentType.Companion.SETTINGS

/**
 * @author tatarchukilya@gmail.com
 */
@StringDef(DICTIONARY, EXERCISE, SETTINGS)
annotation class FragmentType {
    companion object {
        const val DICTIONARY = "dictionary"
        const val EXERCISE = "exercise"
        const val SETTINGS = "settings"
    }
}

