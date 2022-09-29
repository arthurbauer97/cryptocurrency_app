package com.example.cryptocurrencyapp

import com.example.cryptocurrencyapp.domain.use_case.get_coins.GetCoinsUseCase
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    private lateinit var useCase: GetCoinsUseCase
    private lateinit var fakeRepository: FakeCoinRepository

    @Before
    fun setup(){
        fakeRepository = FakeCoinRepository()
        useCase = GetCoinsUseCase(fakeRepository)
    }

    @Test
    fun `get all coins`() = runBlocking {
        var coins = useCase.repository.getCoins()
        assertEquals("Bitcoin", coins[0].name)
    }
}