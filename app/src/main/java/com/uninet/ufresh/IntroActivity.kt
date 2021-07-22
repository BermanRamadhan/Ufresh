package com.uninet.ufresh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.uninet.ufresh.util.SharedPreference

class IntroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        val btn : Button = this.findViewById(R.id.btn_mulai)


        btn.setOnClickListener{
            val intent = Intent(this,FirstTimeActivity::class.java)
            startActivity(intent)
            finish()

        }
    }
}