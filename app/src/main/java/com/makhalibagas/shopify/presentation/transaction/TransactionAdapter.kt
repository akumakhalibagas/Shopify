package com.makhalibagas.shopify.presentation.transaction

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.makhalibagas.shopify.databinding.ItemTransactionBinding
import com.makhalibagas.shopify.domain.model.ShopifyTransaction

class TransactionAdapter : RecyclerView.Adapter<TransactionAdapter.ViewHolder>() {
    private val listData = ArrayList<ShopifyTransaction>()


    fun setData(newListData: List<ShopifyTransaction>) {
        val previousContentSize = listData.size
        listData.clear()
        listData.addAll(newListData)
        notifyItemRangeRemoved(0, previousContentSize)
        notifyItemRangeInserted(0, newListData.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemTransactionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount() = listData.size

    inner class ViewHolder(private val binding: ItemTransactionBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: ShopifyTransaction) {
            initView(data)
        }

        private fun initView(data: ShopifyTransaction) {
            binding.apply {
                imgShopify.load(data.img)
                tvTitle.text = data.title
                tvPrice.text = data.price
                tvStatus.text = data.status
                tvQty.text = data.qty
            }
        }
    }
}