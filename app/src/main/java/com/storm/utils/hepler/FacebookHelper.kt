package com.storm.utils.hepler

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.util.Base64
import com.storm.utils.SUtils
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

/**
 * @auth THOẠI ĐẠI CA
 * @date 20/04/2018
 **/

/**
 * class handle Facebook SDK
 */
class FacebookHelper {
    companion object {
        private const val tag: String = "[AnimationHelper] "

        /**
         *  get keyHash for longIn facebook
         */
        @SuppressLint("PackageManagerGetSignatures")
        fun getKeyHashesLoginFacebook(context: Context, packageName: String): String {
            try {
                val info = context.packageManager.getPackageInfo(packageName, PackageManager.GET_SIGNATURES)
                for (signature in info.signatures) {
                    val md = MessageDigest.getInstance("SHA")
                    md.update(signature.toByteArray())
                    val keyHash = Base64.encodeToString(md.digest(), Base64.DEFAULT)
                    SUtils.showLog("$tag [getKeyHashesLoginFacebook] KeyHash: $keyHash")
                    return keyHash
                }
            } catch (e1: PackageManager.NameNotFoundException) {
                SUtils.showLog("$tag [getKeyHashesLoginFacebook] PackageManager.NameNotFoundException: " + e1.message)
                return "error"
            } catch (e2: NoSuchAlgorithmException) {
                SUtils.showLog("$tag [getKeyHashesLoginFacebook] NoSuchAlgorithmException: " + e2.message)
                return "error"
            }

            return "error"
        }
    }
}