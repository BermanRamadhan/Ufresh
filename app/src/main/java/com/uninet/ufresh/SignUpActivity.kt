package com.uninet.ufresh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val p: AppCompatButton = this.findViewById(R.id.signupbutton)
        val a: TextView = this.findViewById(R.id.sudahpunyaakun)

        p.setOnClickListener {
            startActivity(Intent(this,NoHpActivity ::class.java))
            finish()
        }
        a.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
            finish()
        }
    }
}