package com.storm.utils.hepler

import org.json.JSONObject
import java.math.BigDecimal

/**
 * @auth THOẠI ĐẠI CA
 * @date 20/04/2018
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
        fun checkKeyStringExits(json: JSONObject, key: String): String {
            if (!json.isNull(key))
                return json.getString(key)
            return ""
        }

        /**
         * check key of value Integer is exits into json or not, if not return 0
         */
        fun checkKeyIntExits(json: JSONObject, key: String): Int {
            if (!json.isNull(key))
                return json.getInt(key)
            return 0
        }

        /**
         * check key of value BigDecimal is exits into json or not, if not return 0
         */
        fun checkKeyBigDecimalExits(json: JSONObject, key: String): BigDecimal {
            if (!json.isNull(key))
                return BigDecimal(json.getString(key))
            return BigDecimal.ZERO
        }

        /**
         *check key of value Boolean is exits into json or not, if not return false
         */
        fun checkKeyBooleanExits(json: JSONObject, key: String): Boolean {
            if (!json.isNull(key))
                return json.getBoolean(key)
            return false
        }

        /**
         *check special key of value String is exits into json or not, if not return special value
         */
        fun checkKeySpecialStringExits(json: JSONObject, key: String, specialValue: String): String {
            if (!json.isNull(key))
                return json.getString(key)
            return specialValue
        }

        /**
         *check special key of value Integer is exits into json or not, if not return special value
         */
        fun checkKeySpecialIntExits(json: JSONObject, key: String, specialValue: Int): Int {
            if (!json.isNull(key))
                return json.getInt(key)
            return specialValue
        }

        /**
         *check special key of value BigDecimal is exits into json or not, if not return special value
         */
        fun checkKeySpecialBigDecimalExits(json: JSONObject, key: String, specialValue: BigDecimal): BigDecimal {
            if (!json.isNull(key))
                return BigDecimal(json.getString(key))
            return specialValue
        }

        /**
         *check special key of value Boolean is exits into json or not, iif not return special value
         */
        fun checkKeyBooleanExits(json: JSONObject, key: String, specialValue: Boolean): Boolean {
            if (!json.isNull(key))
                return json.getBoolean(key)
            return specialValue
        }
    }
}