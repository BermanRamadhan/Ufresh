package com.uninet.ufresh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton

class FirstLocationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_location)
        val submitloc : AppCompatButton = this.findViewById(R.id.submitlocation)

        submitloc.setOnClickListener {
            val intent = Intent(this,MarketListByLocationActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}