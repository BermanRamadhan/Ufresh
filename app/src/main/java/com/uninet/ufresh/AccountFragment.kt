package com.uninet.ufresh

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.auth.api.signin.GoogleSignInResult
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.common.api.OptionalPendingResult
import com.google.android.gms.common.api.ResultCallback
import com.google.android.gms.common.api.Status
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.squareup.picasso.Picasso
import com.uninet.ufresh.`interface`.FragmentChangeListener
import de.hdodenhof.circleimageview.CircleImageView


class AccountFragment : Fragment(), FragmentChangeListener, GoogleApiClient.OnConnectionFailedListener, GoogleApiClient.ConnectionCallbacks{
    private var linearLayout : LinearLayout? = null
    lateinit var profilImage : CircleImageView
    lateinit var username : TextView
    lateinit var emailname : TextView
    lateinit var logout : Button
    lateinit var bottomNavigationView: BottomNavigationView
    lateinit var googleApiClient: GoogleApiClient
    lateinit var gso : GoogleSignInOptions
    lateinit var pesanan:ConstraintLayout
    lateinit var profil:ConstraintLayout
    lateinit var alamat:ConstraintLayout
    lateinit var pembayaran:ConstraintLayout
    lateinit var voucher:ConstraintLayout
    lateinit var notif:ConstraintLayout
    lateinit var bantuan:ConstraintLayout
    lateinit var aboutus:ConstraintLayout



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_account, container, false)



        profilImage  = view.findViewById(R.id.img__Profil)
        username  = view.findViewById(R.id.username)
        emailname = view.findViewById(R.id.tv__email)
        logout = view.findViewById(R.id.btn__logout__profil)
        pesanan = view.findViewById(R.id.p__pesanan__saya)
        profil = view.findViewById(R.id.p_profil)
        alamat = view.findViewById(R.id.p_alamat)
        pembayaran = view.findViewById(R.id.p__pembayaran)
        voucher = view.findViewById(R.id.p_voucher)
        notif = view.findViewById(R.id.p__notifikasi)
        bantuan = view.findViewById(R.id.p_bantuan)
        aboutus = view.findViewById(R.id.p_tentang)
        bottomNavigationView = requireActivity().findViewById(R.id.botnav)

        gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build()

        googleApiClient = GoogleApiClient.Builder(requireActivity()).addConnectionCallbacks(this).addOnConnectionFailedListener(
            this
        ).addApi(Auth.GOOGLE_SIGN_IN_API, gso).build()
        if (googleApiClient.isConnecting){

        }
        logout.setOnClickListener {
            logOut()
        }
        alamat.setOnClickListener {
            startActivity(Intent(requireActivity(),UserAddressActivity::class.java))
        }


        return view
    }


    fun logOut(){
        googleApiClient.connect()
        googleApiClient.registerConnectionCallbacks(object : GoogleApiClient.ConnectionCallbacks{
            override fun onConnected(p0: Bundle?) {
                if (googleApiClient.isConnected){
                    Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(object : ResultCallback<Status> {
                        override fun onResult(p0: Status) {
                            if (p0.isSuccess){
                                Log.d("p","Logged Out")
                                var intent = Intent(activity,FirstTimeActivity::class.java)
                                startActivity(intent)
                                requireActivity().finish()
                            }
                        }

                    })
                }
            }

            override fun onConnectionSuspended(p0: Int) {
                Log.d("fail","suspended")
            }
        }
        )
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        linearLayout = view.findViewById(R.id.opp)
        pesanan.setOnClickListener {

            bottomNavigationView.selectedItemId = R.id.pesanan
        }


    }

    override fun onStart() {
        super.onStart()
        Log.i("OnStart", "here")
        var opr : OptionalPendingResult<GoogleSignInResult> = Auth.GoogleSignInApi.silentSignIn(
            googleApiClient
        )

        if (opr.isDone){
            var result : GoogleSignInResult = opr.get()
            handleSignInResult(result)
        }
        else{
            opr.setResultCallback{
                handleSignInResult(it)
                Log.i("OnStart", "here")
            }
        }
    }



    override fun onConnectionFailed(p0: ConnectionResult) {
        TODO("Not yet implemented")
    }

    fun handleSignInResult(result: GoogleSignInResult){
        if (result.isSuccess){
            var account : GoogleSignInAccount? = result.signInAccount

            username.setText(account?.displayName)
            emailname.setText(account?.email)
            Picasso.get().load(account?.photoUrl).placeholder(R.drawable.ic_baseline_account_box_24).into(
                profilImage
            )
        }
        else{
            Toast.makeText(activity, "Dummy Profil", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onConnected(p0: Bundle?) {
    }

    override fun onConnectionSuspended(p0: Int) {

    }

    override fun replaceFragment(fragment: Fragment) {

    }

}