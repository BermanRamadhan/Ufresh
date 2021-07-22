package com.uninet.ufresh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class NoHpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_no_hp)

        val fab : FloatingActionButton = this.findViewById(R.id.fab_hp)
        var no_hp : EditText = this.findViewById(R.id.et_no_hp)

        fab.setOnClickListener{
            val p = Intent(this,OtpActivity::class.java)
            if (no_hp.text.isEmpty()){
                Toast.makeText(this, "Mohon Isi Nomor hp", Toast.LENGTH_SHORT).show()
            }
            else{
                startActivity(p)
                finish()
            }
        }
    }
}