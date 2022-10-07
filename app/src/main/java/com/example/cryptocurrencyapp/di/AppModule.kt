package com.example.cryptocurrencyapp.di

import com.example.cryptocurrencyapp.common.Constants
import com.example.cryptocurrencyapp.data.remote.CoinPaprikaApi
import com.example.cryptocurrencyapp.domain.repository.CoinRepository
import com.example.cryptocurrencyapp.data.repository.CoinRepositoryImpl
import com.example.cryptocurrencyapp.domain.use_case.get_coins.GetCoinsUseCase
import com.example.cryptocurrencyapp.presentation.coin_list.CoinListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {

    //service
    single<CoinPaprikaApi> {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    //useCase
    factory { GetCoinsUseCase(repository = get()) }

    //viewModel
    viewModel { CoinListViewModel(getCoinsUseCase = get()) }

    //repository
    single<CoinRepository> { CoinRepositoryImpl(get()) }
}