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
import com.uninet.ufresh.model.ProductModel

class
ProductListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    lateinit var gridLayoutManager: GridLayoutManager
    lateinit var productAdapter: ProductAdapter
    var addproductlist : MutableList<ProductModel> = ArrayList()



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_procuct, container, false)


        recyclerView = view.findViewById(R.id.rv__product__list)
        return view


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        initView()
    }

    private fun initView(){
        productAdapter = ProductAdapter(requireActivity())
        gridLayoutManager = GridLayoutManager(requireActivity(),2,LinearLayoutManager.VERTICAL,false)
        recyclerView.layoutManager = gridLayoutManager
        recyclerView.adapter = productAdapter

        addproductlist.add(ProductModel("Tomat","Toko Ibu Neneng","/Kg","sayur",30000,10,R.drawable.tomamto,false,0))
        addproductlist.add(ProductModel("Pisang","Toko Ibu Imas","/Kg","buah",25000,9,R.drawable.cau,false,0))
        addproductlist.add(ProductModel("nanas","Toko Ibu Neneng","/buah","buah",10000,0,R.drawable.nanas1,false,0))
        addproductlist.add(ProductModel("daging ayam","Toko Pak Roy","/Kg","Daging",10000,199,R.drawable.daging_ayam,false,0))
        addproductlist.add(ProductModel("bawang Merah","Toko Ibu Neneng","/Kg","bumbu",10000,20,R.drawable.baawang,false,0))
        addproductlist.add(ProductModel("Ikan salmon","Toko eudora","/Kg","Daging",35000,210,R.drawable.daging_ikan,false,0))
        addproductlist.add(ProductModel("bawang putih","Toko pak balmond","/Kg","sayur",29000,0,R.drawable.ic_baseline_image_24,false,0))



        productAdapter.setProduct(addproductlist)
    }
}