package com.uninet.ufresh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val o : AppCompatButton = this.findViewById(R.id.login_button)
        val q : TextView = this.findViewById(R.id.belumpunyaakun)
        val qa : TextView = this.findViewById(R.id.atauloginkesosmed)


        o.setOnClickListener {
            startActivity(Intent(this,MarketListByLocationActivity ::class.java))
            finish()
        }
        q.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
        qa.setOnClickListener {
            startActivity(Intent(this, FirstTimeActivity::class.java))

        }
    }
}