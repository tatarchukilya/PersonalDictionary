package ru.tatarchuk.personaldictionary.presentation.recycler

import android.content.Context
import android.util.TypedValue.COMPLEX_UNIT_DIP
import android.util.TypedValue.applyDimension
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.LinearLayout

/**
 * @author tatarchukilya@gmail.com
 */

fun LinearLayout.addDivider() {
    addView(View(context).apply {
        layoutParams = ViewGroup.LayoutParams(MATCH_PARENT, dpToPx(1f, context))
    })
}

fun dpToPx(dp: Float, context: Context) =
    applyDimension(COMPLEX_UNIT_DIP, dp, context.resources.displayMetrics).toInt()