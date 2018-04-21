package com.storm.utils.hepler

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.provider.Settings
import android.support.design.widget.Snackbar
import android.view.View
import com.storm.utils.R

/**
 * @auth THOẠI ĐẠI CA
 * @date 20/04/2018
 **/

/**
 * check network connection
 */
class NetworkHelper {
    companion object {
        private const val tag: String = "[NetworkHelper] "

        /**
         * check internet connected or not, if lost show snack bar alert at view your set
         */
        fun isConnected(context: Context, view: View, indefinite: Boolean): Boolean {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = cm.activeNetworkInfo

            val snackBar: Snackbar? = if (indefinite)
                initSnackBar(context, view, context.resources.getString(R.string.internet_error), Snackbar.LENGTH_INDEFINITE)
            else
                initSnackBar(context, view, context.resources.getString(R.string.internet_error), Snackbar.LENGTH_LONG)

            return if (networkInfo != null && networkInfo.isConnected) {
                snackBar!!.dismiss()
                true
            } else {
                snackBar!!.show()
                false
            }
        }

        /**
         * init snack bar
         */
        private fun initSnackBar(context: Context, view: View, message: String, duration: Int): Snackbar {
            val snackBar = Snackbar.make(view, message, duration)
            snackBar.setActionTextColor(context.resources.getColor(R.color.green))
            // set action mở cài đặt
            snackBar.setAction(context.resources.getString(R.string.action_setting)) {
                context.startActivity(Intent(Settings.ACTION_SETTINGS))
            }

            return snackBar
        }
    }
}