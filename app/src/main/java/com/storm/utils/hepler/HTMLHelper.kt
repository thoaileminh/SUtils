package com.storm.utils.hepler

import android.annotation.SuppressLint
import android.os.Build
import android.text.Html
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.widget.TextView

/**
 * @auth THOẠI ĐẠI CA
 * @date 20/04/2018
 **/

/**
 * class load data HTML
 */
class HTMLHelper {
    companion object {
        private const val tag: String = "[HTMLHelper] "

        /**
         * load HTML in TextView
         */
        fun loadHTMLinTextView(textView: TextView, data: String) {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N)
                textView.text = Html.fromHtml(data, Html.FROM_HTML_MODE_LEGACY)
            else
                textView.text = Html.fromHtml(data)
        }

        /**
         * load HTML and optimize WebView
         */
        @SuppressLint("SetJavaScriptEnabled")
        fun loadHTMLinWebView(webView: WebView, data: String) {
            webView.settings.setRenderPriority(WebSettings.RenderPriority.HIGH)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                // chromium, enable hardware acceleration
                webView.setLayerType(View.LAYER_TYPE_HARDWARE, null)
            } else {
                // older android version, disable hardware acceleration
                webView.setLayerType(View.LAYER_TYPE_SOFTWARE, null)
            }

            webView.settings.cacheMode = WebSettings.LOAD_NO_CACHE
            webView.settings.javaScriptEnabled = true
            webView.loadData(data, "text/html", "UTF-8")
        }
    }
}