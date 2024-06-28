package com.mandiri.savin.api.data.usecase

import com.mandiri.savin.api.entity.ActivityModel
import com.mandiri.savin.api.data.repository.ActivityRepository
import com.mandiri.savin.model.ActivityResponse
import javax.inject.Inject

class ActivityUseCase @Inject constructor(
    private val repository: ActivityRepository
) {
    suspend fun getActivity(): List<ActivityModel>? {
        repository.getActivity().apply {
            if (isSuccessful) {
                return body()?.let { mappingRemoteToModel(it) }
            }
            return listOf()
        }
    }

    fun mappingRemoteToModel(response: List<ActivityResponse>): List<ActivityModel> {
        return response.mapNotNull { activityResponse ->
            activityResponse?.let {
                ActivityModel(
                    date = it.date,
                    title = it.title,
                    balance = it.balance,
                    transaction = it.transaction
                )
            }
        }
    }
}
