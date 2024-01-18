package com.mandiri.savin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mandiri.savin.data.model.MenuModel
import com.mandiri.savin.databinding.ItemMenuBinding

class MenuHomeAdapter(
    private val listMenu: List<MenuModel>
) : RecyclerView.Adapter<MenuHomeAdapter.MenuViewHolder>() {
    private var _onClickMenu: (MenuModel) -> Unit = {}

    fun setOnClickMenu(listener: (MenuModel) -> Unit) {
        _onClickMenu = listener
    }

    inner class MenuViewHolder(val binding: ItemMenuBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: MenuModel, onClickMenu: (MenuModel) -> Unit) {
            binding.ivItemMenu.setImageResource(data.image)
            binding.tvTitle.text = data.menuTitle
            binding.constraintItemMenu.setOnClickListener {
                onClickMenu.invoke(data)
            }
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

    override fun getItemCount(): Int {
        return listMenu.size
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(listMenu[position], _onClickMenu)

    }
}