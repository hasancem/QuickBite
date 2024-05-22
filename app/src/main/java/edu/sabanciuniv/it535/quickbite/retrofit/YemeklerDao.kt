package edu.sabanciuniv.it535.quickbite.retrofit

import edu.sabanciuniv.it535.quickbite.data.entity.YemeklerCevap
import retrofit2.Call
import retrofit2.http.GET

interface YemeklerDao {

    @GET("yemekler/tumYemekleriGetir.php")
    fun getYemekler(): Call<YemeklerCevap>

}