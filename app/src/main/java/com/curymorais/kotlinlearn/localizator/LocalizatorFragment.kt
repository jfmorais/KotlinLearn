package com.curymorais.kotlinlearn.localizator

import android.Manifest
import android.content.Context
import android.content.Context.LOCATION_SERVICE
import android.content.pm.PackageManager
import android.location.Criteria
import android.location.LocationManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.curymorais.kotlinlearn.KotlinLearnContract
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import kotlinx.android.synthetic.main.fragment_map.*
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.curymorais.kotlinlearn.R

class LocalizatorFragment : Fragment(), KotlinLearnContract.View, View.OnClickListener, OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    val TAG = LocalizatorFragment::class.java.simpleName
    private var ctx : Context? = null
    private var map: GoogleMap? = null
    private lateinit var locationManager: LocationManager
    private lateinit var mapFragment : SupportMapFragment


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.i(TAG,"onCreateView")
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_map, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.i(TAG,"onViewCreated")
        super.onViewCreated(view, savedInstanceState)
        initComponents()
        setComponentListeners()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.i(TAG,"onActivityCreated")
        super.onActivityCreated(savedInstanceState)
        mapFragment = childFragmentManager.findFragmentById(R.id.map_fragment) as SupportMapFragment
        if(mapFragment != null) {
            mapFragment?.getMapAsync(this)
        }
    }

    override fun onAttach(context: Context?) {
        Log.i(TAG,"onAttach")
        super.onAttach(context)
        ctx = context
        requestPermission()


    }

    override fun initComponents() {
        locationManager = requireContext().getSystemService(LOCATION_SERVICE) as LocationManager
    }

    override fun setComponentListeners() {
        localizatorButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.localizatorButton -> searchLatLong()
        }
    }

    fun searchLatLong(){
        Log.i(TAG,"Starting search")
        if (map != null && ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            val bestProvider = locationManager.getBestProvider(Criteria(), false)
            val location = locationManager.getLastKnownLocation(bestProvider)
            if (location != null) {
                val latLng = LatLng( -23.201616, -49.384516) //LatLng(location.latitude, location.longitude)
                map?.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15f))
                Log.i(TAG,"location $latLng")
            }
        }
    }

    override fun onMapReady(mapGoogle: GoogleMap?) {
        map = mapGoogle
        map?.run {
            uiSettings.isMyLocationButtonEnabled = false
            uiSettings.isMapToolbarEnabled = false
        }
    }

    override fun onMarkerClick(p0: Marker?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun requestPermission(){
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(requireActivity(), arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), MY_LOCATION_REQUEST_CODE)
        }
    }

    companion object {
        private const val MY_LOCATION_REQUEST_CODE = 329
    }
}