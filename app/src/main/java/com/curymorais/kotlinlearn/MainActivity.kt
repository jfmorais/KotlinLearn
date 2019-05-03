package com.curymorais.kotlinlearn

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.util.Log
import android.view.MenuItem
import com.curymorais.kotlinlearn.dummy.DummyFragment
import com.curymorais.kotlinlearn.localizator.LocalizatorFragment
import com.curymorais.kotlinlearn.twitch.TwitchListFragment

class MainActivity : BaseActivity(), KotlinLearnContract.View, BottomNavigationView.OnNavigationItemSelectedListener {
    val TAG = MainActivity::class.java.simpleName
    lateinit var bottomNavigationView : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_layout_constraint)

        initComponents()
        setComponentListeners()
        loadFragment(HomeFragment())
    }

    override fun initComponents(){
        bottomNavigationView =  findViewById(R.id.navigationView)
    }

    override fun setComponentListeners(){
        bottomNavigationView.setOnNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        var frag : Fragment? = null
        when (p0.itemId) {
            R.id.localizatorTool -> {
                Log.i(TAG, "localizator tool started")
                frag = LocalizatorFragment()
                return loadFragment(frag)
            }
            R.id.mathTool -> {
                Log.i(TAG, "math tool started")
                frag = TwitchListFragment()
                return loadFragment(frag)
            }
            R.id.dummyTool -> {
                Log.i(TAG, "dummy tool started")
                frag = DummyFragment()
                return loadFragment(frag)
            }
        }
        return false
    }

    private fun loadFragment(fragment : Fragment?) : Boolean{
        if (fragment != null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
            return  true
        }
        return false
    }
}