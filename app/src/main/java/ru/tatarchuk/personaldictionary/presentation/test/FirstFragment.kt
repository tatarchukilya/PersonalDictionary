package ru.tatarchuk.personaldictionary.presentation.test

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import ru.tatarchuk.personaldictionary.R
import ru.tatarchuk.personaldictionary.presentation.core.DIFragment

/**
 * @author tatarchukilya@gmail.com
 */
class FirstFragment : DIFragment() {

    override fun layoutResId() = R.layout.fragment_test

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<TextView>(R.id.text_view).text = javaClass.simpleName
        view.findViewById<Button>(R.id.show_next).setOnClickListener {
            (parentFragment as ContainerRouter).addSecond()
        }
    }
}