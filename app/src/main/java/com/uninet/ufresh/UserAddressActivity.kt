package com.uninet.ufresh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uninet.ufresh.adapter.UserAddressAdapter
import com.uninet.ufresh.model.UserAddressModel

class UserAddressActivity : AppCompatActivity() {
    lateinit var toolbar: Toolbar
    lateinit var recyclerView: RecyclerView
    lateinit var userAddressAdapter : UserAddressAdapter
    lateinit var linearLayoutManager: LinearLayoutManager
    var addListAlamatUser : MutableList<UserAddressModel> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_address)

        toolbar = this.findViewById(R.id.toolbar__user__address)
        recyclerView = this.findViewById(R.id.rv__list__alamat)
        toolbar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.add__new__user__address -> {
                    startActivity(Intent(this,UserAddAddressActivity::class.java))
                }
            }
            true
        }
        initView()
    }
    private fun initView(){
        userAddressAdapter = UserAddressAdapter(this)
        linearLayoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = userAddressAdapter
        addListAlamatUser.add(UserAddressModel("112","hersey","+6282100982183","DKI Jakarta","Jakarta Selatan","Pasar Minggu","45120"))
        addListAlamatUser.add(UserAddressModel("112","hersey","+6282100982183","DKI Jakarta","Jakarta Selatan","Pasar Minggu","45120"))
        addListAlamatUser.add(UserAddressModel("112","hersey","+6282100982183","DKI Jakarta","Jakarta Selatan","Pasar Minggu","45120"))
        addListAlamatUser.add(UserAddressModel("112","hersey","+6282100982183","DKI Jakarta","Jakarta Selatan","Pasar Minggu","45120"))
        addListAlamatUser.add(UserAddressModel("112","hersey","+6282100982183","DKI Jakarta","Jakarta Selatan","Pasar Minggu","45120"))
        addListAlamatUser.add(UserAddressModel("112","hersey","+6282100982183","DKI Jakarta","Jakarta Selatan","Pasar Minggu","45120"))
        userAddressAdapter.setAlamat(addListAlamatUser)
    }
}
