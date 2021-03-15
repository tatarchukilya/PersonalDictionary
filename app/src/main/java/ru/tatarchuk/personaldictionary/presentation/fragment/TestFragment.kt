package ru.tatarchuk.personaldictionary.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.LayoutRes
import ru.tatarchuk.personaldictionary.R

/**
 * @author tatarchukilya@gmail.com
 */
class TestFragment : BaseFragment() {

    //compile 'com.googlecode.libphonenumber:libphonenumber:8.2.0'

    var params: LayoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)

    @LayoutRes
    override fun layoutResId() = R.layout.fragment_test

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        view.let {
            val inflater: LayoutInflater = LayoutInflater.from(context)
            for (i in 0..5) {
                val textView: TextView =
                    inflater.inflate(
                        R.layout.textview_secondary,
                        view as ViewGroup,
                        false
                    ) as TextView
                textView.text = "text view $i"
                (it as LinearLayout).addView(textView)
            }
        }
    }
}