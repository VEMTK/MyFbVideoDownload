package com.szyds.myfbvideodownload.downloader

import com.tonyodev.fetch2.*
import java.util.concurrent.Executors
import javax.inject.Singleton

//@Singleton
class DownloadManager {

    private var fetch: Fetch? = null

    private val executors = Executors.newFixedThreadPool(10)

    fun download() {

//        val fetchConfiguration: FetchConfiguration = FetchConfiguration.Builder(this)
//            .setDownloadConcurrentLimit(3)
//            .build()
//
//        val url = "http:www.example.com/test.txt"
//        val file = "/downloads/test.txt"
//
//        fetch = Fetch.Impl.getInstance(fetchConfiguration)
//        val request = Request(url, file)
////        request.setPriority(Priority.HIGH)
////        request.setNetworkType(NetworkType.ALL)
//        request.addHeader("clientKey", "SD78DF93_3947&MVNGHE1WONG")
//
//        fetch!!.enqueue(request,
//            { updatedRequest: Request? -> }
//        ) { error: Error? -> }

    }


}