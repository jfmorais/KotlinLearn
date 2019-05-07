package com.curymorais.kotlinlearn.twitch

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.curymorais.kotlinlearn.KotlinLearnContract
import com.curymorais.kotlinlearn.R

class TwitchListFragment : Fragment(), KotlinLearnContract.View {

    var mPresenter: KotlinLearnContract.Presenter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        initComponents()
        setComponentListeners()
        return inflater.inflate(R.layout.fragment_twitch_list, null)
    }

    override fun initComponents() {
        mPresenter = TwitchListPresenter(this, TwitchListInteractor())
    }

    override fun setComponentListeners() {
        System.out.print(123)
    }

}