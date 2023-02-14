package com.makhalibagas.shopify.presentation.shopify

import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.makhalibagas.core.domain.model.ProductShopify
import com.makhalibagas.core.utils.toRupiahFormat
import com.makhalibagas.shopify.databinding.ItemShopifyBinding

class ShopifyAdapter : RecyclerView.Adapter<ShopifyAdapter.ViewHolder>() {
    private val listData = ArrayList<ProductShopify>()

    var onClick: ((ProductShopify) -> Unit)? = null

    fun setData(newListData: List<ProductShopify>) {
        val previousContentSize = listData.size
        listData.clear()
        listData.addAll(newListData)
        notifyItemRangeRemoved(0, previousContentSize)
        notifyItemRangeInserted(0, newListData.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemShopifyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount() = listData.size

    inner class ViewHolder(private val binding: ItemShopifyBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: ProductShopify) {
            initView(data)
            initListener(data)
        }

        private fun initView(data: ProductShopify) {
            binding.apply {
                imgShopify.load(data.images)
                tvTitle.text = data.title
                tvDesc.text = Html.fromHtml(data.desc)
                tvPrice.text = data.price.toRupiahFormat()
            }
        }

        private fun initListener(data: ProductShopify) {
            binding.root.setOnClickListener {
                onClick?.invoke(data)
            }
        }
    }
}