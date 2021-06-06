package ru.tatarchuk.personaldictionary.presentation.fragment

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import ru.tatarchuk.personaldictionary.R
import ru.tatarchuk.personaldictionary.presentation.core.DIFragment

/**
 * @author tatarchukilya@gmail.com
 */
class SingleWordFragment : DIFragment() {

    override fun layoutResId() = R.layout.fragment_single_word

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpToolbar(view)
    }

    private fun setUpToolbar(view: View) {
        (activity as AppCompatActivity).let {
            it.setSupportActionBar(view.findViewById(R.id.toolbar))
            it.supportActionBar?.setDisplayHomeAsUpEnabled(true)
            arguments?.getString(WORD_EXTRA)?.let { title ->
                it.supportActionBar?.title = title
            }
        }
    }

    companion object {

        private const val WORD_EXTRA = "word_extra"

        @JvmStatic
        fun newInstance(word: String) = SingleWordFragment().apply {
            arguments = Bundle().apply {
                putString(WORD_EXTRA, word)
            }
        }
    }
}