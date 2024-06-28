package com.mandiri.savin.presentation.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieDrawable
import com.mandiri.savin.R
import com.mandiri.savin.adapter.ActivityDetailsAdapter
import com.mandiri.savin.api.entity.ActivityModel
import com.mandiri.savin.api.entity.EwalletResponse
import com.mandiri.savin.databinding.ActivityDetailWalletBinding
import com.mandiri.savin.presentation.view.bottomsheet.AddBalanceBottomSheet
import com.mandiri.savin.presentation.view.bottomsheet.AuthBottomSheet
import com.mandiri.savin.presentation.view.viewmodel.DetailsEwalletViewModel
import com.mandiri.savin.utils.SavinUtils.createToast
import com.mandiri.savin.utils.SavinUtils.formatEstimate
import com.mandiri.savin.utils.SavinUtils.formatProgress
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsEwallet : AppCompatActivity() {

    private lateinit var binding: ActivityDetailWalletBinding
    private var data: EwalletResponse? = null
    private val viewModel: DetailsEwalletViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailWalletBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.componentToolbar.tvToolbarTitle.text = "Rincian Dompet"
        binding.componentToolbar.ivBack.setOnClickListener {
            onBackPressed()
        }
        data = intent.getParcelableExtra(DATA_EWALLET)
        setupViewDetails(data)
        data?.path?.let {
            viewModel.apply {
                loading.observe(this@DetailsEwallet) {
                    setLoading(it)
                }
                setActivityData(it)
            }
            observeViewModel()
        }
        observeViewModel()
        binding.llTopUpBalance.setOnClickListener {
            val addBalanceBinding = AddBalanceBottomSheet(this) { amount ->
                val authBinding = AuthBottomSheet(this) { pin ->
                    createToast("Berhasil Tambah Saldo")
                }
                authBinding.show()
            }
            addBalanceBinding.show()
        }
    }

    private fun observeViewModel() {
        viewModel.activityData.observe(this) {
            setActivityData(it)
        }
    }

    private fun setActivityData(data: List<ActivityModel>) {
        binding.componentActivityEwallet.rvActivity.adapter = ActivityDetailsAdapter(data)
    }

    private fun setupViewDetails(data: EwalletResponse?) {
        binding.tvBalance.text = data?.balance
        binding.tvSubTitle.text = data?.title

        if (data != null) {
            binding.pbEwallet.progress = data.progres
        }
        if (data != null) {
            binding.tvProgres.text = data.progres.formatProgress()
        }
        if (data != null) {
            binding.tvEstimate.text = data.message.formatEstimate()
        }
    }

    companion object {
        const val DATA_EWALLET = "data_ewallet"

        fun navigateToDetailEwallet(activity: Activity, data: EwalletResponse) {
            val intent = Intent(activity, DetailsEwallet::class.java)
            intent.putExtra(DATA_EWALLET, data)
            activity.startActivity(intent)
        }
    }

    private fun setLoading(isLoading: Boolean) {
        binding.loSplash.apply {
            visibility = if (isLoading) View.VISIBLE else View.GONE
            setAnimation(R.raw.lo_loadingnew)
            repeatCount = LottieDrawable.INFINITE
            playAnimation()
        }
    }
}