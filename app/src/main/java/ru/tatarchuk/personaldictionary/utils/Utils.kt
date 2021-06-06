package ru.tatarchuk.personaldictionary.utils

import android.view.View
import android.view.View.*
import android.widget.EditText
import androidx.annotation.IntDef
import androidx.annotation.StringDef
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.FragmentTransaction
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.onStart
import ru.tatarchuk.personaldictionary.presentation.core.FragmentType
import ru.tatarchuk.personaldictionary.utils.Lang.Companion.EN
import ru.tatarchuk.personaldictionary.utils.Lang.Companion.RU

/**
 * @author tatarchukilya@gmail.com
 */

@ExperimentalCoroutinesApi
fun EditText.textChange(): Flow<String?> {
    return callbackFlow {
        val textWatcher = addTextChangedListener { offer(it.toString()) }
        awaitClose { removeTextChangedListener(textWatcher) }
    }.onStart {
        
    }
}

const val TAG = "<>"

fun View.hide() {
    visibility = GONE
}

fun View.show() {
    visibility = VISIBLE
}

@Retention(AnnotationRetention.SOURCE)
@StringDef(RU, EN)
annotation class Lang {
    companion object {
        const val RU = "ru"
        const val EN = "en"
    }
}
