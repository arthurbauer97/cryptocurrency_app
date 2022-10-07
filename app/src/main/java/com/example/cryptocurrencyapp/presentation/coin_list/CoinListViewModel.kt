package com.example.cryptocurrencyapp.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptocurrencyapp.common.ViewState
import com.example.cryptocurrencyapp.domain.use_case.get_coins.GetCoinsUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class CoinListViewModel(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    init {
        getCoins()
    }

    private fun getCoins() {
        getCoinsUseCase().onEach { result ->
            when (result) {
                is ViewState.Success -> {
                    _state.value = CoinListState(coins = result.data ?: emptyList())
                }

                is ViewState.Error -> {
                    _state.value = CoinListState(
                        error = result.message ?: "Ocorreu um erro inesperado"
                    )
                }

                is ViewState.Loading -> {
                    _state.value = CoinListState(
                        isLoading = true
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}