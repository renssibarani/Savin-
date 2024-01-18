package com.mandiri.savin.presentation.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mandiri.savin.data.model.ActivityModel
import com.mandiri.savin.data.network.usecase.ActivityUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsEwalletViewModel @Inject constructor(
    private val activityUseCase: ActivityUseCase
) : ViewModel() {
    private val _activityData = MutableLiveData<List<ActivityModel>>()
    val activityData: LiveData<List<ActivityModel>>
        get() = _activityData

    private val _isLoading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean>
        get() = _isLoading

    init {
        _isLoading.postValue(true)
    }

    fun setActivityData(path: String) = viewModelScope.launch {
        activityUseCase.getActivityEwallet(path).apply {
            _isLoading.postValue(false)
            _activityData.postValue(this)
        }
    }
}