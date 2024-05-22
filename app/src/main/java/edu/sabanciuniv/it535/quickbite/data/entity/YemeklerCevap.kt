package edu.sabanciuniv.it535.quickbite.data.entity

import java.io.Serializable

data class YemeklerCevap(var yemekler:List<Yemekler>,
                         var success: Int): Serializable {
}