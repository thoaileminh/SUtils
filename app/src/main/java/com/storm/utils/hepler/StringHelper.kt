package com.storm.utils.hepler

/**
 *  @author thoaileminh
 *  @date 20/04/2018
 */

/**
 * class handle string
 */
class StringHelper {
    companion object {
        private const val tag: String = "[StringHelper] "

        /**
         * convert string Vietnamese to English
         */
        fun convertStrVietnameseToEnglish(strVN: String): String {
            var str = strVN
            str = str.replace("[àáạảãâầấậẩẫăằắặẳẵ]".toRegex(), "a")
            str = str.replace("[èéẹẻẽêềếệểễ]".toRegex(), "e")
            str = str.replace("[ìíịỉĩ]".toRegex(), "i")
            str = str.replace("[òóọỏõôồốộổỗơờớợởỡ]".toRegex(), "o")
            str = str.replace("[ùúụủũưừứựửữ]".toRegex(), "u")
            str = str.replace("[ỳýỵỷỹ]".toRegex(), "y")
            str = str.replace("đ".toRegex(), "d")

            str = str.replace("[ÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴ]".toRegex(), "A")
            str = str.replace("[ÈÉẸẺẼÊỀẾỆỂỄ]".toRegex(), "E")
            str = str.replace("[ÌÍỊỈĨ]".toRegex(), "I")
            str = str.replace("[ÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠ]".toRegex(), "O")
            str = str.replace("[ÙÚỤỦŨƯỪỨỰỬỮ]".toRegex(), "U")
            str = str.replace("[ỲÝỴỶỸ]".toRegex(), "Y")
            str = str.replace("Đ".toRegex(), "D")
            return str
        }

        /**
         * count line of content string
         */
        fun countLines(str: String): Int {
            val lines = str.split("\r\n|\r|\n".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            return lines.size
        }
    }
}