package com.storm.utils.hepler

import android.annotation.SuppressLint
import android.content.Context
import com.storm.utils.R
import com.storm.utils.SUtils
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * @auth THOẠI ĐẠI CA
 * @date 20/04/2018
 **/

/**
 * class handle time data
 */
class TimeHelper {
    companion object {
        private const val tag: String = "[TimeHelper] "

        /**
         * get current date
         * dd-MM-yyyy
         */
        @SuppressLint("SimpleDateFormat")
        fun getCurrentDate(): String {
            val calendar = Calendar.getInstance()
            val defaultFormat = SimpleDateFormat("dd-MM-yyyy")
            return defaultFormat.format(calendar.time)
        }

        /**
         * get current date time
         * dd-MM-yyyy HH:mm:ss
         */
        @SuppressLint("SimpleDateFormat")
        fun getCurrentDateTime(): String {
            val calendar = Calendar.getInstance()
            val defaultFormat = SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
            return defaultFormat.format(calendar.time)
        }

        /**
         * get current time stamp
         * dd-MM-yyyy HH:mm:ss
         */
        @SuppressLint("SimpleDateFormat")
        fun getCurrentTimestamp(): String {
            val calendar = Calendar.getInstance()
            val defaultFormat = SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
            val currentDateTime = defaultFormat.format(calendar.time)


            var timestamp: Long = 0
            val format = SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
            try {
                val date = format.parse(currentDateTime)
                timestamp = date.time / 1000
            } catch (e: ParseException) {
                SUtils.showLog("$tag [getCurrentTimestamp] ParseException: " + e.message)
            }

            return timestamp.toString()
        }

        /**
         * convert date to timestamp
         * dd-MM-yyyy
         */
        @SuppressLint("SimpleDateFormat")
        fun convertDateToTimestamp(dateTime: String): Long {
            var timestamp: Long = 0
            val format = SimpleDateFormat("dd-MM-yyyy")
            try {
                val date = format.parse(dateTime)
                timestamp = date.time / 1000
            } catch (e: ParseException) {
                SUtils.showLog("$tag [convertDateToTimestamp] ParseException: " + e.message)
            }

            return timestamp
        }

        /**
         * convert date time to time stamp
         * dd-MM-yyyy HH:mm:ss
         */
        @SuppressLint("SimpleDateFormat")
        fun convertDateTimeTimestamp(dateTime: String): Long {
            var timestamp: Long = 0
            val format = SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
            try {
                val date = format.parse(dateTime)
                timestamp = date.time / 1000
            } catch (e: ParseException) {
                SUtils.showLog("$tag [convertDateTimeTimestamp] ParseException: " + e.message)
            }

            return timestamp
        }

        /**
         * convert time stamp to date
         * dd-MM-yyyy
         */
        @SuppressLint("SimpleDateFormat")
        fun convertTimestampToDate(timestamp: Long): String {
            val formatter = SimpleDateFormat("dd-MM-yyyy")
            return formatter.format(timestamp)
        }

        /**
         * convert time stamp to date time
         * dd-MM-yyyy HH:mm:ss
         */
        @SuppressLint("SimpleDateFormat")
        fun convertTimestampToDateTime(timestamp: Long): String {
            val formatter = SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
            return formatter.format(timestamp)
        }

        /**
         * convert date time to string
         * dd-MM-yyyy HH:mm:ss
         */
        @SuppressLint("SimpleDateFormat")
        fun convertDateTimeToString(context: Context, dateTime: String): String? {
            var timeString: String? = null
            try {
                val defaultFormat = SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
                val past = defaultFormat.parse(dateTime)
                val now = Date()
                val milliseconds = TimeUnit.SECONDS.toSeconds(now.time - past.time).toString()
                val second = java.lang.Long.parseLong(milliseconds) / 1000

                val oneMin: Long = 60
                val oneHour: Long = oneMin * 60
                val oneDate: Long = oneHour * 24

                val day = dateTime.substring(0, 2)
                val month = dateTime.substring(3, 5)
                val year = dateTime.substring(6, 10)

                val hour = dateTime.substring(11, 13)
                val minute = dateTime.substring(14, 16)
                val currentYear = Calendar.getInstance().get(Calendar.YEAR).toString()

                val inputDateTimeStamp = SUtils.convertDateToTimestamp(dateTime.substring(0, 10))
                val currentDateTimeStamp = SUtils.convertDateToTimestamp(SUtils.getCurrentDate())
                val toDay = inputDateTimeStamp - currentDateTimeStamp

                if (toDay.compareTo(0) == 0 && second >= 0) { //today and now.time >= past.time
                    when {
                        second < oneMin -> timeString = context.resources.getString(com.storm.utils.R.string.str_time_just_now)
                        second < 2 * oneMin -> timeString = context.resources.getString(com.storm.utils.R.string.str_time_1_minute)
                        second < 50 * oneMin -> timeString = (second / oneMin).toString().plus(context.resources.getString(com.storm.utils.R.string.str_time_minute))
                        second < 90 * oneMin -> timeString = context.resources.getString(com.storm.utils.R.string.str_time_1_hour)
                        second < 24 * oneHour -> timeString = (second / oneHour).toString().plus(context.resources.getString(com.storm.utils.R.string.str_time_hour))
                    }
                } else if (toDay.compareTo(0) == -1 && second.compareTo(oneDate) == -1) { //past
                    timeString = context.resources.getString(com.storm.utils.R.string.str_time_yesterday)
                            .plus(context.resources.getString(com.storm.utils.R.string.str_moment)).plus(hour).plus(":").plus(minute)
                } else if (toDay.compareTo(0) == 1 && second.compareTo(oneDate) == 1) { //future
                    timeString = context.resources.getString(com.storm.utils.R.string.str_time_tomorrow)
                            .plus(context.resources.getString(com.storm.utils.R.string.str_moment)).plus(hour).plus(":").plus(minute)
                } else {
                    timeString = if (year == currentYear) //in current year -> hide show year
                        day.plus(context.resources.getString(com.storm.utils.R.string.str_month))
                                .plus(month).plus(context.resources.getString(com.storm.utils.R.string.str_moment))
                                .plus(hour).plus(":").plus(minute)
                    else //past or future year -> show year
                        day.plus(context.resources.getString(com.storm.utils.R.string.str_month))
                                .plus(month).plus(context.resources.getString(com.storm.utils.R.string.str_year))
                                .plus(year).plus(context.resources.getString(com.storm.utils.R.string.str_moment))
                                .plus(hour).plus(":").plus(minute)
                }


            } catch (e: Exception) {
                SUtils.showLog("[convertTimeToString] Exception: " + e.message)
            }

            return timeString
        }

        /**
         * format day and month to Vietnamese/English language
         * vi = Vietnamese
         * en = English
         */
        fun convertMonthDayLocaleString(context: Context, locale: String, month: Int, day: Int): String? {
            var monthDayFormat: String? = null

            if (locale == "vi") { //format for Vietnamese
                when (month) {
                    1 -> monthDayFormat = day.toString() + " " + context.resources.getString(R.string.str_month_1)
                    2 -> monthDayFormat = day.toString() + " " + context.resources.getString(R.string.str_month_2)
                    3 -> monthDayFormat = day.toString() + " " + context.resources.getString(R.string.str_month_3)
                    4 -> monthDayFormat = day.toString() + " " + context.resources.getString(R.string.str_month_4)
                    5 -> monthDayFormat = day.toString() + " " + context.resources.getString(R.string.str_month_5)
                    6 -> monthDayFormat = day.toString() + " " + context.resources.getString(R.string.str_month_6)
                    7 -> monthDayFormat = day.toString() + " " + context.resources.getString(R.string.str_month_7)
                    8 -> monthDayFormat = day.toString() + " " + context.resources.getString(R.string.str_month_8)
                    9 -> monthDayFormat = day.toString() + " " + context.resources.getString(R.string.str_month_9)
                    10 -> monthDayFormat = day.toString() + " " + context.resources.getString(R.string.str_month_10)
                    11 -> monthDayFormat = day.toString() + " " + context.resources.getString(R.string.str_month_11)
                    12 -> monthDayFormat = day.toString() + " " + context.resources.getString(R.string.str_month_12)
                }
            } else {  //format for English
                when (month) {
                    1 -> monthDayFormat = context.resources.getString(R.string.str_month_1) + " " + day
                    2 -> monthDayFormat = context.resources.getString(R.string.str_month_2) + " " + day
                    3 -> monthDayFormat = context.resources.getString(R.string.str_month_3) + " " + day
                    4 -> monthDayFormat = context.resources.getString(R.string.str_month_4) + " " + day
                    5 -> monthDayFormat = context.resources.getString(R.string.str_month_5) + " " + day
                    6 -> monthDayFormat = context.resources.getString(R.string.str_month_6) + " " + day
                    7 -> monthDayFormat = context.resources.getString(R.string.str_month_7) + " " + day
                    8 -> monthDayFormat = context.resources.getString(R.string.str_month_8) + " " + day
                    9 -> monthDayFormat = context.resources.getString(R.string.str_month_9) + " " + day
                    10 -> monthDayFormat = context.resources.getString(R.string.str_month_10) + " " + day
                    11 -> monthDayFormat = context.resources.getString(R.string.str_month_11) + " " + day
                    12 -> monthDayFormat = context.resources.getString(R.string.str_month_12) + " " + day
                }
            }

            return monthDayFormat
        }
    }
}