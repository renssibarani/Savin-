package com.mandiri.savin.presentation.view.bottomsheet

import android.content.Context
import android.view.LayoutInflater
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.mandiri.savin.databinding.BottomSheetAddBalanceBinding
import com.mandiri.savin.utils.SavinUtils.createToast

class AddBalanceBottomSheet(
    private val context: Context,
    private val onConfirmAction: (String) -> Unit
) {
    private lateinit var binding: BottomSheetAddBalanceBinding

    fun show() {
        binding = BottomSheetAddBalanceBinding.inflate(LayoutInflater.from(context))
        val bottomSheetDialog = BottomSheetDialog(context)
        bottomSheetDialog.setContentView(binding.root)

        binding.btnConfirm.setOnClickListener {
            val amount = binding.etAmount.text.toString()
            if (amount.isNotEmpty()) {
                onConfirmAction(amount)
                bottomSheetDialog.dismiss()
            } else {
                context.createToast("Masukkan Jumlah : ")
            }
        }
        bottomSheetDialog.show()
    }
}