package com.uninet.ufresh.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.uninet.ufresh.R
import com.uninet.ufresh.model.TransaksiDompetModel

class TransaksiDompetAdapter(var context: Context) : RecyclerView.Adapter<TransaksiDompetAdapter.itemHolder>() {
    val arraylist : MutableList<TransaksiDompetModel> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransaksiDompetAdapter.itemHolder {
        val c = LayoutInflater.from(context).inflate(R.layout.card_transaksi_dompet,parent,false)
        return itemHolder(c)
    }

    override fun onBindViewHolder(holder: itemHolder, position: Int) {
        var trDompetModel : TransaksiDompetModel = arraylist.get(position)
        holder.bindModel(trDompetModel)
    }

    override fun getItemCount(): Int {
        return arraylist.size
    }
fun setTrDompet(data : List<TransaksiDompetModel>){
        arraylist.clear()
        arraylist.addAll(data)
        notifyDataSetChanged()
    }

    inner class itemHolder(view : View) : RecyclerView.ViewHolder(view){
        var nama = view.findViewById<TextView>(R.id.nama__transaksi__dompet)
        var notrans = view.findViewById<TextView>(R.id.no__trans__dompet)
        var tanggal = view.findViewById<TextView>(R.id.tanggal__transaksi__dompet)
        var jumlah = view.findViewById<TextView>(R.id.jumlah__transaksi__dompet)
        var status = view.findViewById<TextView>(R.id.status__transaksi__dompet)


        fun bindModel(dompetModel: TransaksiDompetModel){
            nama.text = dompetModel.namaTransaksi
            notrans.text = dompetModel.nomorTransaksi
            tanggal.text = dompetModel.tanggal
            jumlah.text = dompetModel.jumlah.toString()
            status.text = dompetModel.status

        }

    }
}