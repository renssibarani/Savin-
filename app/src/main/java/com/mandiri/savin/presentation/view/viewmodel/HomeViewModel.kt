package com.mandiri.savin.presentation.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mandiri.savin.R
import com.mandiri.savin.data.model.EwalletModel
import com.mandiri.savin.data.model.MenuModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor():ViewModel(){
    private val _menuHomeData = MutableLiveData<List<MenuModel>>()
    val menuHomeData: LiveData<List<MenuModel>>
        get() = _menuHomeData
    private val _ewalletHomeData = MutableLiveData<List<EwalletModel>>()
    val ewalletHomeData: LiveData<List<EwalletModel>>
        get() = _ewalletHomeData


    fun setMenuHomeData() = viewModelScope.launch {
        _menuHomeData.postValue(populateDataMenuHome())
    }

    fun setEwalletHomeData() = viewModelScope.launch {
        _ewalletHomeData.postValue(populateEwalletDataHome())
    }

    private fun populateDataMenuHome(): List<MenuModel> {
        return listOf(
            MenuModel(
                image = R.drawable.ic_trf,
                menuTitle = "Transfer"
            ),
            MenuModel(
                image = R.drawable.ic_topup,
                menuTitle = "Top Up"
            ),
            MenuModel(
                image = R.drawable.ic_pay,
                menuTitle = "Bayar"
            ),
            MenuModel(
                image = R.drawable.ic_barcode,
                menuTitle = "Qris"
            ),
        )

    }
    private fun populateEwalletDataHome():List<EwalletModel>{
        return listOf(
            EwalletModel(
                title = "Beli Mobil",
                progres = 40,
                message = "1 Tahun",
                balance = "Rp. 1.000.000.000,00",
                path = "mobil"
            ),
            EwalletModel(
                title = "Beli Sepatu",
                progres = 70,
                message = "6 Bulan",
                balance = "Rp. 1.000.000,00",
                path = "sepatu"
            ),
            EwalletModel(
                title = "Beli Motor",
                progres = 50,
                message = "8 Bulan",
                balance = "Rp. 10.000.000,00",
                path = "motor"
            ),
            EwalletModel(
                title = "Beli Hp",
                progres = 90,
                message = "2 Bulan",
                balance = "Rp. 8.000.000.,00",
                path = "hp"
            )
        )
    }

}