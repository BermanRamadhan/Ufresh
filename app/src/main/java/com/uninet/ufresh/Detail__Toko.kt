package com.uninet.ufresh

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uninet.ufresh.adapter.ProductAdapter
import com.uninet.ufresh.model.ProductModel
import com.uninet.ufresh.util.BlurBuilder

class Detail__Toko : AppCompatActivity() {
    lateinit var originalbitmap: Bitmap
    lateinit var blurredbitmap: Bitmap
    var bundle : Bundle? = null
    lateinit var backgroundImageToko : ImageView
    lateinit var recyclerView: RecyclerView
    lateinit var gridLayoutManager: GridLayoutManager
    lateinit var productAdapter: ProductAdapter
    var addproductlist : MutableList<ProductModel> = arrayListOf()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail___toko)

        bundle = intent.extras
        var imgToko = bundle?.getInt("pictoko")
        backgroundImageToko = this.findViewById(R.id.bg__profil__toko)
        recyclerView = this.findViewById(R.id.rv__product__di__toko)
        originalbitmap = BitmapFactory.decodeResource(resources, imgToko!!)
        blurredbitmap = BlurBuilder().blur(this,originalbitmap,8f)
        backgroundImageToko.setImageBitmap(blurredbitmap)
        initProduct()

    }

    private fun initProduct(){

        productAdapter = ProductAdapter(this)
        gridLayoutManager = GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false)
        recyclerView.layoutManager = gridLayoutManager
        recyclerView.adapter = productAdapter

        addproductlist.add(ProductModel("Tomat","Toko Ibu Neneng","/Kg","sayur",30000,10,R.drawable.tomamto,false,0))
        addproductlist.add(ProductModel("Pisang","Toko Ibu Imas","/Kg","buah",25000,9,R.drawable.cau,false,0))
        addproductlist.add(ProductModel("nanas","Toko Ibu Neneng","/buah","buah",10000,0,R.drawable.nanas1,false,0))
        addproductlist.add(ProductModel("daging ayam","Toko Pak Roy","/Kg","Daging",10000,199,R.drawable.daging_ayam,false,0))
        addproductlist.add(ProductModel("bawang Merah","Toko Ibu Neneng","/Kg","bumbu",10000,20,R.drawable.baawang,false,0))
        addproductlist.add(ProductModel("Ikan salmon","Toko eudora","/Kg","Daging",35000,210,R.drawable.daging_ikan,false,0))
        addproductlist.add(ProductModel("bawang putih","Toko pak balmond","/Kg","sayur",29000,0,R.drawable.ic_baseline_image_24,false,0))


        productAdapter.setProduct(addproductlist)


    }
}