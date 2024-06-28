package com.mandiri.savin.presentation.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mandiri.savin.R
import com.mandiri.savin.api.entity.EwalletResponse
import com.mandiri.savin.api.entity.MenuResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor():ViewModel(){

    private val _menuHomeData = MutableLiveData<List<MenuResponse>>()
    private val _ewalletHomeData = MutableLiveData<List<EwalletResponse>>()

    val menuHomeData: LiveData<List<MenuResponse>>
        get() = _menuHomeData
    val ewalletHomeData: LiveData<List<EwalletResponse>>
        get() = _ewalletHomeData


    fun setMenuHomeData() = viewModelScope.launch {
        _menuHomeData.postValue(populateDataMenuHome())
    }

    fun setEwalletHomeData() = viewModelScope.launch {
        _ewalletHomeData.postValue(populateEwalletDataHome())
    }

    private fun populateDataMenuHome(): List<MenuResponse> {
        return listOf(
            MenuResponse(
                image = R.drawable.ic_trf,
                menuTitle = "Transfer"
            ),
            MenuResponse(
                image = R.drawable.ic_topup,
                menuTitle = "Top Up"
            ),
            MenuResponse(
                image = R.drawable.ic_pay,
                menuTitle = "Bayar"
            ),
            MenuResponse(
                image = R.drawable.ic_barcode,
                menuTitle = "Qris"
            ),
        )
    }

    private fun populateEwalletDataHome():List<EwalletResponse>{
        return listOf(
            EwalletResponse(
                title = "Beli Mobil",
                progres = 40,
                message = "1 Tahun",
                balance = "Rp. 1.000.000.000,00",
                path = "mobil"
            ),
            EwalletResponse(
                title = "Beli Sepatu",
                progres = 70,
                message = "6 Bulan",
                balance = "Rp. 1.000.000,00",
                path = "sepatu"
            ),
            EwalletResponse(
                title = "Beli Motor",
                progres = 50,
                message = "8 Bulan",
                balance = "Rp. 10.000.000,00",
                path = "motor"
            ),
            EwalletResponse(
                title = "Beli Hp",
                progres = 90,
                message = "2 Bulan",
                balance = "Rp. 8.000.000.,00",
                path = "hp"
            )
        )
    }

}