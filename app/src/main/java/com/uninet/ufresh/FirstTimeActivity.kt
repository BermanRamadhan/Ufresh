package com.uninet.ufresh

import android.content.Intent
import android.os.Bundle
import android.view.View.OnFocusChangeListener
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.auth.api.signin.GoogleSignInResult
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.GoogleApiClient


class FirstTimeActivity : AppCompatActivity(), GoogleApiClient.OnConnectionFailedListener{

    lateinit var signingoogle : SignInButton
    private lateinit var  googleApiClient : GoogleApiClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_time)
        val signinfacebook : AppCompatButton = this.findViewById(R.id.signinfacebook)
        signingoogle = this.findViewById(R.id.signingoogle)
        val p = this.findViewById<TextView>(R.id.signupke)
        p.setOnClickListener{
            startActivity(Intent(this,LoginActivity::class.java))
        }
        val gso : GoogleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build()
        googleApiClient = GoogleApiClient.Builder(this).enableAutoManage(this,this).addApi(Auth.GOOGLE_SIGN_IN_API, gso).build()

        signingoogle?.setOnClickListener{
            var intent : Intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient)
            startActivityForResult(intent, SIGN_IN)
        }





        signinfacebook.setOnClickListener {
            val i = Intent(this,MarketListByLocationActivity::class.java)
            Toast.makeText(this, "Login Dengan Facebook", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onConnectionFailed(p0: ConnectionResult) {
        TODO("Not yet implemented")
    }

    companion object {
        private const val SIGN_IN = 1
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == SIGN_IN){
            var result : GoogleSignInResult? = Auth.GoogleSignInApi.getSignInResultFromIntent(data)
            if (result?.isSuccess() == true){
                startActivity(Intent(this,MarketListByLocationActivity::class.java))
                finish()
            }
            else{
                Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}


