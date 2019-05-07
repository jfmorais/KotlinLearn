package com.curymorais.kotlinlearn.videocast

import android.os.Bundle
import android.os.Environment
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.curymorais.kotlinlearn.KotlinLearnContract
import com.curymorais.kotlinlearn.R
import kotlinx.android.synthetic.main.fragment_videocast.*
import java.io.File

class VideoCastFragment : Fragment(), KotlinLearnContract.View {

    val TAG = VideoCastFragment::class.java.simpleName

    private lateinit var adapter: VideoCastAdapter
    private lateinit var mPresenter : VideoCastPresenter
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_videocast, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initComponents()
//        setComponentListeners()
        updateVideoList()
    }

    override fun initComponents() {
        mPresenter = VideoCastPresenter(this)
        linearLayoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        adapter = VideoCastAdapter()
        video_list.layoutManager = linearLayoutManager
        video_list.adapter = adapter
    }

    override fun setComponentListeners() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun updateVideoList(){
        adapter.updateDataSet(mPresenter.getVideoList())
    }

}

