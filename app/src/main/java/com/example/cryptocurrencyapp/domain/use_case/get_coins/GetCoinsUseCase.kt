package com.example.cryptocurrencyapp.domain.use_case.get_coins

import com.example.cryptocurrencyapp.common.ViewState
import com.example.cryptocurrencyapp.data.remote.dto.toCoin
import com.example.cryptocurrencyapp.domain.model.Coin
import com.example.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetCoinsUseCase(
    val repository: CoinRepository
) {
    operator fun invoke(): Flow<ViewState<List<Coin>>> = flow {
        try {
            emit(ViewState.Loading())
            val coins = repository.getCoins().map {
                it.toCoin()
            }
            emit(ViewState.Success(coins))
        } catch (e: HttpException) {
            emit(ViewState.Error("HttpException"))
        } catch (e: IOException) {
            emit(ViewState.Error("IOException"))
        }
    }

}