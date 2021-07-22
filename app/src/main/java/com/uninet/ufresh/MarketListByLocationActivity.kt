package com.uninet.ufresh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.Toast
import android.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.uninet.ufresh.adapter.PasarAdapter
import com.uninet.ufresh.model.Pasars
import com.uninet.ufresh.util.SharedPreference

class MarketListByLocationActivity : AppCompatActivity() {
    lateinit var pre: SharedPreference
    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    lateinit var frameLayout: FrameLayout.LayoutParams
    lateinit var maincons : ConstraintLayout
    var a = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_market_list_by_location)
        toolbar = this.findViewById(R.id.toolbar__cart__chat)
        Log.i(a,"onCreate")

        toolbar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.cac_cart -> {
                    val p = Intent(this,CartActivity::class.java)
                    startActivity(p)
                }
                R.id.cac_chat -> {
                  val o  = Intent(this, ChatActivity::class.java)
                    startActivity(o)
                }
            }
            true
        }


        val botnav :BottomNavigationView = this.findViewById(R.id.botnav)
        maincons = this.findViewById(R.id.main__constrain)
        botnav.setOnNavigationItemSelectedListener(onBotnavListener)
        botnav.setOnNavigationItemReselectedListener(onBotnavReselect)
        pre = SharedPreference(this)
        pre.first_install = true

        val fr = supportFragmentManager.beginTransaction()
        fr.remove(HomeFragment())
        fr.add(R.id.frameLayout2,HomeFragment())
        fr.commit()


        
    }

    override fun onStart() {
        super.onStart()
        Log.i(a,"onStart")

    }

    override fun onResume() {
        super.onResume()
        Log.i(a,"onResume")

    }

    override fun onPause() {
        super.onPause()
        Log.i(a,"onPause")

    }

    override fun onStop() {
        super.onStop()
        Log.i(a,"onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(a,"onDestroy")

    }

    private val onBotnavListener = BottomNavigationView.OnNavigationItemSelectedListener{item ->
        var selectedfr: Fragment = HomeFragment()

        when(item.itemId){
            R.id.home ->{
                selectedfr = HomeFragment()
            }
            R.id.akun ->{
                selectedfr = AccountFragment()

            }
            R.id.dompet ->{
                selectedfr = FragmentDompet()
            }
            R.id.pesanan ->{
                selectedfr = PesananFragment()
                Log.i("Pesanan","selected")
            }
        else ->{
            Toast.makeText(this, "Under Consntruction",Toast.LENGTH_SHORT).show()
        }
        }
        val fr = supportFragmentManager.beginTransaction()

        fr.replace(R.id.frameLayout2,selectedfr)
        fr.commit()
        true
    }

    private val onBotnavReselect = BottomNavigationView.OnNavigationItemReselectedListener { item ->
    }


}
