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

class FragmentTabKirim : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var pesananAdapter: PesananAdapter
    lateinit var linearLayoutManager: LinearLayoutManager
    var addpesananlist : MutableList<PesananStatusModel> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tab_kirim, container, false)
        recyclerView = view.findViewById(R.id.rv__pesanan__kirim)
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

        addpesananlist.add(PesananStatusModel("Tomat",40000,"Toko bu Hilda","Dikirim",2,"kurir : Bpk Argus"))
        addpesananlist.add(PesananStatusModel("Tomat",40000,"Toko bu Hilda","Dikirim",2,"kurir : Bpk Argus"))
        addpesananlist.add(PesananStatusModel("Tomat",40000,"Toko bu Hilda","Dikirim",2,"kurir : Bpk Argus"))
        addpesananlist.add(PesananStatusModel("Tomat",40000,"Toko bu Hilda","Dikirim",2,"kurir : Bpk Argus"))
        addpesananlist.add(PesananStatusModel("Tomat",40000,"Toko bu Hilda","Dikirim",2,"kurir : Bpk Argus"))
        addpesananlist.add(PesananStatusModel("Tomat",40000,"Toko bu Hilda","Dikirim",2,"kurir : Bpk Argus"))

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
                i.putExtra("nama",pesananAdapter.getPesanan().get(position).barang)
                i.putExtra("nama",pesananAdapter.getPesanan().get(position).barang)
                i.putExtra("nama",pesananAdapter.getPesanan().get(position).barang)
                i.putExtra("nama",pesananAdapter.getPesanan().get(position).barang)
                i.putExtra("nama",pesananAdapter.getPesanan().get(position).barang)
                i.putExtra("nama",pesananAdapter.getPesanan().get(position).barang)
                i.putExtra("nama",pesananAdapter.getPesanan().get(position).barang)
                startActivity(i)
            }
        })
    }
}