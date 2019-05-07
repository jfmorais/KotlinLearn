package com.curymorais.kotlinlearn.videocast

import android.util.Log
import java.io.Serializable

class Video(name : String, size: String): Serializable  {

    var videoName : String = name
//        get() = field
//
//        set(value) {
//            Log.i("TESTEEEEE!", "passou noseter")
//            field = value
//        }
    var videoSize : String = size




}