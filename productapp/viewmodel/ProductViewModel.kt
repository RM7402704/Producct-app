package com.example.productapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.productapp.model.ProductResponse
import com.example.productapp.repository.ProductRepository
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {
    val productDetails = MutableLiveData<ProductResponse?>()

    fun fetchProductDetails(productId: Int, itemId: Int) {
        viewModelScope.launch {
            try {
                val result = ProductRepository.fetchProductDetails(productId, itemId)
                productDetails.postValue(result)
            } catch (e: Exception) {
                productDetails.postValue(null)
            }
        }
    }
}
