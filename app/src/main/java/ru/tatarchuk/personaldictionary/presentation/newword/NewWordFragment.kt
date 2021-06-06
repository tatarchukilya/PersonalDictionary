package ru.tatarchuk.personaldictionary.presentation.newword

import android.view.ViewGroup
import ru.tatarchuk.personaldictionary.R
import ru.tatarchuk.personaldictionary.presentation.core.DIFragment
import ru.tatarchuk.personaldictionary.presentation.newword.recycler.newWordFactoryMethod
import ru.tatarchuk.personaldictionary.presentation.recycler.RecyclerAdapter

/**
 * @author tatarchukilya@gmail.com
 */
class NewWordFragment : DIFragment() {

    private lateinit var viewModel: NewWordViewModel
    private val adapter = RecyclerAdapter { parent: ViewGroup, viewType: Int ->
        newWordFactoryMethod(parent, viewType)
    }

    private var input: String = ""

    override fun layoutResId() = R.layout.fragment_search

    //    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setHasOptionsMenu(true)
//        viewModel =
//            ViewModelProvider(requireActivity(), viewModelApi.getAddWordViewModelFactory())
//                .get(NewWordViewModel::class.java)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        view.findViewById<EditText>(R.id.search_view)
//            .addTextChangedListener { input = it.toString() }
//        view.findViewById<ImageView>(R.id.search_action_image).setOnClickListener {
//            if (input.isNotBlank())
//                viewModel.search(input)
//        }
//        view.findViewById<FloatingActionButton>(R.id.fab_add_word).setOnClickListener {
//            viewModel.dictionaryTest()
//        }
//        view.findViewById<RecyclerView>(R.id.recyclerView).adapter = this.adapter
//        setUpObservers()
//    }
//
//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        inflater.inflate(R.menu.menu_new_word, menu)
//    }
//
//
//    private fun setUpObservers() {
//        viewModel.items().observe(viewLifecycleOwner, { adapter.items = it.toMutableList() })
//    }
//
    companion object {

        @JvmStatic
        fun newInstance() = NewWordFragment()
    }
}