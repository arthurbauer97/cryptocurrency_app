package com.example.cryptocurrencyapp.domain.repository

import com.example.cryptocurrencyapp.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>
}