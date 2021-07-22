package com.uninet.ufresh.model

class PesananStatusModel {
    var barang : String = ""
    var totalHarga : Int = 0
    var namaToko : String = ""
    var statusPesanan : String = ""
    var kurir : String = ""
    var amount : Int = 0



    constructor(barang: String, totalHarga: Int, namaToko: String, statusPesanan: String, amount: Int) {
        this.barang = barang
        this.totalHarga = totalHarga
        this.namaToko = namaToko
        this.statusPesanan = statusPesanan
        this.amount = amount
    }

    constructor(barang: String, totalHarga: Int, namaToko: String, statusPesanan: String, amount: Int, kurir: String) {
        this.barang = barang
        this.totalHarga = totalHarga
        this.namaToko = namaToko
        this.statusPesanan = statusPesanan
        this.kurir = kurir
        this.amount = amount
    }

}