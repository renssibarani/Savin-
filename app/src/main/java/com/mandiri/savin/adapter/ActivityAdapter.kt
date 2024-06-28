package com.mandiri.savin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.mandiri.savin.R
import com.mandiri.savin.api.entity.ActivityModel
import com.mandiri.savin.databinding.ItemActivityBinding

class ActivityAdapter(
    private val listActivity: List<ActivityModel>
) : Adapter<ActivityAdapter.ActivityViewHolder>() {

    private var filteredList = listActivity

    inner class ActivityViewHolder(val binding: ItemActivityBinding) :
        ViewHolder(binding.root) {
        fun bind(data: ActivityModel) = with(binding) {
            ivLogoTrasaction.setImageResource(R.drawable.ic_trf_blck)
            tvTitleTransaction.text = data.title
            tvDateTransaction.text = data.date
            tvBalanceTrsaction.text = data.balance
        }

    }

    fun filterList(filteredList: List<ActivityModel>) {
        this.filteredList = filteredList
        notifyDataSetChanged()
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

    override fun getItemCount(): Int { return filteredList.size }

    override fun onBindViewHolder(holder: ActivityViewHolder, position: Int) {
        holder.bind(filteredList[position])
    }
}