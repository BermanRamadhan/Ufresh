package com.uninet.ufresh.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.uninet.ufresh.R
import com.uninet.ufresh.model.Pasars

class PasarAdapter(val context:Context)  : RecyclerView.Adapter<PasarAdapter.PasarViewHolder>() {
    private val pasars: MutableList<Pasars> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PasarViewHolder {
        return PasarViewHolder(LayoutInflater.from(context).inflate(R.layout.list_pasar,parent,false))
    }

    override fun getItemCount(): Int {
        return pasars.size
    }

    override fun onBindViewHolder(holder: PasarAdapter.PasarViewHolder, position: Int) {
        holder.bindModel(pasars[position])
    }


    fun setPasar(data:List<Pasars>){
        pasars.clear()
        pasars.addAll(data)
        notifyDataSetChanged()
    }
    inner class PasarViewHolder(item: View):RecyclerView.ViewHolder(item){
        val namapasar: TextView = item.findViewById(R.id.namapasar)

        fun bindModel(p:Pasars){

        }
    }
}