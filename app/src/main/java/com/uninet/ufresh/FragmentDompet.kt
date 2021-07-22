package com.uninet.ufresh

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uninet.ufresh.adapter.TransaksiDompetAdapter
import com.uninet.ufresh.model.TransaksiDompetModel

class
FragmentDompet : Fragment() {
    lateinit var saldo : TextView
    lateinit var tarikSaldo : AppCompatButton
    lateinit var transaksi : RecyclerView
    lateinit var dompetAdapter: TransaksiDompetAdapter
    lateinit var linearLayoutManager : LinearLayoutManager
    var addListtransaksi : MutableList<TransaksiDompetModel> = arrayListOf()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val p = inflater.inflate(R.layout.fragment_dompet, container, false)
        saldo = p.findViewById(R.id.saldo__dompet)
        tarikSaldo = p.findViewById(R.id.tarik__saldo__dompet)
        transaksi = p.findViewById(R.id.list__transaksi__dompet)
        return p
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    initView()
    }
    private fun initView(){
        dompetAdapter = TransaksiDompetAdapter(requireActivity())
        linearLayoutManager = LinearLayoutManager(requireActivity(),LinearLayoutManager.VERTICAL,false)
        transaksi.layoutManager = linearLayoutManager
        transaksi.adapter = dompetAdapter


        addListtransaksi.add(TransaksiDompetModel("Penarikan Dana","UF/01/I/27012020/UF98237429","12-02-2021",45000,"berhasil"))
        addListtransaksi.add(TransaksiDompetModel("Penarikan Dana","UF/01/I/27012020/UF98237429","12-02-2021",45000,"berhasil"))
        addListtransaksi.add(TransaksiDompetModel("Penarikan Dana","UF/01/I/27012020/UF98237429","12-02-2021",45000,"berhasil"))
        addListtransaksi.add(TransaksiDompetModel("Penarikan Dana","UF/01/I/27012020/UF98237429","12-02-2021",45000,"berhasil"))
        addListtransaksi.add(TransaksiDompetModel("Penarikan Dana","UF/01/I/27012020/UF98237429","12-02-2021",45000,"berhasil"))
        addListtransaksi.add(TransaksiDompetModel("Penarikan Dana","UF/01/I/27012020/UF98237429","12-02-2021",45000,"berhasil"))
        addListtransaksi.add(TransaksiDompetModel("Penarikan Dana","UF/01/I/27012020/UF98237429","12-02-2021",45000,"berhasil"))
        addListtransaksi.add(TransaksiDompetModel("Penarikan Dana","UF/01/I/27012020/UF98237429","12-02-2021",45000,"berhasil"))
        addListtransaksi.add(TransaksiDompetModel("Penarikan Dana","UF/01/I/27012020/UF98237429","12-02-2021",45000,"berhasil"))

        dompetAdapter.setTrDompet(addListtransaksi)
    }


}