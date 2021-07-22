package com.uninet.ufresh.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.uninet.ufresh.R
import com.uninet.ufresh.model.UserAddressModel

class UserAddressAdapter(val context: Context):RecyclerView.Adapter<UserAddressAdapter.ItemHolder>() {
    var list : MutableList<UserAddressModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        var p = LayoutInflater.from(context).inflate(R.layout.card_address_to_deliver,parent,false)
        return ItemHolder(p)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var uam: UserAddressModel = list.get(position)
        holder.bindModel(uam)
    }
    fun setAlamat(data:List<UserAddressModel>){
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ItemHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var namapenerima = itemView.findViewById<TextView>(R.id.alamat__nama__penerima)
        var nohppenerima = itemView.findViewById<TextView>(R.id.alamat__nohp)
        var alamatlengkap = itemView.findViewById<TextView>(R.id.alamat__lengkap)

        fun bindModel(userAddressModel: UserAddressModel){
            var alamatlengkapp : String = userAddressModel.provinsi+", "+userAddressModel.kota+", "+userAddressModel.kecamatan+", "+userAddressModel.kodepos
            namapenerima.text = userAddressModel.penerima
            nohppenerima.text = userAddressModel.nomorhp
            alamatlengkap.text = alamatlengkapp

        }
    }
}