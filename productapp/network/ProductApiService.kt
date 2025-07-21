package com.example.productapp.network

import com.example.productapp.model.ProductResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductApiService {
    @GET("rest/V1/productdetails/{productId}/{itemId}")
    suspend fun getProductDetails(
        @Path("productId") productId: Int,
        @Path("itemId") itemId: Int,
        @Query("lang") lang: String = "en",
        @Query("store") store: String = "KWD"
    ): ProductResponse
}


