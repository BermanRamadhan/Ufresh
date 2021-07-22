package com.uninet.ufresh

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.uninet.ufresh.adapter.SwipedIntroAdapter
import com.uninet.ufresh.model.SwipeIntroModel
import com.uninet.ufresh.util.SharedPreference
import java.util.*
import kotlin.collections.ArrayList

class SwipedIntro : AppCompatActivity() {

    private lateinit var screenPager :ViewPager
    lateinit var swipedIntroAdapter: SwipedIntroAdapter
    lateinit var tabLayout : TabLayout
    lateinit var btnNext : Button
    var position : Int = 0
    lateinit var btnStarted : Button
    lateinit var animationbtn : Animation
    lateinit var textskip : TextView
    lateinit var pre: SharedPreference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_swiped_intro)
        screenPager = this.findViewById(R.id.viewpager__swipe)
        btnStarted = this.findViewById(R.id.btn_get_started)
        tabLayout = this.findViewById(R.id.tab__indicator)
        textskip = this.findViewById(R.id.skip__swipe)
        animationbtn = AnimationUtils.loadAnimation(this,R.anim.get_started_animation)
        pre = SharedPreference(this)


        // fill list screen
        val mList = ArrayList<SwipeIntroModel>()
        var freshFood : Boolean = mList.add(SwipeIntroModel(R.color.ijo_ufresh, R.drawable.img1, "Fresh Is", "Everything", "Tidak Fresh Uang Kembali, adsaihdsahdisahdw yduqbeicasbciubascibaosuc biascbiascbiascbiacbiacbiacbiacbiacubiascu"))
        mList.add(SwipeIntroModel(R.color.teal_700, R.drawable.asuu, "Di Antar", "Ke Rumah", "saasndisahdshad some words some words some words some words some words some words" ))
        mList.add(SwipeIntroModel(R.color.purple_200, R.drawable.img3, "Pembayaran", "Mudah", "some words some wordssome wordssome wordssome wordssome wordsvsome wordssome wordssome wordssome wordsv some words"))



        //setup viewpager
        swipedIntroAdapter = SwipedIntroAdapter(this, mList)
        screenPager.adapter = this.swipedIntroAdapter

        tabLayout.setupWithViewPager(screenPager)


        btnStarted.setOnClickListener{
            pre.first_install = false
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
            finish()

        }

        // skip button click listener
        textskip.setOnClickListener(View.OnClickListener { screenPager.currentItem = mList.size })

        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                screenPager.currentItem = tab?.position!!
                if (tab.position == mList.size - 1){
                    lastIntro()
                }
                else{
                    backIntro()
                }

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })

        tabLayout.setTabRippleColorResource(R.color.white)

    }

    fun lastIntro(){
        btnStarted.visibility = View.VISIBLE
        btnStarted.animation = animationbtn
        tabLayout.visibility = View.INVISIBLE
        textskip.visibility = View.INVISIBLE
    }
    fun backIntro(){
        btnStarted.visibility = View.INVISIBLE
        tabLayout.visibility = View.VISIBLE
        textskip.visibility = View.VISIBLE
    }

}