package com.storm.utils.hepler

import android.content.Context
import android.content.pm.PackageManager
import android.support.v4.content.ContextCompat

/**
 *  @author thoaileminh
 *  @date 20/04/2018
 */

/**
 * class handle permission
 */
class PermissionHelper {
    companion object {
        private const val tag: String = "[PermissionHelper] "

        /**
         * check permission is granted or not
         */
        fun isGrantedPermission(context: Context, permission: String): Boolean {
            val permissionCheck = ContextCompat.checkSelfPermission(context, permission)
            return permissionCheck == PackageManager.PERMISSION_GRANTED
        }
    }
}