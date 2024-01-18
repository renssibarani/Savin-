    package com.mandiri.savin.adapter

    import android.view.LayoutInflater
    import android.view.ViewGroup
    import android.widget.Toast
    import androidx.recyclerview.widget.RecyclerView
    import com.mandiri.savin.data.model.EwalletModel
    import com.mandiri.savin.data.model.MenuModel
    import com.mandiri.savin.databinding.ItemEwalletBinding
    import com.mandiri.savin.databinding.ItemEwalletHomeBinding

    class EwalletAdapter(
        private val listEwallet: List<EwalletModel>,
        private val onClickEwallet: (EwalletModel) -> Unit
    ) : RecyclerView.Adapter<EwalletAdapter.EwalletViewHolder>() {

        inner class EwalletViewHolder(val binding: ItemEwalletBinding) :
            RecyclerView.ViewHolder(binding.root) {
            fun bind(data: EwalletModel) {
                binding.tvTitle.text = data.title
                binding.tvProgres.text = formatProgress(data.progres)
                binding.pbEwallet.progress = data.progres
                binding.constraintEwallet.setOnClickListener{
                    onClickEwallet.invoke(data)
                }
            }
        }

        fun formatProgress(progress: Int): String {
            return "$progress%"
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

        override fun getItemCount(): Int {
            return listEwallet.size
        }

        override fun onBindViewHolder(holder: EwalletViewHolder, position: Int) {
            holder.bind(listEwallet[position])
        }

    }