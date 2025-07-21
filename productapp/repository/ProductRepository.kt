package com.example.productapp.repository

import com.example.productapp.model.ProductResponse
import com.example.productapp.network.RetrofitClient

object ProductRepository {
    suspend fun fetchProductDetails(productId: Int, itemId: Int): ProductResponse {
        return RetrofitClient.apiService.getProductDetails(productId, itemId)
    }
}

