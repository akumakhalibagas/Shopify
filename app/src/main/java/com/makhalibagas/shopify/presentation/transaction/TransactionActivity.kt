package com.makhalibagas.shopify.presentation.transaction

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.makhalibagas.core.utils.collectLifecycleFlow
import com.makhalibagas.core.utils.viewBinding
import com.makhalibagas.shopify.databinding.ActivityTransactionBinding
import com.makhalibagas.shopify.presentation.shopify.ShopifyActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TransactionActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityTransactionBinding::inflate)
    private val viewModel by viewModels<TransactionViewModel>()
    private lateinit var transactionAdapter: TransactionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initView()
        initObserver()
    }

    private fun initView() {
        transactionAdapter = TransactionAdapter()
        binding.rvProduct.adapter = transactionAdapter
    }

    private fun initObserver() {
        viewModel.getShopifyProduct()
        collectLifecycleFlow(viewModel.productListState) { data ->
            transactionAdapter.setData(data)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, ShopifyActivity::class.java))
    }
}