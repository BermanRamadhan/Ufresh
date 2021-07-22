package com.uninet.ufresh.model

class UserAddressModel {
    var userId : String =""
    var penerima : String = ""
    var nomorhp : String = ""
    var provinsi: String = ""
    var kota: String = ""
    var kecamatan: String = ""
    var kodepos: String = ""

    constructor(
        userId: String,
        penerima: String,
        nomorhp: String,
        provinsi: String,
        kota: String,
        kecamatan: String,
        kodepos: String
    ) {
        this.userId = userId
        this.penerima = penerima
        this.nomorhp = nomorhp
        this.provinsi = provinsi
        this.kota = kota
        this.kecamatan = kecamatan
        this.kodepos = kodepos
    }
}