package com.storm.utils.hepler

import org.json.JSONObject
import java.math.BigDecimal

/**
 *  @author thoaileminh
 *  @date 20/04/2018
 */

/**
 * class check value and key of json
 */
class ApiHelper {
    companion object {
        private const val tag: String = "[ApiHelper] "

        /**
         * check key of value String is exits into json or not, if not return null
         */
        fun getString(json: JSONObject, key: String): String {
            if (!json.isNull(key))
                return json.getString(key)
            return ""
        }

        /**
         * check key of value Integer is exits into json or not, if not return 0
         */
        fun getInt(json: JSONObject, key: String): Int {
            if (!json.isNull(key))
                return json.getInt(key)
            return 0
        }

        /**
         * check key of value Long is exits into json or not, if not return 0
         */
        fun getLong(json: JSONObject, key: String): Long {
            if (!json.isNull(key))
                return json.getLong(key)
            return 0
        }

        /**
         * check key of value Double is exits into json or not, if not return 0.0
         */
        fun getDouble(json: JSONObject, key: String): Double {
            if (!json.isNull(key))
                return json.getDouble(key)
            return 0.0
        }

        /**
         * check key of value BigDecimal is exits into json or not, if not return 0
         */
        fun getBigDecimal(json: JSONObject, key: String): BigDecimal {
            if (!json.isNull(key))
                return BigDecimal(json.getString(key))
            return BigDecimal.ZERO
        }

        /**
         *check key of value Boolean is exits into json or not, if not return false
         */
        fun getBoolean(json: JSONObject, key: String): Boolean {
            if (!json.isNull(key))
                return json.getBoolean(key)
            return false
        }

        /**
         *check special key of value String is exits into json or not, if not return special value
         */
        fun getSpecialString(json: JSONObject, key: String, specialValue: String): String {
            if (!json.isNull(key))
                return json.getString(key)
            return specialValue
        }

        /**
         *check special key of value Integer is exits into json or not, if not return special value
         */
        fun getSpecialInt(json: JSONObject, key: String, specialValue: Int): Int {
            if (!json.isNull(key))
                return json.getInt(key)
            return specialValue
        }

        /**
         *check special key of value Long is exits into json or not, if not return special value
         */
        fun getSpecialLong(json: JSONObject, key: String, specialValue: Long): Long {
            if (!json.isNull(key))
                return json.getLong(key)
            return specialValue
        }

        /**
         *check special key of value Double is exits into json or not, if not return special value
         */
        fun getSpecialDouble(json: JSONObject, key: String, specialValue: Double): Double {
            if (!json.isNull(key))
                return json.getDouble(key)
            return specialValue
        }

        /**
         *check special key of value BigDecimal is exits into json or not, if not return special value
         */
        fun getSpecialBigDecimal(json: JSONObject, key: String, specialValue: BigDecimal): BigDecimal {
            if (!json.isNull(key))
                return BigDecimal(json.getString(key))
            return specialValue
        }

        /**
         *check special key of value Boolean is exits into json or not, iif not return special value
         */
        fun getSpecialBoolean(json: JSONObject, key: String, specialValue: Boolean): Boolean {
            if (!json.isNull(key))
                return json.getBoolean(key)
            return specialValue
        }
    }
}