package com.mandiri.savin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mandiri.savin.api.entity.EwalletResponse
import com.mandiri.savin.databinding.ItemEwalletBinding
import com.mandiri.savin.utils.SavinUtils.formatProgress

class EwalletAdapter(
    private val listEwallet: List<EwalletResponse>,
    private val onClickEwallet: (EwalletResponse) -> Unit
) : RecyclerView.Adapter<EwalletAdapter.EwalletViewHolder>() {

    inner class EwalletViewHolder(val binding: ItemEwalletBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: EwalletResponse) = with(binding) {
            tvTitle.text = data.title
            tvProgres.text = data.progres.formatProgress()
            pbEwallet.progress = data.progres
            constraintEwallet.setOnClickListener { onClickEwallet.invoke(data) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EwalletViewHolder {
        return EwalletViewHolder(
            ItemEwalletBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int { return listEwallet.size }

    override fun onBindViewHolder(holder: EwalletViewHolder, position: Int) {
        holder.bind(listEwallet[position])
    }

}