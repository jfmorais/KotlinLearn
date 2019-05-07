package com.curymorais.kotlinlearn.videocast

import android.os.Environment
import android.util.Log
import android.view.View
import com.curymorais.kotlinlearn.KotlinLearnContract
import java.io.File

class VideoCastPresenter(view: KotlinLearnContract.View): KotlinLearnContract.Presenter {
    val TAG = VideoCastPresenter::class.java.simpleName
    var mView = view

    //Todo refactor do presenter
    fun getVideoList(): ArrayList<Video>{
        var gpath: String = Environment.getExternalStorageDirectory().absolutePath
        var spath = "Download"
        var fullpath = File(gpath + File.separator + spath)
//        var fullpath2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)

        return videoReader(fullpath)
    }

    fun videoReader(root: File) : ArrayList<Video>{
        val fileList: ArrayList<File> = ArrayList()
        var allvideos  = ArrayList<Video>()

        if ( root.listFiles() != null &&  root.listFiles().size > 0) {
            for (currentFile in  root.listFiles()) {
                if (currentFile.name.endsWith(".jpeg")) {
                    // File absolute path
                    Log.e("downloadFilePath", currentFile.getAbsolutePath())
                    // File Name
                    Log.e("downloadFileName", currentFile.getName())
                    fileList.add(currentFile.absoluteFile)
                }else{
                    Log.e(TAG, currentFile.name)
                    var video = Video(currentFile.name, root.toString()+File.separator+currentFile.name)
                    allvideos.add(video)
                }
            }
            Log.w("fileList", "" + fileList.size)
        }
        return allvideos
    }
}