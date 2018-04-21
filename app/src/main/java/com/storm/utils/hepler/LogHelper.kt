package com.storm.utils.hepler

/**
 * @auth THOẠI ĐẠI CA
 * @date 20/04/2018
 */

/**
 * class custom logcat
 */
class LogHelper {
    /**
     * set show logcat or hide at first activity
     */
    var isShowLogOrNot: Boolean = false
    private val tag: String = "[LogHelper] "

    /**
     * init show logcat
     */
    init {
        try {
            //add this file to apk for show log when key consoleLogEnabled is false
            val inputSteam = javaClass.classLoader.getResourceAsStream("META-INF/SUtils_debug.txt")
            if (inputSteam != null) {
                isShowLogOrNot = true
                inputSteam.close()
            }
        } catch (e: Exception) {
            show("$tag [init] Exception: $e")
        }

        //TODO true: show log, false: hide log
        isShowLogOrNot = true
    }

    /**
     * action show logcat type: Error
     */
    fun show(message: String) {
        if (isShowLogOrNot)
            android.util.Log.e("[SUtils] ", message)
    }

    /**
     * check logcat init or not
     */
    companion object {
        private var instance: LogHelper? = null

        fun log(): LogHelper {
            if (instance == null)
                instance = LogHelper()
            return instance as LogHelper
        }
    }
}