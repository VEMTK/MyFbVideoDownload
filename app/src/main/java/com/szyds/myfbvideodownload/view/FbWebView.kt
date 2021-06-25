package com.szyds.myfbvideodownload.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.util.AttributeSet
import android.webkit.*
import androidx.annotation.RequiresApi
import com.szyds.myfbvideodownload.listener.OnFoundVideoListener

class FbWebView(context: Context, attributeSet: AttributeSet) : WebView(context,attributeSet) {

    private var listener: OnFoundVideoListener? = null

    fun setOnFoundVideoListener(listener: OnFoundVideoListener) {
        this.listener = listener
    }

    init {
        init()
    }

    @SuppressLint("JavascriptInterface", "AddJavascriptInterface", "SetJavaScriptEnabled")
    private fun init() {
        drawingCacheBackgroundColor = Color.WHITE
        isFocusableInTouchMode = true
        isFocusable = true
        isDrawingCacheEnabled = false
        setWillNotCacheDrawing(true)
        isScrollbarFadingEnabled = true
        isSaveEnabled = true
        setNetworkAvailable(true)
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.LOLLIPOP_MR1) {
            isAnimationCacheEnabled = false
            isAlwaysDrawnWithCacheEnabled = false
        }

        setBackgroundColor(Color.WHITE)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(this, true)
        }

        settings.setGeolocationEnabled(true)
        settings.javaScriptEnabled = true
        settings.javaScriptCanOpenWindowsAutomatically = true
        settings.layoutAlgorithm = WebSettings.LayoutAlgorithm.NARROW_COLUMNS
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            try {
                settings.layoutAlgorithm = WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        settings.useWideViewPort = true
        settings.loadWithOverviewMode = true
        settings.domStorageEnabled = true
        settings.setAppCacheEnabled(true)
        settings.cacheMode = WebSettings.LOAD_DEFAULT
        settings.databaseEnabled = true
        settings.setSupportZoom(true)
        //
        //settings.setUserAgentString(WebHead.getRandomAgent(context))
        settings.builtInZoomControls = true
        settings.displayZoomControls = false
        settings.allowContentAccess = true
        settings.allowFileAccess = true
        settings.blockNetworkImage = false
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            settings.allowFileAccessFromFileURLs = false
            settings.allowUniversalAccessFromFileURLs = false
        }
        addJavascriptInterface(this, "wsres")

        webViewClient = MyWebViewClient()
        webChromeClient = MyWebChromeClient()

        loadUrl("https://m.facebook.com")
    }

    inner class MyWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(
            view: WebView?,
            request: WebResourceRequest?
        ): Boolean {
            return super.shouldOverrideUrlLoading(view, request)
        }

        override fun shouldInterceptRequest(
            view: WebView?,
            request: WebResourceRequest?
        ): WebResourceResponse? {
            return super.shouldInterceptRequest(view, request)
        }

        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            return super.shouldOverrideUrlLoading(view, url)
        }

        override fun shouldInterceptRequest(view: WebView?, url: String?): WebResourceResponse? {
            return super.shouldInterceptRequest(view, url)
        }

        @RequiresApi(Build.VERSION_CODES.O)
        override fun onRenderProcessGone(
            view: WebView?,
            detail: RenderProcessGoneDetail?
        ): Boolean {
            if (detail != null) {
                if (!detail.didCrash()) {

                }
            }
            return false
        }
    }

    inner class MyWebChromeClient : WebChromeClient()

    fun destroyWebView() {
//        parent?.removeView(this)
        stopLoading()
        onPause()
        clearHistory()
        visibility = GONE
        removeAllViews()
        destroyDrawingCache()
        destroy()
    }

    fun getCookie(): String? {

        return null
    }


}

