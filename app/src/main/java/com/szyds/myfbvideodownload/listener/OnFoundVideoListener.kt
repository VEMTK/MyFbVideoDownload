package com.szyds.myfbvideodownload.listener

import com.szyds.myfbvideodownload.models.Video

interface OnFoundVideoListener {

    fun foundVideo(video: Video)

}