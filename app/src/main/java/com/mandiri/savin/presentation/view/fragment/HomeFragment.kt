package com.mandiri.savin.presentation.view.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.mandiri.savin.adapter.EwalletHomeAdapter
import com.mandiri.savin.adapter.MenuHomeAdapter
import com.mandiri.savin.data.model.EwalletModel
import com.mandiri.savin.data.model.MenuModel
import com.mandiri.savin.databinding.FragmentHomeBinding
import com.mandiri.savin.model.ProfilResponse
import com.mandiri.savin.presentation.base.BaseFragment
import com.mandiri.savin.presentation.view.DetailsEwallet
import com.mandiri.savin.presentation.view.viewmodel.HomeViewModel
import com.mandiri.savin.presentation.view.viewmodel.ProfilViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    private val viewModel: HomeViewModel by viewModels()
    private val profilViewModel: ProfilViewModel by viewModels()
    private lateinit var menuAdapter: MenuHomeAdapter
    private var _ewalletHomeAdapterData: List<EwalletModel>? = null
    private var _ewalletHomeAdapter: EwalletHomeAdapter? = null

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        viewModel.setMenuHomeData()
        viewModel.setEwalletHomeData()
        profilViewModel.setProfilData()
        profilViewModel.fetchAndSaveProfile()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.menuHomeData.observe(viewLifecycleOwner) {
            setupViewMenu(it)
        }
        viewModel.ewalletHomeData.observe(viewLifecycleOwner){
            setupViewEwallet(it)
        }
        profilViewModel.profilData.observe(viewLifecycleOwner){
            setUserName(it)
        }
    }
    private fun setupViewEwallet(data: List<EwalletModel>){
        _ewalletHomeAdapterData = data
        _ewalletHomeAdapter = EwalletHomeAdapter(data){
            DetailsEwallet.navigateToDetailEwallet(
                activity = requireActivity(),
                data = it
            )
        }
        binding.componentEwalletHome.gridEwalletHome.adapter = _ewalletHomeAdapter
    }
    private fun setupViewMenu(data: List<MenuModel>) {
        menuAdapter = MenuHomeAdapter(data)
        binding.componentMenuHome.gridHome.adapter = menuAdapter

        menuAdapter.setOnClickMenu {
            showToast("${it.menuTitle}")
        }
    }

    private fun setUserName(profilResponse: ProfilResponse) {
        binding.tvName.text = profilResponse.name
    }

}