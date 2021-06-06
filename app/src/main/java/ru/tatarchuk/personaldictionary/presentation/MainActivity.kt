package ru.tatarchuk.personaldictionary.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import ru.tatarchuk.personaldictionary.R
import ru.tatarchuk.personaldictionary.presentation.core.CustomNavigationStack
import ru.tatarchuk.personaldictionary.presentation.core.FragmentContainerType
import ru.tatarchuk.personaldictionary.presentation.core.FragmentType
import ru.tatarchuk.personaldictionary.presentation.core.FragmentType.Companion.DICTIONARY
import ru.tatarchuk.personaldictionary.presentation.core.FragmentType.Companion.EXERCISE
import ru.tatarchuk.personaldictionary.presentation.core.FragmentType.Companion.SETTINGS
import ru.tatarchuk.personaldictionary.presentation.core.NavigationFragment
import ru.tatarchuk.personaldictionary.presentation.dictionary.DictionaryContainerFragment
import ru.tatarchuk.personaldictionary.presentation.test.FirstContainerFragment
import ru.tatarchuk.personaldictionary.presentation.test.SecondFragmentContainer

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager
    private lateinit var navigationView: BottomNavigationView
    private lateinit var stack: CustomNavigationStack<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpNavigationStack(savedInstanceState)
        setUpBottomNavigation()
        if (supportFragmentManager.findFragmentById(R.id.fragment_container) == null) {
            initFragmentStack()
        }
    }

    override fun onBackPressed() {

    }

    private fun selectItem(fragment: Fragment) {
        navigationView.selectedItemId =
            when (fragment) {
                is FirstContainerFragment -> R.id.action_settings
                is SecondFragmentContainer -> R.id.action_exercise
                else -> R.id.action_dictionary
            }
    }

    private fun setUpBottomNavigation() {
        navigationView = findViewById(R.id.navigation)
        navigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_dictionary -> {

                }
                R.id.action_exercise -> {

                }
                R.id.action_settings -> {

                }
            }
            return@setOnNavigationItemSelectedListener true
        }
    }

    private fun setUpNavigationStack(savedInstanceState: Bundle?) {
        stack = CustomNavigationStack(
            savedInstanceState
                ?.getStringArrayList(NAVIGATION)
                ?: mutableListOf(DICTIONARY)
        )
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putStringArrayList(NAVIGATION, ArrayList(stack.state))
    }

    private companion object {
        const val NAVIGATION = "navigation_extra_key"
    }

    private fun initFragmentStack() {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, DictionaryContainerFragment(), DICTIONARY)
            .add(R.id.fragment_container, FirstContainerFragment(), EXERCISE)
            .add(R.id.fragment_container, SecondFragmentContainer(), SETTINGS)
            .commit()
    }

    private fun showFragment(@FragmentType tag: String) {
//        supportFragmentManager.beginTransaction().run {
//            supportFragmentManager.fragments.forEach {
//                if (it.tag == tag) {
//                    show(it)
//                } else {
//                    hide(it)
//                }
//            }
//            commit()
//        }
    }
}
