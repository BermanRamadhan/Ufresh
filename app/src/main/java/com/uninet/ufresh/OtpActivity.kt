package com.uninet.ufresh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class OtpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp)

        val fabotp : FloatingActionButton = this.findViewById(R.id.fab_otp)
        val otp = this.findViewById<EditText>(R.id.kode__otp)
        val resendotp = this.findViewById<TextView>(R.id.resend_otp)

        fabotp.setOnClickListener {
            val ii = Intent(this,MarketListByLocationActivity::class.java)
            if (otp.text.isEmpty()){
                Toast.makeText(this, "Tolong Masukan 4 digit Angka", Toast.LENGTH_SHORT).show()
            }
            else{
                startActivity(ii)
                finish()
            }
        }
        resendotp.setOnClickListener {
            Toast.makeText(this, "Mengirim ulang Kode otp", Toast.LENGTH_SHORT).show()
        }
    }
}