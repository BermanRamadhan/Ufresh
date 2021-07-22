package com.uninet.ufresh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uninet.ufresh.adapter.CartAdapter
import com.uninet.ufresh.model.ProductModel

class CartActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var cartAdapter: CartAdapter
    var addCart : MutableList<ProductModel> = ArrayList()
    lateinit var checkout : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        var toolbar  = this.findViewById<Toolbar>(R.id.cart__toolbar)
        checkout = this.findViewById(R.id.cart__checkout)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)


        recyclerView = this.findViewById(R.id.rv__cart__toko)
        linearLayoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        cartAdapter = CartAdapter(this)
        recyclerView.layoutManager =linearLayoutManager
        recyclerView.adapter = cartAdapter
        checkout.setOnClickListener {
            startActivity(Intent(this,CheckOutActivity::class.java))
        }


        addCart.add(ProductModel("tomato","toko sebrang","","",10,10,R.drawable.tomamto,false,0))
        addCart.add(ProductModel("tomato","toko sebrang","","",10,10,R.drawable.tomamto,false,0))
        addCart.add(ProductModel("tomato","toko sebrang","","",10,10,R.drawable.tomamto,false,0))
        addCart.add(ProductModel("tomato","toko sebrang","","",10,10,R.drawable.tomamto,false,0))

        cartAdapter.setCartItem(addCart)
    }
}