package ru.tatarchuk.personaldictionary.presentation.dictionary.chuld.search

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.MenuItem
import android.view.View
import android.view.View.OnLayoutChangeListener
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.app.SharedElementCallback
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.*
import performRevealAnimation
import ru.tatarchuk.personaldictionary.R
import ru.tatarchuk.personaldictionary.presentation.core.DIFragment
import ru.tatarchuk.personaldictionary.presentation.core.NavigationFragment
import ru.tatarchuk.personaldictionary.presentation.recycler.RecyclerAdapter
import ru.tatarchuk.personaldictionary.presentation.dictionary.chuld.search.recycler.createSearchViewHolders
import setVisibility


/**
 * @author tatarchukilya@gmail.com
 */
class SearchFragment : DIFragment() {

    private val posX: Int by lazy {
        arguments?.getInt("x") ?: 0
    }
    private val posY: Int by lazy {
        arguments?.getInt("y") ?: 0
    }

    private lateinit var viewModel: SearchViewModel
    private lateinit var progressBar: ProgressBar

    private lateinit var toolbar: Toolbar
    private lateinit var editText: EditText
    private var recyclerAdapter: RecyclerAdapter =
        RecyclerAdapter { parent: ViewGroup, viewType: Int ->
            createSearchViewHolders(parent, viewType)
        }

    override fun layoutResId() = R.layout.fragment_search

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
//        sharedElementEnterTransition = AutoTransition().apply {
//            duration = 3000
//            addListener(object : TransitionListenerAdapter() {
//                override fun onTransitionEnd(transition: Transition) {
//                    super.onTransitionEnd(transition)
//
//                }
//            })
//        }

//        sharedElementEnterTransition = AutoTransition().apply {
//            duration = 300
//        }
//
//        returnTransition = Fade(Fade.OUT).apply {
//            duration = 300
//        }
//        enterTransition = Fade(Fade.IN).apply {
//            duration = 300
//        }
        //TransitionInflater.from(context).inflateTransition(R.transition.transition_search)
        viewModel = ViewModelProvider(viewModelStore, viewModelApi.getSearchViewModelFactory())
            .get(SearchViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.addOnLayoutChangeListener(object : OnLayoutChangeListener {
            override fun onLayoutChange(
                v: View?,
                left: Int,
                top: Int,
                right: Int,
                bottom: Int,
                oldLeft: Int,
                oldTop: Int,
                oldRight: Int,
                oldBottom: Int
            ) {
                view.removeOnLayoutChangeListener(this)
                if ((posX != 0 || posY != 0) && savedInstanceState == null) {
                    view.performRevealAnimation(
                        posX, posY, resources.getColor(R.color.colorDivider, null),
                        resources.getColor(android.R.color.background_light, null)
                    )
                }
            }
        })
        setUpToolbar(view)
        //progressBar = view.findViewById(R.id.progress_bar)
        view.findViewById<RecyclerView>(R.id.recycler_view).adapter = recyclerAdapter
        setUpSearchView(view)
        initObservers()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            (parentFragment as NavigationFragment).onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initObservers() {
        viewModel.word().observe(viewLifecycleOwner, { recyclerAdapter.items = it.toMutableList() })
        //viewModel.progress().observe(viewLifecycleOwner, { progressBar.setVisibility(it) })
    }

    private fun setUpToolbar(view: View) {
        toolbar = view.findViewById(R.id.toolbar)
        (activity as AppCompatActivity).let {
            it.setSupportActionBar(toolbar)
            it.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
    }

    private fun setUpSearchView(view: View) {
        editText = view.findViewById(R.id.edit)
        editText.requestFocus()
        val imm: InputMethodManager? =
            getSystemService(requireContext(), InputMethodManager::class.java)
        imm?.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT)
        editText.doAfterTextChanged {
            viewModel.search(it.toString())
        }
    }

    companion object {
        fun newInstance(posX: Int, posY: Int) = SearchFragment().apply {
            arguments = Bundle().apply {
                putInt("x", posX)
                putInt("y", posY)
            }
        }
    }

    class CustomTransition : TransitionSet {
        /**
         * Constructs an AutoTransition object, which is a TransitionSet which
         * first fades out disappearing targets, then moves and resizes existing
         * targets, and finally fades in appearing targets.
         */
        constructor() {
            init()
        }

        constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
            init()
        }

        private fun init() {
            ordering = ORDERING_SEQUENTIAL
            addTransition(Fade(Fade.OUT))
                .addTransition(ChangeBounds())
                .addTransition(Fade(Fade.IN)).duration = 3000
        }
    }
}
