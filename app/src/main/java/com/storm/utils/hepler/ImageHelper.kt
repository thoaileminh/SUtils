package com.storm.utils.hepler

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.content.CursorLoader
import android.database.Cursor
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Matrix
import android.graphics.drawable.Drawable
import android.media.ExifInterface
import android.net.Uri
import android.os.StrictMode
import android.provider.MediaStore
import com.storm.utils.SUtils
import java.io.File
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL

/**
 * @auth THOẠI ĐẠI CA
 * @date 20/04/2018
 **/

/**
 * class handle image data
 */
class ImageHelper {
    companion object {
        private const val tag: String = "[ImageHelper] "

        /**
         * get bitmap from image URL
         */
        fun getBitmapFromURL(imageUrl: String?): Bitmap? {
            if (imageUrl != null) {
                val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
                StrictMode.setThreadPolicy(policy)
                try {

                    val url = URL(imageUrl)
                    val connection = url.openConnection() as HttpURLConnection
                    connection.doInput = true
                    connection.connect()
                    val input = connection.inputStream

                    val options = BitmapFactory.Options()
                    options.inPreferredConfig = Bitmap.Config.ARGB_8888
                    options.inScaled = false
                    options.inDither = false

                    return BitmapFactory.decodeStream(input, null, options)
                } catch (e: IOException) {
                    SUtils.showLog("$tag [getBitmapFromURL] IOException: $e")
                }
            }

            return null
        }

        /**
         * get bitmap from image in drawable folder
         */
        fun getBitmapFromDrawable(drawable: Drawable): Bitmap {
            var width = drawable.intrinsicWidth
            width = if (width > 0) width else 1
            var height = drawable.intrinsicHeight
            height = if (height > 0) height else 1

            val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
            val canvas = Canvas(bitmap)
            drawable.setBounds(0, 0, canvas.width, canvas.height)
            drawable.draw(canvas)

            return bitmap
        }

        /**
         * get real bitmap with orientation
         */
        fun getRealBitmapOrientation(bitmap: Bitmap, filePath: String): Bitmap? {
            val ei: ExifInterface
            try {
                ei = ExifInterface(filePath)
                val orientation = ei.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL)

                when (orientation) {
                    ExifInterface.ORIENTATION_ROTATE_90 -> return getBitmapRotateImage(bitmap, 90)
                    ExifInterface.ORIENTATION_ROTATE_180 -> return getBitmapRotateImage(bitmap, 180)
                    ExifInterface.ORIENTATION_ROTATE_270 -> return getBitmapRotateImage(bitmap, 270)
                }
            } catch (e: IOException) {
                SUtils.showLog("$tag [getCorrectBitmap] IOException: $e")
            }

            return bitmap
        }

        /**
         * get bitmap rotate image with degrees
         */
        fun getBitmapRotateImage(_bitmap: Bitmap?, degrees: Int): Bitmap? {
            var bitmap = _bitmap
            if (degrees != 0 && bitmap != null) {
                val m = Matrix()
                val width = bitmap.width
                val height = bitmap.height

                m.setRotate(degrees.toFloat(), width.toFloat() / 2, height.toFloat() / 2)
                try {
                    val bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, width, height, m, true)
                    if (bitmap != bitmap2) {
                        bitmap.recycle()
                        bitmap = bitmap2
                    }
                } catch (e: OutOfMemoryError) {
                    SUtils.showLog("$tag [rotateImage] OutOfMemoryError: $e")
                }
            }
            return bitmap
        }

        /**
         * get URI from image file local
         */
        @SuppressLint("Recycle")
        fun getUriFromImageFile(context: Context, imageFile: File): Uri? {
            val filePath = imageFile.absolutePath
            val cursor = context.contentResolver.query(
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                    arrayOf(MediaStore.Images.Media._ID),
                    MediaStore.Images.Media.DATA + "=? ",
                    arrayOf(filePath), null)

            return if (cursor != null && cursor.moveToFirst()) {
                val id = cursor.getInt(cursor
                        .getColumnIndex(MediaStore.MediaColumns._ID))
                val baseUri = Uri.parse("content://media/external/images/media")
                Uri.withAppendedPath(baseUri, "" + id)
            } else if (imageFile.exists()) {
                val values = ContentValues()
                values.put(MediaStore.Images.Media.DATA, filePath)
                context.contentResolver.insert(
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)
            } else {
                null
            }
        }

        /**
         * get path from image URI local
         */
        fun getPathFromImageUri(context: Context, contentUri: Uri): String {
            val projection = arrayOf(MediaStore.Images.Media.DATA)
            val loader = CursorLoader(context, contentUri, projection, null, null, null)
            val cursor = loader.loadInBackground()
            val columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
            cursor.moveToFirst()
            val result = cursor.getString(columnIndex)
            cursor.close()
            return result
        }

        /**
         * get path from cursor
         */
        fun getPathFromCursor(context: Context, _cursor: Cursor): String? {
            var cursor = _cursor
            var imagePath: String? = null
            cursor.moveToFirst()
            var documentId = cursor.getString(0)
            documentId = documentId.substring(documentId.lastIndexOf(":") + 1)
            cursor = context.contentResolver.query(
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, MediaStore.Images.Media._ID + " = ? ", arrayOf(documentId), null)
            cursor.moveToFirst()
            try {
                imagePath = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA))
            } catch (e: Exception) {
                SUtils.showLog("$tag [getImagePathFromCursor] Exception: $e")
            }

            cursor.close()
            return imagePath
        }
    }
}