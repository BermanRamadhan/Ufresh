package com.uninet.ufresh.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.uninet.ufresh.R
import com.uninet.ufresh.model.PesananStatusModel
import com.uninet.ufresh.pesananListener.ActionButton
import java.text.NumberFormat
import java.util.*

class PesananAdapter(var context: Context) : RecyclerView.Adapter<PesananAdapter.itemHolder>() {
    var arrayList : MutableList<PesananStatusModel> = mutableListOf()
    lateinit var actionbutton : ActionButton

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemHolder {
        val p = LayoutInflater.from(context).inflate(R.layout.card_pesanan_belum_bayar,parent,false)
        return itemHolder(p)
    }

    override fun onBindViewHolder(holder: itemHolder, position: Int) {
        var psm:PesananStatusModel = arrayList.get(position)
        holder.bindModel(psm)
    }

    override fun getItemCount(): Int {
       return arrayList.size
    }
    fun setPesanan(data:List<PesananStatusModel>){
        arrayList.clear()
        arrayList.addAll(data)
        notifyDataSetChanged()
    }

    inner class itemHolder(view: View) : RecyclerView.ViewHolder(view){
        var tokopesanan = view.findViewById<TextView>(R.id.nama__toko__pesanan)
        var namapesanan = view.findViewById<TextView>(R.id.nama__product__pesanan)
        var quantitypesanan = view.findViewById<TextView>(R.id.quantity__pesanan)
        var statuspesanan = view.findViewById<TextView>(R.id.status__pesanan)
        var hargapesanan = view.findViewById<TextView>(R.id.harga__product__pesanan)
        var kurirpesanan = view.findViewById<TextView>(R.id.kurir__pesanan)
        var actionpesanan = view.findViewById<AppCompatButton>(R.id.action__pesanan)
        var detailpesanan = view.findViewById<ConstraintLayout>(R.id.detail__pesanan__card)


        fun bindModel(psm: PesananStatusModel){
            var numberFormat = NumberFormat.getNumberInstance()
            numberFormat.maximumFractionDigits = 0
            numberFormat.currency = Currency.getInstance("EUR")
            tokopesanan.text = psm.namaToko
            namapesanan.text = psm.barang
            quantitypesanan.text = psm.amount.toString()
            statuspesanan.text = psm.statusPesanan
            hargapesanan.text = numberFormat.format(psm.totalHarga)
            kurirpesanan.text = psm.kurir


        }
        init {
            actionpesanan.setOnClickListener { actionbutton.onClickActionButton(it,layoutPosition) }
            detailpesanan.setOnClickListener { actionbutton.onClickOpenDetail(it,layoutPosition) }

        }
    }

    fun getPesanan(): MutableList<PesananStatusModel>{
        return arrayList
    }

    fun onClickActionButton (actionButton: ActionButton){
        this.actionbutton = actionButton
    }

    fun getStatus(view: View) : String {
        return itemHolder(view).statuspesanan.text.toString()
    }
    fun onClickOpenDetail( actionButton: ActionButton){
        this.actionbutton = actionButton
    }
    fun hidebutton(view: View){
        itemHolder(view).actionpesanan.visibility = View.GONE
    }

}