package com.acronymslutions.kotlinparsejsonfromurl

class PlayersModel {

    var name: String? = null
    var country: String? = null
    var city: String? = null

    fun getNames(): String {
        return name.toString()
    }

    fun setNames(name: String) {
        this.name = name
    }

    fun getCountrys(): String {
        return country.toString()
    }

    fun setCountrys(name: String) {
        this.country = name
    }

    fun getCitys(): String {
        return city.toString()
    }

    fun setCitys(name: String) {
        this.city = name
    }

}