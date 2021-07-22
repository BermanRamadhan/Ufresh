package com.uninet.ufresh.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.uninet.ufresh.R
import com.uninet.ufresh.model.ProductModel

class CartAdapter(var context: Context): RecyclerView.Adapter<CartAdapter.ItemHolder>() {
    var arrayList : MutableList<ProductModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val a = LayoutInflater.from(context).inflate(R.layout.card_keranjang_item,parent,false)
        return ItemHolder(a)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var productModel : ProductModel = arrayList.get(position)
        holder.bindModel(productModel)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
    fun setCartItem(data:List<ProductModel>){
        arrayList.clear()
        arrayList.addAll(data)
        notifyDataSetChanged()
    }

    inner class ItemHolder(view : View) : RecyclerView.ViewHolder(view) {
        var text1 = view.findViewById<TextView>(R.id.cart__item__name)

        fun bindModel(productModel: ProductModel){
            text1.text = productModel.nama
        }
    }

}