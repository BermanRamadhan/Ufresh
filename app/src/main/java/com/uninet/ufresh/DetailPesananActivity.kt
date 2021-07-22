package com.uninet.ufresh

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton


class DetailPesananActivity : AppCompatActivity() {
    lateinit var statusPesanan : View
    lateinit var alamatPesanan : View
    lateinit var tokodanItems : View
    lateinit var rincianHarga : View
    lateinit var metodePembayaran: TextView
    lateinit var uploadbukti : AppCompatButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_pesanan)
        statusPesanan = this.findViewById(R.id.status__pesanan__detail)
        alamatPesanan = this.findViewById(R.id.rincian__alamat)
        tokodanItems = this.findViewById(R.id.toko__items)
        rincianHarga = this.findViewById(R.id.rincian__harga)
        metodePembayaran = this.findViewById(R.id.rincian__metode__pembayaran)
        uploadbukti = this.findViewById(R.id.rincian__btn__bukti__pembayaran)
        uploadbukti.setOnClickListener { openGallery() }

    }

    fun openGallery(){
        val i = Intent(Intent.ACTION_PICK)
        i.type = "image/*"
        startActivityForResult(i,100)
    }


}