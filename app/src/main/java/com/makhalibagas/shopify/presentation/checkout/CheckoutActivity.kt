package com.makhalibagas.shopify.presentation.checkout

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.makhalibagas.core.domain.model.ProductShopify
import com.makhalibagas.core.domain.model.ShopifyTransaction
import com.makhalibagas.core.utils.qty
import com.makhalibagas.core.utils.shopify
import com.makhalibagas.core.utils.toRupiahFormat
import com.makhalibagas.core.utils.viewBinding
import com.makhalibagas.shopify.databinding.ActivityCheckoutBinding
import com.makhalibagas.shopify.presentation.transaction.TransactionActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CheckoutActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityCheckoutBinding::inflate)
    private val viewModel by viewModels<CheckoutViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initListener()
        initObserver()

    }

    private fun initObserver() {
        val data = intent.getParcelableExtra<ProductShopify>(shopify)
        val qty = intent.getIntExtra(qty, 1)
        binding.apply {
            binding.apply {
                imgShopify.load(data?.images)
                tvSeller.text = data?.seller
                tvTitle.text = data?.title
                tvPrice.text = data?.price.toString().toRupiahFormat()
                tvQty.text = "X$qty"

                val priceTotal = data?.price?.toFloat()?.times(qty.toFloat())
                tvPriceTotal.text = priceTotal.toString().toRupiahFormat()
                tvPayment.text = (priceTotal?.plus(20000.00)).toString().toRupiahFormat()
            }
        }
    }

    private fun initListener() {

        val data = intent.getParcelableExtra<ProductShopify>(shopify)
        val qty = intent.getIntExtra(qty, 1)
        val priceTotal = data?.price?.toFloat()?.times(qty.toFloat())
        val payment = (priceTotal?.plus(20000.00)).toString().toRupiahFormat()

        binding.btBuy.setOnClickListener {
            viewModel.insertShopify(
                ShopifyTransaction(
                    title = data?.title.toString(),
                    qty = "X$qty",
                    price = payment,
                    status = "Dalam Proses",
                    img = data?.images.toString()
                )
            )
            Toast.makeText(this, "Berhasil", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, TransactionActivity::class.java))
        }
    }
}