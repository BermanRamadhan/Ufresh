package com.uninet.ufresh.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.uninet.ufresh.Detail__Produk
import com.uninet.ufresh.Detail__Toko
import com.uninet.ufresh.R
import com.uninet.ufresh.model.TokoModel

class TokoAdapter(var context : Context) : RecyclerView.Adapter<TokoAdapter.ItemHolder>(){
    var arrayList: MutableList<TokoModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        var p = LayoutInflater.from(context).inflate(R.layout.card_toko,parent,false)
        return ItemHolder(p)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    fun setToko(data :List<TokoModel>){
        arrayList.clear()
        arrayList.addAll(data)
        notifyDataSetChanged()
    }
    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var tokoModel : TokoModel = arrayList.get(position)
        holder.bindModel(tokoModel)
    }

    inner class ItemHolder(view : View): RecyclerView.ViewHolder(view){
        var tokoname = view.findViewById<TextView>(R.id.toko__name)
        var tokopic = view.findViewById<ImageView>(R.id.toko__pic)
        var tokorating = view.findViewById<TextView>(R.id.toko__rating)
        var tokoCard = view.findViewById<CardView>(R.id.toko__card)

        fun bindModel (tokoModel: TokoModel){
            tokoname.text = tokoModel.namatoko
            tokopic.setImageResource(tokoModel.pic)
            tokorating.text = tokoModel.rating.toString()

            tokoCard.setOnClickListener {
                var i = Intent(context,Detail__Toko::class.java)
                i.putExtra("namatoko",tokoModel.namatoko)
                i.putExtra("pictoko",tokoModel.pic)
                i.putExtra("ratingtoko",tokoModel.rating)

                context?.startActivity(i)

            }
        }

    }


}