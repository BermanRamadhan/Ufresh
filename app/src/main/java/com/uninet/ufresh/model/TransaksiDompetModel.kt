package com.uninet.ufresh.model

import java.util.*

class TransaksiDompetModel {
    var namaTransaksi : String = ""
    var nomorTransaksi : String = ""
    var tanggal : String = ""
    var jumlah : Int = 0
    var status : String = ""

    constructor(
        namaTransaksi: String,
        nomorTransaksi: String,
        tanggal: String,
        jumlah: Int,
        status: String
    ) {
        this.namaTransaksi = namaTransaksi
        this.nomorTransaksi = nomorTransaksi
        this.tanggal = tanggal
        this.jumlah = jumlah
        this.status = status
    }
}