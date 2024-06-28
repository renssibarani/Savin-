package com.mandiri.savin.utils

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import com.mandiri.savin.R
import com.mandiri.savin.databinding.DialogLayoutBinding

class ConfirmationDialogUtil(private val context: Context) {

    fun showConfirmationDialog(
        onConfirm: () -> Unit,
        onCancel: () -> Unit
    ) {
        val dialogBuilder = AlertDialog.Builder(context)
        val alertDialog = dialogBuilder.create()

        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_layout, null)
        val dialogBinding = DialogLayoutBinding.bind(dialogView)

        alertDialog.setView(dialogView)

        dialogBinding.btnPositive.setOnClickListener {
            onConfirm.invoke()
            alertDialog.dismiss()
        }

        dialogBinding.btnNegative.setOnClickListener {
            onCancel.invoke()
            alertDialog.dismiss()
        }
        alertDialog.show()
    }
}