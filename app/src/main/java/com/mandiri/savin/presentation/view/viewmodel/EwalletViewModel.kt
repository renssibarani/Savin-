package com.mandiri.savin.presentation.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mandiri.savin.data.model.EwalletModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EwalletViewModel @Inject constructor() : ViewModel() {

    private val _ewalletData = MutableLiveData<List<EwalletModel>>()
    val ewalletData: LiveData<List<EwalletModel>>
        get() = _ewalletData

    fun setEwalletData() = viewModelScope.launch {
        _ewalletData.postValue(populateEwalletData())
    }

    private fun populateEwalletData(): List<EwalletModel> {
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