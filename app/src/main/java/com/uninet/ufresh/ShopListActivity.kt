package com.uninet.ufresh

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.TextView
import android.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout
import com.uninet.ufresh.adapter.ProductAndTokoFragmentAdapter
import com.uninet.ufresh.bottomsheet.BottomSheetFilterFragment
import java.lang.reflect.Array

class ShopListActivity : AppCompatActivity() {
    var b : Bundle? = null
    lateinit var pasarini : AppBarLayout
    lateinit var pasarinu : TextView
    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager
    lateinit var menu: Menu
    lateinit var toolbar: androidx.appcompat.widget.Toolbar





    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop_list)
        pasarini = this.findViewById(R.id.pasar__ini)
        pasarinu = this.findViewById(R.id.pasar__inu)
        viewPager = this.findViewById(R.id.vp__product__toko)
        tabLayout = this.findViewById(R.id.Tab__produk__toko)
        toolbar = this.findViewById(R.id.toolbar__search__filter)

        var bottomSheetFilterFragment = BottomSheetFilterFragment()
        toolbar.setOnMenuItemClickListener{
            when(it.itemId){
                R.id.filter__product -> bottomSheetFilterFragment.show(supportFragmentManager,"BottomSheetDialog")
                R.id.cart__on__product__search -> startActivity(Intent(this,CartActivity::class.java))
            }
            true
        }
        initView()
        setUpTab()
    }

    private fun initView() {
        b = intent.extras
        pasarinu!!.text = "Ini List Produk Dan Pasar Dari :"+b?.getString("title")
    }

    private fun setUpTab(){
        val adapter = ProductAndTokoFragmentAdapter(supportFragmentManager)
        adapter.addFragment(ProductListFragment(),"Product")
        adapter.addFragment(ShopListFragment(),"Toko")
        viewPager!!.adapter = adapter
        tabLayout!!.setupWithViewPager(viewPager)
        
    }
}