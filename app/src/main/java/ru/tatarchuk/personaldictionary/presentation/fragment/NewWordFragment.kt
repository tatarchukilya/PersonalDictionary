package ru.tatarchuk.personaldictionary.presentation.fragment

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import ru.tatarchuk.personaldictionary.R
import ru.tatarchuk.personaldictionary.presentation.viewmodel.NewWordViewModel

/**
 * @author tatarchukilya@gmail.com
 */
class NewWordFragment : BaseFragment() {

    private lateinit var viewModel: NewWordViewModel

    private var input: String = ""

    override fun layoutResId() = R.layout.fragment_new_word

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        viewModel =
            ViewModelProvider(requireActivity(), appComponent().getAddWordViewModelFactory())
                .get(NewWordViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<EditText>(R.id.search_view)
            .addTextChangedListener { input = it.toString() }
        view.findViewById<ImageView>(R.id.search_action_image).setOnClickListener {
            if (input.isNotBlank())
                viewModel.search(input)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_new_word, menu)
    }

    companion object {

        @JvmStatic
        fun newInstance() = NewWordFragment()
    }
}