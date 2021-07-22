package com.uninet.ufresh.pesanan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uninet.ufresh.R
import com.uninet.ufresh.adapter.PesananAdapter
import com.uninet.ufresh.model.PesananStatusModel

class FragmentTabBatal : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var pesananAdapter: PesananAdapter
    lateinit var linearLayoutManager: LinearLayoutManager
    var addpesananlist : MutableList<PesananStatusModel> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_tab_batal, container, false)
        recyclerView = view.findViewById(R.id.rv__pesanan__batal)
        initView()
        return view

    }

    private fun initView() {
        pesananAdapter = PesananAdapter(requireParentFragment().requireActivity())
        linearLayoutManager = LinearLayoutManager(requireParentFragment().requireActivity())
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = pesananAdapter

        addpesananlist.add(PesananStatusModel("Tomat",40000,"Toko bu Hilda","Dibatalkan",2))
        addpesananlist.add(PesananStatusModel("Tomat",40000,"Toko bu Hilda","Dibatalkan",2))
        addpesananlist.add(PesananStatusModel("Tomat",40000,"Toko bu Hilda","Dibatalkan",2))

        pesananAdapter.setPesanan(addpesananlist)

    }

}