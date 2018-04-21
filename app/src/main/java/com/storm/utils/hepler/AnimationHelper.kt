package com.storm.utils.hepler

import android.content.Context
import android.view.View
import android.view.animation.AnimationUtils
import com.storm.utils.R

/**
 *  THOẠI ĐẠI CA
 *  20/04/2018
 */

/**
 * class handle animation
 */
class AnimationHelper {
    companion object {
        private const val tag: String = "[AnimationHelper] "

        /**
         * animation zoom out image
         */
        fun animImageZoomOut(context: Context, view: View) {
            val animation = AnimationUtils.loadAnimation(context, R.anim.anim_zoom_out_small)
            view.startAnimation(animation)

            MyHandler().postDelayed(object : MyRunnable(context) {
                override fun run() {
                    view.clearAnimation()
                }
            }, 200)
        }
    }
}