package com.uninet.ufresh.model

class ProductModel {
    var nama : String =""
    var daritokomana : String = ""
    var satuan : String = ""
    var availability : String = ""
    var category : String = ""
    var hargaproduct : Int = 0
    var stock : Int = 0
    var gambarproduct : Int = 0
    var discountAva : Boolean = false
    var discount : Int = 0
    

    constructor(nama: String, daritokomana: String, satuan: String, category: String, hargaproduct: Int,stock: Int, gambarproduct: Int, discountAva: Boolean, discount: Int) {
        this.nama = nama
        this.daritokomana = daritokomana
        this.satuan = satuan
        this.category = category
        this.hargaproduct = hargaproduct
        this.stock = stock
        this.gambarproduct = gambarproduct
        this.discountAva = discountAva
        this.discount = discount

        if (stock == 0){
            this.availability = "Habis"
        }
        else{
            this.availability ="Ada"
        }
    }
}