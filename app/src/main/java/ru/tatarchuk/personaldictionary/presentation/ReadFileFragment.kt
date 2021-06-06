package ru.tatarchuk.personaldictionary.presentation

import android.os.Bundle
import android.view.View
import android.widget.Button
import ru.tatarchuk.personaldictionary.R
import ru.tatarchuk.personaldictionary.presentation.core.DIFragment

/**
 * @author tatarchukilya@gmail.com
 */
class ReadFileFragment : DIFragment() {

    override fun layoutResId() = R.layout.fragment_read_file

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<Button>(R.id.start_button).setOnClickListener {

        }
    }
}