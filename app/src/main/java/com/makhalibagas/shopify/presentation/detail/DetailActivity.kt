package com.makhalibagas.shopify.presentation.detail

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.makhalibagas.core.domain.model.ProductShopify
import com.makhalibagas.core.utils.*
import com.makhalibagas.shopify.databinding.ActivityDetailBinding
import com.makhalibagas.shopify.presentation.checkout.CheckoutActivity

class DetailActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityDetailBinding::inflate)
    private val viewModel by viewModels<DetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initView()
        initListener()
        initObserver()
    }

    private fun initObserver() {
        val data = intent.getParcelableExtra<ProductShopify>(shopify)
        collectLifecycleFlow(viewModel.qty) { qty ->
            binding.apply {
                btMinus.isEnabled(qty != 1)
                btPlus.isEnabled(qty != data?.stock?.toInt())
                tvQty.text = qty.toString()
            }
        }
    }

    private fun initListener() {
        val data = intent.getParcelableExtra<ProductShopify>(shopify)

        binding.apply {
            btAddCart.setOnClickListener {
                Toast.makeText(this@DetailActivity, "Menambahkan ke keranjang", Toast.LENGTH_SHORT)
                    .show()
            }

            btPlus.setOnClickListener { viewModel.plusQty() }

            btMinus.setOnClickListener { viewModel.minusQty() }

            btBuy.setOnClickListener {
                val intent = Intent(this@DetailActivity, CheckoutActivity::class.java)
                intent.putExtra(shopify, data)
                intent.putExtra(qty, viewModel.qty.value)
                startActivity(intent)
            }
        }
    }

    private fun initView() {
        val data = intent.getParcelableExtra<ProductShopify>(shopify)
        binding.apply {
            imgShopify.load(data?.images)
            tvTitle.text = data?.title
            tvDesc.text = Html.fromHtml(data?.desc)
            tvPrice.text = data?.price?.toRupiahFormat()
            tvStok.text = "Tersedia ${data?.stock}"
        }
    }
}