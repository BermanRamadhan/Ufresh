package com.uninet.ufresh

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.getSystemService
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.location.*
import com.uninet.ufresh.adapter.PasarAdapter2
import com.uninet.ufresh.model.Pasars
import java.util.*
import kotlin.collections.ArrayList


class  HomeFragment() : Fragment() {


//    MAP Properties
    val PERMISSION_ID = 1000
    lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    lateinit var locationRequest : LocationRequest


//    Fragment & recycleview
    private lateinit var recyclerView:RecyclerView
    lateinit var gridLayoutManager:GridLayoutManager
    lateinit var pasarAdapter2: PasarAdapter2
    var addPasarList :MutableList<Pasars> = ArrayList()

    lateinit var loctxt : TextView
    lateinit var searchloc : ImageView


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        loctxt = view!!.findViewById(R.id.this__location)
        searchloc = view.findViewById(R.id.search_for_loc)
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(requireActivity())

        getLastLocation()
        searchloc.setOnClickListener {
            getLastLocation()
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Map
        initView()




    }


    fun initView(){
        recyclerView = requireActivity().findViewById(R.id.rcv__pasar__by__loc)
        pasarAdapter2 = PasarAdapter2(requireActivity())
        gridLayoutManager = GridLayoutManager(activity,2,LinearLayoutManager.VERTICAL,false)
        recyclerView.layoutManager = gridLayoutManager
        recyclerView.adapter = pasarAdapter2


        addPasarList.add(Pasars(R.drawable.pasaer,"Pasar A","1.2 KM dari Lokasi"))
        addPasarList.add(Pasars(R.drawable.pasar1,"Pasar B","2.2 KM dari Lokasi"))
        addPasarList.add(Pasars(R.drawable.pasar2,"Pasar C","3.2 KM dari Lokasi"))
        addPasarList.add(Pasars(R.drawable.pasar2,"Pasar D","1.0 KM dari Lokasi"))
        addPasarList.add(Pasars(R.drawable.pasaer,"Pasar F","1.1 KM dari Lokasi"))
        addPasarList.add(Pasars(R.drawable.pasar1,"Pasar G","2.2 KM dari Lokasi"))
        addPasarList.add(Pasars(R.drawable.pasaer,"Pasar H","3.2 KM dari Lokasi"))
        addPasarList.add(Pasars(R.drawable.pasaer,"Pasar A","1.2 KM dari Lokasi"))
        addPasarList.add(Pasars(R.drawable.pasaer,"Pasar A","1.2 KM dari Lokasi"))

        pasarAdapter2.setPasar(addPasarList)
    }

    private fun addmorepasar(){
        for(i in 0..6){
            addPasarList.add(Pasars(R.drawable.pasaer,"Pasar A","1.2 KM dari Lokasi"))
        }
    }

    private fun checkPermission() : Boolean {
        if ( ActivityCompat.checkSelfPermission(requireActivity(),android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
            || ActivityCompat.checkSelfPermission(requireActivity(),android.Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
        ) {
            return true
        }
            return false
    }

    private fun requestPermission(){
        ActivityCompat.requestPermissions(requireActivity(), arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),PERMISSION_ID!!)
    }

    private fun isLocationEnable():Boolean{
        var locationManager = requireActivity().getSystemService(Context.LOCATION_SERVICE)
        locationManager as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) ||locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == PERMISSION_ID){
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            Log.d("Debug","Permission Granted")
        }
    }

    private fun getLastLocation(){
        if (checkPermission()){
            if (isLocationEnable()){
                fusedLocationProviderClient.lastLocation.addOnCompleteListener { task ->
                    var location : Location? = task.result
                    if (location == null){
                        getNewLocation()
                    }
                    else{
                        loctxt.text = getSubCityName(location.latitude,location.longitude)+", "+getCityName(location.latitude,location.longitude)
                    }
                }

            }
            else{
                Toast.makeText(requireActivity(), "Please Enable Location Service", Toast.LENGTH_SHORT).show()
            }
        }
        else{
            requestPermission()
        }
    }
    @SuppressLint("MissingPermission")
    private fun getNewLocation(){
        locationRequest = LocationRequest()
        locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        locationRequest.interval = 0
        locationRequest.fastestInterval = 0
        locationRequest.numUpdates = 2
        fusedLocationProviderClient.requestLocationUpdates(locationRequest,locationCallback, Looper.myLooper())
    }
    private val locationCallback = object : LocationCallback(){
        override fun onLocationResult(p0: LocationResult) {
            var lastLocation = p0.lastLocation
            Toast.makeText(activity, "Longitude : " +lastLocation.longitude+ ", Langitude : "+lastLocation.latitude+", City : " +getSubCityName(lastLocation.latitude,lastLocation.longitude)+", Country : "+getCityName(lastLocation.latitude,lastLocation.longitude), Toast.LENGTH_SHORT).show()

        }
    }

    private  fun getCityName(lat:Double,long:Double) : String{
        var countryName = ""
        var geoCoder = Geocoder(requireActivity(), Locale.getDefault())
        var address : MutableList<Address> = geoCoder.getFromLocation(lat,long,1)

        countryName = address.get(0).locality
        return countryName
    }

    private  fun getSubCityName(lat:Double,long:Double) : String{
        var cityName = ""
        var geoCoder = Geocoder(requireActivity(), Locale.getDefault())
        var address : MutableList<Address> = geoCoder.getFromLocation(lat,long,1)

        cityName = address.get(0).subLocality
        return cityName


    }
}