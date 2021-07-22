package com.uninet.ufresh

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uninet.ufresh.adapter.ProductAdapter
import com.uninet.ufresh.adapter.TokoAdapter
import com.uninet.ufresh.model.TokoModel

class ShopListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    lateinit var gridLayoutManager: GridLayoutManager
    lateinit var tokoAdapter: TokoAdapter
    var addTokoList : MutableList<TokoModel> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_shop_list, container, false)
        recyclerView = view.findViewById(R.id.rv__shop__list)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView()
    }

    private fun initView(){
        tokoAdapter = TokoAdapter(requireActivity())
        gridLayoutManager = GridLayoutManager(requireActivity(),2,LinearLayoutManager.VERTICAL,false)
        recyclerView.layoutManager = gridLayoutManager
        recyclerView.adapter = tokoAdapter


        addTokoList.add(TokoModel("Toko bu Imas",R.drawable.pasar2,4.5))
        addTokoList.add(TokoModel("Toko bu Imas",R.drawable.pasar2,4.5))
        addTokoList.add(TokoModel("Toko bu Imas",R.drawable.pasar2,4.5))
        addTokoList.add(TokoModel("Toko bu Imas",R.drawable.pasar2,4.5))
        addTokoList.add(TokoModel("Toko bu Imas",R.drawable.pasar2,4.5))
        addTokoList.add(TokoModel("Toko bu Imas",R.drawable.pasar2,4.5))
        addTokoList.add(TokoModel("Toko bu Imas",R.drawable.pasar2,4.5))

        tokoAdapter.setToko(addTokoList)
    }
}