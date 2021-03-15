package ru.tatarchuk.personaldictionary.presentation.fragment

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import ru.tatarchuk.personaldictionary.R
import ru.tatarchuk.personaldictionary.presentation.MainRouter
import ru.tatarchuk.personaldictionary.presentation.recycler.RecyclerAdapter
import ru.tatarchuk.personaldictionary.presentation.recycler.createDictionaryViewHolders
import ru.tatarchuk.personaldictionary.presentation.viewmodel.DictionaryViewModel

/**
 * @author tatarchukilya@gmail.com
 */
class DictionaryFragment : BaseFragment() {

    private lateinit var recyclerView: RecyclerView

    private lateinit var viewModel: DictionaryViewModel

    private var router: MainRouter? = null

    private val adapter = RecyclerAdapter { parent: ViewGroup, viewType: Int ->
        createDictionaryViewHolders(
            parent,
            viewType
        )
    }

    override fun layoutResId() = R.layout.fragment_dictionary

    override fun onAttach(context: Context) {
        super.onAttach(context)
        router = context as MainRouter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel =
            ViewModelProvider(
                requireActivity(),
                appComponent().getDictionaryViewModelFactory()
            ).get(DictionaryViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<FloatingActionButton>(R.id.fab_add_word).setOnClickListener {
            router?.newWord()
        }
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.adapter = adapter
        setUpObservers()
    }

    override fun onDetach() {
        super.onDetach()
        router = null
    }

    private fun setUpObservers() {
        viewModel.items.observe(viewLifecycleOwner, {
            adapter.addItems(it)
        })

        viewModel.showDetailsEvent.observe(viewLifecycleOwner, {
            router?.showDetails(it)
        })
    }
}