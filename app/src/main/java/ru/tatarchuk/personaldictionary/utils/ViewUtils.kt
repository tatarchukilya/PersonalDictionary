import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.content.Context
import android.util.DisplayMetrics
import android.util.TypedValue.COMPLEX_UNIT_DIP
import android.util.TypedValue.applyDimension
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewAnimationUtils
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.LinearLayout
import androidx.interpolator.view.animation.FastOutSlowInInterpolator


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

fun View.setVisibility(isVisible: Boolean) {
    visibility = if (isVisible) VISIBLE else GONE
}

fun View.performRevealAnimation(
    screenCenterX: Int,
    screenCenterY: Int,
    colorStart: Int,
    colorEnd: Int
) {
    val animatorSet = AnimatorSet()
    animatorSet
        .play(createRevealAnimation(screenCenterX, screenCenterY))
        .with(createColorAnimation(colorStart, colorEnd))
    animatorSet.start()
}

fun View.createRevealAnimation(screenCenterX: Int, screenCenterY: Int): Animator {
    val animatingViewCoords = IntArray(2)
    getLocationOnScreen(animatingViewCoords)
    val centerX: Int = screenCenterX - animatingViewCoords[0]
    val centerY: Int = screenCenterY - animatingViewCoords[1]
    val metrics = DisplayMetrics()
    context.display?.getRealMetrics(metrics)
    val maxRadius =
        if (metrics.heightPixels > metrics.widthPixels) metrics.heightPixels else metrics.widthPixels
    return ViewAnimationUtils.createCircularReveal(this, centerX, centerY, 0f, maxRadius.toFloat())
        .apply {
            duration = 500
            interpolator = FastOutSlowInInterpolator()
        }
}

fun View.createCollapseAnimation(screenCenterX: Int, screenCenterY: Int): Animator {
    val animatingViewCoords = IntArray(2)
    getLocationOnScreen(animatingViewCoords)
    val centerX: Int = screenCenterX - animatingViewCoords[0]
    val centerY: Int = screenCenterY - animatingViewCoords[1]
    val metrics = DisplayMetrics()
    context.display?.getRealMetrics(metrics)
    val maxRadius =
        if (metrics.heightPixels > metrics.widthPixels) metrics.heightPixels else metrics.widthPixels
    return ViewAnimationUtils.createCircularReveal(this, centerX, centerY, maxRadius.toFloat(), 0f)
        .apply {
            duration = 500
            interpolator = FastOutSlowInInterpolator()
        }
}

fun View.createColorAnimation(colorStart: Int, colorEnd: Int): Animator {
    return ObjectAnimator
        .ofInt(
            this, "backgroundColor", colorStart, colorEnd
        )
        .apply {
            duration = 500
            setEvaluator(ArgbEvaluator())
        }
}