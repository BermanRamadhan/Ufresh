package com.uninet.ufresh

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.widget.Toolbar
import androidx.annotation.RequiresApi
import com.uninet.ufresh.model.ProductModel

class Detail__Produk : AppCompatActivity() {

    lateinit var nama:TextView
    lateinit var namatoko:TextView
    lateinit var harga:TextView
    lateinit var satuan:TextView
    lateinit var sedia:TextView
    lateinit var ketersediaan:TextView
    lateinit var gambar:ImageView
    var bundle : Bundle? = null
    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    lateinit var btnkeranjang: TextView
    lateinit var btnbelisekarang: TextView
    lateinit var kunjungitoko : TextView

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail___produk)

        nama = this.findViewById(R.id.nama__detail__product)
        satuan = this.findViewById(R.id.satuan__detail__product)
        sedia = this.findViewById(R.id.ketersediaan__detail__product)
        harga = this.findViewById(R.id.harga__detail__product)
        gambar = this.findViewById(R.id.img__detail__product)
        ketersediaan = this.findViewById(R.id.stock__detail__product)
        namatoko = this.findViewById(R.id.Namatokonya)
        btnbelisekarang = this.findViewById(R.id.beli__sekarang__product__detail)
        btnkeranjang = this.findViewById(R.id.ke__keranjang)
        kunjungitoko = this.findViewById(R.id.kunjungi__toko)
        toolbar = this.findViewById(R.id.toolbar__cart__product__detail)

        btnkeranjang.setOnClickListener {
            Toast.makeText(this, "Ditambahkan Ke keranjang", Toast.LENGTH_SHORT).show()
        }

        kunjungitoko.setOnClickListener {
            startActivity(Intent(this,Detail__Toko::class.java))
        }
        btnbelisekarang.setOnClickListener {
            startActivity(Intent(this,CheckOutActivity::class.java))
        }

        setDetail()
        toolbar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.ufresh__cart -> startActivity(Intent(this,CartActivity::class.java))
            }
            true
        }
    }

    private fun setDetail(){
        bundle = intent.extras
        nama!!.text = bundle?.getString("nama")
        harga!!.text = bundle?.getInt("harga").toString()
        satuan!!.text = bundle?.getString("satuan")
        gambar!!.setImageResource(bundle?.getInt("gambar")!!)
        ketersediaan!!.text = bundle?.getInt("stock").toString()
        namatoko!!.text = bundle?.getString("daritoko")

        if (bundle!!.getInt("stock")!! > 0 ){
            sedia!!.text = bundle?.getString("availability")
        }
        else{
            sedia!!.text = "Out of Stock"
        }
    }
}