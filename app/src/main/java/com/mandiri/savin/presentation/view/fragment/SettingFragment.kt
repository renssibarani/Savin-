package com.mandiri.savin.presentation.view.fragment

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.mandiri.savin.LoginActivity
import com.mandiri.savin.databinding.FragmentSettingBinding
import com.mandiri.savin.model.ProfilResponse
import com.mandiri.savin.presentation.base.BaseFragment
import com.mandiri.savin.presentation.view.viewmodel.SettingViewModel
import com.mandiri.savin.utils.ConfirmationDialogUtil
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingFragment : BaseFragment<FragmentSettingBinding>() {
    private val viewModel: SettingViewModel by viewModels()
    private lateinit var confirmationDialogUtil: ConfirmationDialogUtil
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSettingBinding {
        return FragmentSettingBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        binding.btnLogout.setOnClickListener {
            showConfirmation()
        }
        observeViewModel()
        confirmationDialogUtil = ConfirmationDialogUtil(requireContext())
    }

    private fun observeViewModel() {
        viewModel.logout.observe(viewLifecycleOwner) {
            navigateToLoginScreen()
        }
        viewModel.profilData.observe(viewLifecycleOwner){
            it?.let {
                setupPorfil(it)
            }
        }
    }

    fun logout() {
        viewModel.logout()
    }

    private fun navigateToLoginScreen() {
        val intent = Intent(requireActivity(), LoginActivity::class.java)
        startActivity(intent)
        requireActivity().finish() // Menutup activity saat ini setelah navigasi
    }

    private fun showConfirmation() {
        confirmationDialogUtil.showConfirmationDialog(
            onConfirm =
            {
                logout()
            },
            onCancle =
            {

            }
        )
    }
    private fun setupPorfil(profile: ProfilResponse) {
        binding.tvName.text = profile.name
        binding.tvEmail.text = profile.email
        binding.tvPhone.text = profile.phoneNumber

        Glide.with(this)
            .load(profile.imageUrl)
            .override(300, 300)
            .into(binding.ivProfil)
    }
}