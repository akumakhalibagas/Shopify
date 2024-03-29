package com.makhalibagas.shopify.presentation.shopify

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.makhalibagas.moviesaja.state.UiStateWrapper
import com.makhalibagas.shopify.databinding.ActivityShopifyBinding
import com.makhalibagas.shopify.presentation.detail.DetailActivity
import com.makhalibagas.shopify.presentation.transaction.TransactionActivity
import com.makhalibagas.shopify.utils.collectLifecycleFlow
import com.makhalibagas.shopify.utils.shopify
import com.makhalibagas.shopify.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShopifyActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityShopifyBinding::inflate)
    private val viewModel by viewModels<ShopifyViewModel>()
    private lateinit var shopifyAdapter: ShopifyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initView()
        initListener()
        initObserver()
    }

    private fun initObserver() {
        viewModel.getShopifyProduct()
        collectLifecycleFlow(viewModel.productListState) { state ->
            when (state) {
                is UiStateWrapper.Loading -> {}
                is UiStateWrapper.Success -> shopifyAdapter.setData(state.data)
                is UiStateWrapper.Error -> Toast.makeText(this, state.msg, Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun initListener() {
        shopifyAdapter.onClick = { data ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(shopify, data)
            startActivity(intent)
        }

        binding.imgTransaction.setOnClickListener {
            startActivity(Intent(this, TransactionActivity::class.java))
        }
    }

    private fun initView() {
        shopifyAdapter = ShopifyAdapter()
        binding.rvProduct.adapter = shopifyAdapter
    }
}