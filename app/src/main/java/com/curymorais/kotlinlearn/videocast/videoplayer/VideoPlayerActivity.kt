package com.curymorais.kotlinlearn.videocast.videoplayer

import android.net.Uri
import android.net.Uri.*
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.MediaController
import android.widget.VideoView
import com.curymorais.kotlinlearn.R
import kotlinx.android.synthetic.main.activity_video_player.*

class VideoPlayerActivity: AppCompatActivity() {

    //TODO refactor dessa classe
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_player)

        val videoView = videoView
        //Creating MediaController
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        //specify the location of media file
        val uri: Uri = parse(Environment.getExternalStorageDirectory().getPath() + "/Download/videoplayback.mp4")
        //Setting MediaController and URI, then starting the videoView
        videoView.setMediaController(mediaController)
        videoView.setVideoURI(uri)
        videoView.requestFocus()
        videoView.start()
    }
}