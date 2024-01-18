package com.mandiri.savin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mandiri.savin.data.model.EwalletModel
import com.mandiri.savin.databinding.ItemEwalletHomeBinding

class EwalletHomeAdapter(
    private val listEwallet: List<EwalletModel>,
    private val onClickEwalletHome: (EwalletModel) -> Unit
) : RecyclerView.Adapter<EwalletHomeAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemEwalletHomeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: EwalletModel) {
            binding.tvTitle.text = data.title
            binding.tvProgres.text = formatProgress(data.progres)
            binding.pbEwallet.progress = data.progres
            binding.tvEstimate.text = formatEstimate(data.message)
            binding.constraintEwalletHome.setOnClickListener {
                onClickEwalletHome.invoke(data)
            }
        }
    }

    fun formatProgress(progress: Int): String {
        return "$progress%"
    }

    fun formatEstimate(estimate: String): String {
        return "Tersisa ${estimate}"
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

    override fun getItemCount(): Int {
        return listEwallet.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listEwallet[position])
    }

}