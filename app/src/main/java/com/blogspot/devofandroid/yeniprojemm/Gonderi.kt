package com.blogspot.devofandroid.yeniprojemm

class Gonderi {
    var id: Int = 0
    var gonderi: String = ""
    var isim:String=""
    var tarih:String=""
    var saat:String=""

    constructor(id: Int, gonderi: String,isim:String,tarih:String,saat:String) {
        this.id = id
        this.gonderi=gonderi
        this.isim=isim
        this.tarih=tarih
        this.saat=saat
    }
    constructor(gonderi: String,isim: String,tarih: String,saat: String){
        this.gonderi=gonderi
        this.isim=isim
        this.tarih=tarih
        this.saat=saat
    }
    constructor()
}