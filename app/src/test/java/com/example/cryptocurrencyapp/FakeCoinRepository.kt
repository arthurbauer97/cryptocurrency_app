package com.example.cryptocurrencyapp

import com.example.cryptocurrencyapp.data.remote.dto.CoinDto
import com.example.cryptocurrencyapp.domain.repository.CoinRepository

class FakeCoinRepository : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return listOf(
            CoinDto(
                "1",
                true,
                isNew = true,
                name = "Bitcoin",
                rank = 1,
                symbol = "B",
                type = "crypto"
            )
        )
    }
}