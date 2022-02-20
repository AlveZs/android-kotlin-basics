package com.example.cupcake

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.cupcake.model.OrderVIewModel
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat
import java.util.*

class ViewModelTests {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun quantity_twelve_cupcakes() {
        val viewModel = OrderVIewModel()
        viewModel.quantity.observeForever() {}
        viewModel.setQuantity(12)

        assertEquals(12, viewModel.quantity.value)
    }

    @Test
    fun price_twelve_cupcakes() {
        val viewModel = OrderVIewModel()
        viewModel.price.observeForever() {}
        viewModel.setQuantity(12)

        assertEquals(
            NumberFormat.getCurrencyInstance().format(27),
            viewModel.price.value
        )
    }
}