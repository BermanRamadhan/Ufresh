package com.uninet.ufresh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.uninet.ufresh.util.SharedPreference

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        var pre = SharedPreference(this)

        Handler().postDelayed({
            var intent : Intent

            if (!pre.first_install){
                intent = Intent(this,SwipedIntro::class.java)
            }
            else{
                intent = Intent(this,MarketListByLocationActivity::class.java)
            }

            startActivity(intent)
            finish()

        },2000)
    }
}