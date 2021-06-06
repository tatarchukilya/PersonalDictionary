package ru.tatarchuk.personaldictionary.presentation.dictionary.chuld.root

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.transition.Fade
import androidx.transition.Fade.IN
import androidx.transition.Fade.OUT
import com.google.android.material.floatingactionbutton.FloatingActionButton
import ru.tatarchuk.personaldictionary.R
import ru.tatarchuk.personaldictionary.presentation.core.DIFragment
import ru.tatarchuk.personaldictionary.presentation.dictionary.DictionaryRouter
import ru.tatarchuk.personaldictionary.presentation.dictionary.chuld.search.SearchFragment
import ru.tatarchuk.personaldictionary.presentation.recycler.RecyclerAdapter
import ru.tatarchuk.personaldictionary.presentation.recycler.createDictionaryViewHolders


/**
 * @author tatarchukilya@gmail.com
 */
class DictionaryFragment : DIFragment() {


    private lateinit var viewModel: DictionaryViewModel

    private var router: DictionaryRouter? = null

    private val adapter = RecyclerAdapter { parent: ViewGroup, viewType: Int ->
        createDictionaryViewHolders(
            parent,
            viewType
        )
    }

    override fun layoutResId() = R.layout.fragment_dictionary

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        router = parentFragment as DictionaryRouter
        viewModel =
            ViewModelProvider(
                requireActivity(),
                viewModelApi.getDictionaryViewModelFactory()
            ).get(DictionaryViewModel::class.java)
        exitTransition = Fade(OUT).apply {
            duration = 300
        }
        enterTransition = Fade(IN).apply {
            duration = 300
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<FloatingActionButton>(R.id.fab_search).setOnClickListener {
            val clickCoords = IntArray(2)
            it.getLocationOnScreen(clickCoords)
            clickCoords[0] += it.width / 2
            clickCoords[1] += it.height / 2
            parentFragmentManager.beginTransaction()
                .add(
                    R.id.child_fragment_container,
                    SearchFragment.newInstance(clickCoords[0], clickCoords[1])
                )
                .addToBackStack(null)
                .commit()
        }
        setUpObservers()
    }

    override fun onDestroy() {
        super.onDestroy()
        router = null
    }

    private fun setUpObservers() {
        viewModel.items.observe(viewLifecycleOwner, { adapter.items = it.toMutableList() })
    }
}