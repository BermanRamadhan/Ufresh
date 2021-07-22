package com.uninet.ufresh.model

class Pasars {
    var gambarpasar: Int? = 0
    var namapasar: String? = ""
    var jarak: String? = ""

    constructor(gambarpasar:Int?, namapasar:String?, jarak:String?){
        this.gambarpasar = gambarpasar
        this.namapasar = namapasar
        this.jarak = jarak
    }

    fun getGambarPasar(): Int? {
        return gambarpasar
    }
    fun setGambarPasar(gambarpasar: Int?){
        this.gambarpasar = gambarpasar
    }
    fun getNamaPasar(): String? {
        return namapasar
    }
    fun setNamaPasar(namapasar: String?){
        this.namapasar = namapasar
    }
    fun getDistance(): String?{
        return jarak
    }
    fun setDistance(jarak:String?){
        this.jarak = jarak
    }


}