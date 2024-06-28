package com.mandiri.savin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mandiri.savin.api.entity.MenuResponse
import com.mandiri.savin.databinding.ItemMenuBinding

class MenuHomeAdapter(
    private val listMenu: List<MenuResponse>
) : RecyclerView.Adapter<MenuHomeAdapter.MenuViewHolder>() {
    private var onClickMenu: (MenuResponse) -> Unit = {}

    fun setOnClickMenu(listener: (MenuResponse) -> Unit) { onClickMenu = listener }

    inner class MenuViewHolder(val binding: ItemMenuBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: MenuResponse, onClickMenu: (MenuResponse) -> Unit) = with(binding) {
            ivItemMenu.setImageResource(data.image)
            tvTitle.text = data.menuTitle
            constraintItemMenu.setOnClickListener { onClickMenu.invoke(data) }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        return MenuViewHolder(
            ItemMenuBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun getItemCount(): Int { return listMenu.size }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(listMenu[position], onClickMenu)
    }
}