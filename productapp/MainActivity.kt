package com.example.productapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.productapp.databinding.ActivityProductDetailsBinding
import com.example.productapp.viewmodel.ProductViewModel
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductDetailsBinding
    private lateinit var viewModel: ProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[ProductViewModel::class.java]

        viewModel.productDetails.observe(this) { product ->
            product?.let {
                binding.productName.text = it.name
                binding.productPrice.text = "${it.price} KWD"
                binding.productStock.text = if (it.is_in_stock) "In Stock" else "Out of Stock"
                Picasso.get().load(it.image).into(binding.productImage)
            }
        }

        viewModel.fetchProductDetails(6701, 253620)
    }
}
