package com.mandiri.savin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.mandiri.savin.R
import com.mandiri.savin.data.model.ActivityModel
import com.mandiri.savin.databinding.ItemActivityBinding

class ActivityAdapter(
    private val listActivity: List<ActivityModel>
) : Adapter<ActivityAdapter.ActivityViewHolder>() {

    inner class ActivityViewHolder(val binding: ItemActivityBinding) :
        ViewHolder(binding.root) {
        fun bind(data: ActivityModel) {
            binding.ivLogoTrasaction.setImageResource(R.drawable.ic_trf_blck)
            binding.tvTitleTransaction.text = data.title
            binding.tvDateTransaction.text = data.date
            binding.tvBalanceTrsaction.text = data.balance

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityViewHolder {
        return ActivityViewHolder(
            ItemActivityBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return listActivity.size
    }

    override fun onBindViewHolder(holder: ActivityViewHolder, position: Int) {
        holder.bind(listActivity[position])
    }


}