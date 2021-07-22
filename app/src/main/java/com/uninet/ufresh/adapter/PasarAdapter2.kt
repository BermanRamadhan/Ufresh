    package com.uninet.ufresh.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.uninet.ufresh.R
import com.uninet.ufresh.ShopListActivity
import com.uninet.ufresh.model.Pasars

class PasarAdapter2(var context: Context) : RecyclerView.Adapter<PasarAdapter2.itemHolder>() {
    var arrayList : MutableList<Pasars> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemHolder {
        val p = LayoutInflater.from(context).inflate(R.layout.card_market,parent,false)
        return itemHolder(p)
    }

    override fun onBindViewHolder(holder: itemHolder, position: Int) {
        var pasars:Pasars = arrayList.get(position)
        holder.bindModel(pasars)
    }

    fun setPasar(data :List<Pasars>){
        arrayList.clear()
        arrayList.addAll(data)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
       return arrayList.size
    }

    inner class itemHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var icons = itemView.findViewById<ImageView>(R.id.preview__pasar)
        var namapasar = itemView.findViewById<TextView>(R.id.nama__pasar)
        var jarakpasar = itemView.findViewById<TextView>(R.id.jarak__pasar)
        var cardmarket = itemView.findViewById<ConstraintLayout>(R.id.card__market)

        fun bindModel(pasars :Pasars){
            icons.setImageResource(pasars.gambarpasar!!)
            namapasar.text = pasars.namapasar
            jarakpasar.text = pasars.jarak
            cardmarket.setOnClickListener {
                var intent = Intent(context,ShopListActivity::class.java)
                intent.putExtra("title",pasars.namapasar)
                intent.putExtra("jarak",pasars.jarak)
                context!!.startActivity(intent)
            }
        }





    }
}