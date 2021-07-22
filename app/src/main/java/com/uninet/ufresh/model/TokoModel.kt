package com.uninet.ufresh.model

class TokoModel {
    var namatoko : String =""
    var pic : Int = 0
    var rating : Double = 0.0

    constructor(namatoko: String,pic :Int, rating: Double) {
        this.namatoko = namatoko
        this.pic = pic
        this.rating = rating
    }
}