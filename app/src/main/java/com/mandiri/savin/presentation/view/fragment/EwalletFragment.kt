package com.mandiri.savin.presentation.view.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.mandiri.savin.adapter.EwalletAdapter
import com.mandiri.savin.api.entity.EwalletResponse
import com.mandiri.savin.databinding.FragmentEwalletBinding
import com.mandiri.savin.presentation.base.BaseFragment
import com.mandiri.savin.presentation.view.DetailsEwallet
import com.mandiri.savin.presentation.view.viewmodel.EwalletViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EwalletFragment : BaseFragment<FragmentEwalletBinding>() {

    private val viewModel: EwalletViewModel by viewModels()
    private var _ewalletAdapterData: List<EwalletResponse>? = null
    private var _ewalletAdapter: EwalletAdapter? = null

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentEwalletBinding {
        return FragmentEwalletBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        viewModel.setEwalletData()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.ewalletData.observe(viewLifecycleOwner) {
            setupViewEwallet(it)
        }
    }

    private fun setupViewEwallet(data: List<EwalletResponse>) {
        _ewalletAdapterData = data
        _ewalletAdapter = EwalletAdapter(data) {
            DetailsEwallet.navigateToDetailEwallet(
                activity = requireActivity(),
                data = it
            )
        }
        binding.componentEwallet.gridEwallet.adapter = _ewalletAdapter
    }
}