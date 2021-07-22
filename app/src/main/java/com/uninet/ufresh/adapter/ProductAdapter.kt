package com.uninet.ufresh.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.uninet.ufresh.Detail__Produk
import com.uninet.ufresh.R
import com.uninet.ufresh.model.Pasars
import com.uninet.ufresh.model.ProductModel

class ProductAdapter(var context : Context) : RecyclerView.Adapter<ProductAdapter.ItemHolder>(){
    var arrayList: MutableList<ProductModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        var p = LayoutInflater.from(context).inflate(R.layout.card_product,parent,false)
        return ItemHolder(p)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    fun setProduct(data :List<ProductModel>){
        arrayList.clear()
        arrayList.addAll(data)
        notifyDataSetChanged()
    }
    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var productModel :ProductModel = arrayList.get(position)
        holder.bindModel(productModel)
    }

    inner class ItemHolder(view :View): RecyclerView.ViewHolder(view){
        var productname = view.findViewById<TextView>(R.id.product__name)
        var productprice = view.findViewById<TextView>(R.id.product__price)
        var productpic = view.findViewById<ImageView>(R.id.product__pic)
        var productCard = view.findViewById<CardView>(R.id.product__card)
        var productSatuan = view.findViewById<TextView>(R.id.product__satuan)
        var productAvailability = view.findViewById<TextView>(R.id.product__availability)
        var addtocart = view.findViewById<ImageView>(R.id.add__to__cart)

        fun bindModel (productModel: ProductModel){
            productname.text = productModel.nama
            productprice.text = productModel.hargaproduct.toString()
            productSatuan.text = productModel.satuan
            productAvailability.text = productModel.availability
            productpic.setImageResource(productModel.gambarproduct)
            productCard.setOnClickListener {
                var intent = Intent(context,Detail__Produk::class.java)
                intent.putExtra("nama",productModel.nama)
                intent.putExtra("harga",productModel.hargaproduct)
                intent.putExtra("gambar",productModel.gambarproduct)
                intent.putExtra("satuan",productModel.satuan)
                intent.putExtra("availability",productModel.availability)
                intent.putExtra("stock",productModel.stock)
                intent.putExtra("daritoko",productModel.daritokomana)
                context!!.startActivity(intent)
            }
            addtocart.setOnClickListener {
                Toast.makeText(context, "Ditambahkan ke Cart", Toast.LENGTH_SHORT).show()
            }
        }

    }


}