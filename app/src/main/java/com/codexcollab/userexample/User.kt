package com.codexcollab.userexample

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName(value = "id")
    var id: Int? = null,
    @SerializedName(value = "name")
    var name: String? = null,
    @SerializedName(value = "username")
    var username: String? = null,
    @SerializedName(value = "email")
    var email: String? = null,
    @SerializedName(value = "address")
    var address: Address? = null,
    @SerializedName(value = "phone")
    var phone: String? = null,
    @SerializedName(value = "website")
    var website: String? = null,
    @SerializedName(value = "company")
    var company: Company? = null,
)

data class Company(
    @SerializedName(value = "name")
    var name: String? = null,
    @SerializedName(value = "catchPhrase")
    var catchPhrase: String? = null,
    @SerializedName(value = "bs")
    var bs: String? = null
)

data class Address(
    @SerializedName(value = "street")
    var street: String? = null,
    @SerializedName(value = "suite")
    var suite: String? = null,
    @SerializedName(value = "city")
    var city: String? = null,
    @SerializedName(value = "zipcode")
    var zipcode: String? = null,
    @SerializedName(value = "geo")
    var geo: Geo? = null,
)

data class Geo(
    @SerializedName(value = "lat")
    var lat: Double? = null,
    @SerializedName(value = "lng")
    var long: Double? = null,
)