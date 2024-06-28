package com.mandiri.savin.presentation.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mandiri.savin.api.entity.ActivityModel
import com.mandiri.savin.api.data.usecase.ActivityUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val activityUseCase: ActivityUseCase
) : ViewModel() {

    private val _activityData = MutableLiveData<List<ActivityModel>>()
    private val _isLoading = MutableLiveData<Boolean>()

    val activityData: LiveData<List<ActivityModel>>
        get() = _activityData
    val loading: LiveData<Boolean>
        get() = _isLoading

    init {
        _isLoading.postValue(true)
    }

    fun setActivityData() = viewModelScope.launch {
        activityUseCase.getActivity().apply {
            _isLoading.postValue(false)
            _activityData.postValue(this)
        }
    }
}