package com.storm.utils

import android.app.Activity
import android.content.Context
import android.database.Cursor
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import android.view.View
import android.webkit.WebView
import android.widget.ImageView
import android.widget.TextView
import com.storm.utils.hepler.*
import org.json.JSONObject
import java.io.File
import java.math.BigDecimal
import java.text.NumberFormat

/**
 *  @author thoaileminh
 *  @date 20/04/2018
 */

class SUtils {
    companion object {
        /**
         *  AnimationHelper-------------------------------------------------------------------------
         */

        /**
         * animation zoom out image
         */
        fun animImageZoomOut(context: Context, imageView: ImageView) {
            AnimationHelper.animImageZoomOut(context, imageView)
        }


        /**
         *  ApiHelper-------------------------------------------------------------------------------
         */

        /**
         * check key of value String is exits into json or not, if not return null
         */
        fun getString(json: JSONObject, key: String): String {
            return ApiHelper.getString(json, key)
        }

        /**
         * check key of value Integer is exits into json or not, if not return 0
         */
        fun getInt(json: JSONObject, key: String): Int {
            return ApiHelper.getInt(json, key)
        }

        /**
         * check key of value Long is exits into json or not, if not return 0
         */
        fun getLong(json: JSONObject, key: String): Long {
            return ApiHelper.getLong(json, key)
        }

        /**
         * check key of value Double is exits into json or not, if not return 0.0
         */
        fun getDouble(json: JSONObject, key: String): Double {
            return ApiHelper.getDouble(json, key)
        }

        /**
         * check key of value BigDecimal is exits into json or not, if not return 0
         */
        fun getBigDecimal(json: JSONObject, key: String): BigDecimal {
            return ApiHelper.getBigDecimal(json, key)
        }

        /**
         *check key of value Boolean is exits into json or not, if not return false
         */
        fun getBoolean(json: JSONObject, key: String): Boolean {
            return ApiHelper.getBoolean(json, key)
        }

        /**
         *check special key of value String is exits into json or not, if not return special value
         */
        fun getSpecialString(json: JSONObject, key: String, specialValue: String): String {
            return ApiHelper.getSpecialString(json, key, specialValue)
        }

        /**
         *check special key of value Integer is exits into json or not, if not return special value
         */
        fun getSpecialInt(json: JSONObject, key: String, specialValue: Int): Int {
            return ApiHelper.getSpecialInt(json, key, specialValue)
        }

        /**
         *check special key of value Long is exits into json or not, if not return special value
         */
        fun getSpecialLong(json: JSONObject, key: String, specialValue: Long): Long {
            return ApiHelper.getSpecialLong(json, key, specialValue)
        }

        /**
         *check special key of value Double is exits into json or not, if not return special value
         */
        fun getSpecialDouble(json: JSONObject, key: String, specialValue: Double): Double {
            return ApiHelper.getSpecialDouble(json, key, specialValue)
        }

        /**
         *check special key of value BigDecimal is exits into json or not, if not return special value
         */
        fun getSpecialBigDecimal(json: JSONObject, key: String, specialValue: BigDecimal): BigDecimal {
            return ApiHelper.getSpecialBigDecimal(json, key, specialValue)
        }

        /**
         *check special key of value Boolean is exits into json or not, iif not return special value
         */
        fun getSpecialBoolean(json: JSONObject, key: String, specialValue: Boolean): Boolean {
            return ApiHelper.getSpecialBoolean(json, key, specialValue)
        }


        /**
         *  FacebookHelper--------------------------------------------------------------------------
         */

        /**
         *  get keyHash for longIn facebook
         */
        fun getKeyHashesLoginFacebook(context: Context, packageName: String): String {
            return FacebookHelper.getKeyHashesLoginFacebook(context, packageName)
        }


        /**
         *  HTMLHelper------------------------------------------------------------------------------
         */

        /**
         * load HTML in TextView
         */
        fun loadHTMLinTextView(textView: TextView, data: String) {
            HTMLHelper.loadHTMLinTextView(textView, data)
        }

        /**
         * load HTML and optimize WebView
         */
        fun loadHTMLinWebView(webView: WebView, data: String) {
            HTMLHelper.loadHTMLinWebView(webView, data)
        }


        /**
         *  ImageHelper-----------------------------------------------------------------------------
         */

        /**
         * get bitmap from image URL
         */
        fun getBitmapFromURL(imageUrl: String?): Bitmap? {
            return ImageHelper.getBitmapFromURL(imageUrl)
        }

        /**
         * get bitmap from image in drawable folder
         */
        fun getBitmapFromDrawable(drawable: Drawable): Bitmap {
            return ImageHelper.getBitmapFromDrawable(drawable)
        }

        /**
         * get real bitmap with orientation
         */
        fun getRealBitmapOrientation(bitmap: Bitmap, filePath: String): Bitmap? {
            return ImageHelper.getRealBitmapOrientation(bitmap, filePath)
        }

        /**
         * get bitmap rotate image with degrees
         */
        private fun getBitmapRotateImage(_bitmap: Bitmap?, degrees: Int): Bitmap? {
            return ImageHelper.getBitmapRotateImage(_bitmap, degrees)
        }

        /**
         * get URI from image file local
         */
        fun getUriFromImageFile(context: Context, imageFile: File): Uri? {
            return ImageHelper.getUriFromImageFile(context, imageFile)
        }

        /**
         * get path from image URI local
         */
        fun getPathFromImageUri(context: Context, contentUri: Uri): String {
            return ImageHelper.getPathFromImageUri(context, contentUri)
        }

        /**
         * get path from cursor
         */
        fun getPathFromCursor(context: Context, cursor: Cursor): String? {
            return ImageHelper.getPathFromCursor(context, cursor)
        }


        /**
         *  LogHelper-------------------------------------------------------------------------------
         */

        /**
         * set show logcat or hide at first activity
         */
        fun setShowLogOrNot(isShowLog: Boolean) {
            LogHelper().isShowLogOrNot = isShowLog
        }

        /**
         * action show logcat type: Error
         */
        fun showLog(message: String) {
            LogHelper.log().show(message)
        }


        /**
         *  NetworkHelper---------------------------------------------------------------------------
         */

        /**
         * check internet connected or not, if lost show snack bar alert at view your set
         */
        fun isConnected(context: Context, view: View, indefinite: Boolean): Boolean {
            return NetworkHelper.isConnected(context, view, indefinite)
        }


        /**
         *  OSHelper--------------------------------------------------------------------------------
         */

        /**
         * hide keyboard
         */
        fun hideSoftKeyboard(activity: Activity) {
            OSHelper.hideSoftKeyboard(activity)
        }

        /**
         * show keyboard
         */
        fun showKeyboard(activity: Activity) {
            OSHelper.showKeyboard(activity)
        }

        /**
         * show snack bar short
         */
        fun showSnackBar(view: View, str: Int) {
            OSHelper.showSnackBar(view, str)
        }

        /**
         * show snack bar long
         */
        fun showSnackBarLong(view: View, str: Int) {
            OSHelper.showSnackBarLong(view, str)
        }

        /**
         * show snack bar indefinite
         */
        fun showSnackBarIndefinite(view: View, str: Int) {
            OSHelper.showSnackBarIndefinite(view, str)
        }

        /**
         * get current app version
         */
        fun getAppVersion(context: Context): String {
            return OSHelper.getAppVersion(context)
        }


        /**
         *  PermissionHelper------------------------------------------------------------------------
         */

        /**
         * check permission is granted or not
         */
        fun isGrantedPermission(context: Context, permission: String): Boolean {
            return PermissionHelper.isGrantedPermission(context, permission)
        }


        /**
         *  StringHelper----------------------------------------------------------------------------
         */

        /**
         * convert string Vietnamese to English
         */
        fun convertStrVietnameseToEnglish(strVN: String): String {
            return StringHelper.convertStrVietnameseToEnglish(strVN)
        }

        /**
         * count line of content string
         */
        fun countLines(str: String): Int {
            return StringHelper.countLines(str)
        }


        /**
         *  TimeHelper------------------------------------------------------------------------------
         */

        /**
         * get current date
         * dd-MM-yyyy
         */
        fun getCurrentDate(): String {
            return TimeHelper.getCurrentDate()
        }

        /**
         * get current date time
         * dd-MM-yyyy HH:mm:ss
         */
        fun getCurrentDateTime(): String {
            return TimeHelper.getCurrentDateTime()
        }

        /**
         * get current time stamp
         * dd-MM-yyyy HH:mm:ss
         */
        fun getCurrentTimestamp(): String {
            return TimeHelper.getCurrentTimestamp()
        }

        /**
         * convert date to timestamp
         * dd-MM-yyyy
         */
        fun convertDateToTimestamp(dateTime: String): Long {
            return TimeHelper.convertDateToTimestamp(dateTime)
        }

        /**
         * convert date time to time stamp
         * dd-MM-yyyy HH:mm:ss
         */
        fun convertDateTimeToTimestamp(dateTime: String): Long {
            return TimeHelper.convertDateTimeTimestamp(dateTime)
        }

        /**
         * convert time stamp to date
         * dd-MM-yyyy
         */
        fun convertTimestampToDate(timestamp: Long): String {
            return TimeHelper.convertTimestampToDate(timestamp)
        }

        /**
         * convert time stamp to date time
         * dd-MM-yyyy HH:mm:ss
         */
        fun convertTimestampToDateTime(timestamp: Long): String {
            return TimeHelper.convertTimestampToDateTime(timestamp)
        }

        /**
         * convert date time to string
         * @param pattern is: dd-MM-yyyy or dd-MM-yyyy HH:mm:ss or HH:mm:ss
         */
        fun convertDateTimeToString(context: Context, dateTime: String): String? {
            return TimeHelper.convertDateTimeToString(context, dateTime)
        }

        /**
         * format day and month to Vietnamese/English language
         * vi = Vietnamese
         * en = English
         */
        fun convertMonthDayLocaleString(context: Context, locale: String, month: Int, day: Int): String? {
            return TimeHelper.convertMonthDayLocaleString(context, locale, month, day)
        }


        /**
         *  Helper-----------------------------------------------------------------------------
         */

        /**
         *  format BigDecimal to currency
         */
        fun formatBigDecimalToCurrency(bigDecimal: BigDecimal): String {
            return NumberFormat.getNumberInstance(java.util.Locale.US).format(bigDecimal)
        }

        /**
         *  format Int to currency
         */
        fun formatIntToCurrency(int: Int): String {
            return NumberFormat.getNumberInstance(java.util.Locale.US).format(int)
        }

        /**
         *  format Long to currency
         */
        fun formatLongToCurrency(long: Long): String {
            return NumberFormat.getNumberInstance(java.util.Locale.US).format(long)
        }
    }
}