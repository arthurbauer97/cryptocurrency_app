package com.example.cryptocurrencyapp.data.remote

import com.example.cryptocurrencyapp.data.remote.dto.CoinDto
import retrofit2.http.GET

interface CoinPaprikaApi {
    @GET("v1/coins")
    suspend fun getCoins(): List<CoinDto>

//    @GET("v1/coins/{coinId}")
//    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDto
}