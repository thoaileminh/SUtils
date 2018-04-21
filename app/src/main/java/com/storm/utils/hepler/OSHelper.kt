package com.storm.utils.hepler

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.support.design.widget.Snackbar
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.storm.utils.SUtils

/**
 * @auth THOẠI ĐẠI CA
 * @date 20/04/2018
 **/

/**
 * class handel event of OS
 */
class OSHelper {
    companion object {
        private const val tag: String = "[OSHelper] "

        /**
         * hide keyboard
         */
        fun hideSoftKeyboard(activity: Activity) {
            val view = activity.currentFocus
            if (view != null) {
                val inputManager = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputManager.hideSoftInputFromWindow(view.windowToken, 0)
            }
        }

        /**
         * show keyboard
         */
        fun showKeyboard(context: Context) {
            (context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
                    .toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY)
        }

        /**
         * show snack bar short
         */
        fun showSnackBar(view: View, str: Int) {
            Snackbar.make(view, str, Snackbar.LENGTH_SHORT).show()
        }

        /**
         * show snack bar long
         */
        fun showSnackBarLong(view: View, str: Int) {
            Snackbar.make(view, str, Snackbar.LENGTH_LONG).show()
        }

        /**
         * show snack bar indefinite
         */
        fun showSnackBarIndefinite(view: View, str: Int) {
            return Snackbar.make(view, str, Snackbar.LENGTH_INDEFINITE).show()
        }

        /**
         * get current app version
         */
        fun getAppVersion(context: Context): String {
            try {
                val packageInfo = context.packageManager.getPackageInfo(context.packageName, 0)
                return packageInfo.versionName.toString()
            } catch (e: PackageManager.NameNotFoundException) {
                SUtils.showLog("$tag [getAppVersion] PackageManager.NameNotFoundException: " + e.message)
            }

            return ""
        }
    }
}