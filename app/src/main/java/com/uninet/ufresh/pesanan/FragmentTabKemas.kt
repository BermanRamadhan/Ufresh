package com.uninet.ufresh.pesanan

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uninet.ufresh.DetailPesananActivity
import com.uninet.ufresh.IntroActivity
import com.uninet.ufresh.R
import com.uninet.ufresh.adapter.PesananAdapter
import com.uninet.ufresh.model.PesananStatusModel
import com.uninet.ufresh.pesananListener.ActionButton

class FragmentTabKemas : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var linearLayoutManager: LinearLayoutManager

    lateinit var pesananAdapter: PesananAdapter
    var addpesananlist: MutableList<PesananStatusModel> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_tab_kemas, container, false)
        recyclerView = view.findViewById(R.id.rv__pesanan__dikemas)
        initView()

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        onAction()
    }

    private fun initView(){
        pesananAdapter = PesananAdapter(requireActivity())
        linearLayoutManager = LinearLayoutManager(requireActivity())
        recyclerView.adapter = pesananAdapter
        recyclerView.layoutManager = linearLayoutManager

        addpesananlist.add(PesananStatusModel("Tomat",40000,"Toko bu Hilda","Dikemas",2))
        addpesananlist.add(PesananStatusModel("Tomat",40000,"Toko bu Hilda","Dikemas",2))
        addpesananlist.add(PesananStatusModel("Tomat",40000,"Toko bu Hilda","Dikemas",2))
        addpesananlist.add(PesananStatusModel("Tomat",40000,"Toko bu Hilda","Dikemas",2))
        addpesananlist.add(PesananStatusModel("Tomat",40000,"Toko bu Hilda","Dikemas",2))
        addpesananlist.add(PesananStatusModel("Tomat",40000,"Toko bu Hilda","Dikemas",2))

        pesananAdapter.setPesanan(addpesananlist)
    }

    fun onAction(){
        pesananAdapter.onClickActionButton(object : ActionButton {
            override fun onClickActionButton(item: View, position: Int) {
                var intent = Intent(context, IntroActivity::class.java)
                intent.putExtra("namabarang", pesananAdapter.getPesanan().get(position).barang)
                Toast.makeText(context, "aasmnois", Toast.LENGTH_SHORT).show()
            }

            override fun onClickOpenDetail(item: View, position: Int) {
                var i = Intent(context, DetailPesananActivity::class.java)
                startActivity(i)
            }
        })
    }


}