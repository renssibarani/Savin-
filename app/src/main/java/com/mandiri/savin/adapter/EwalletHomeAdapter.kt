package com.mandiri.savin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mandiri.savin.api.entity.EwalletResponse
import com.mandiri.savin.databinding.ItemEwalletHomeBinding
import com.mandiri.savin.utils.SavinUtils.formatEstimate
import com.mandiri.savin.utils.SavinUtils.formatProgress

class EwalletHomeAdapter(
    private val listEwallet: List<EwalletResponse>,
    private val onClickEwalletHome: (EwalletResponse) -> Unit
) : RecyclerView.Adapter<EwalletHomeAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemEwalletHomeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: EwalletResponse) = with(binding) {
            tvTitle.text = data.title
            tvProgres.text = data.progres.formatProgress()
            pbEwallet.progress = data.progres
            tvEstimate.text = data.message.formatEstimate()
            constraintEwalletHome.setOnClickListener { onClickEwalletHome.invoke(data) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemEwalletHomeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int { return listEwallet.size }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listEwallet[position])
    }
}