package com.mandiri.savin.data.network.usecase

import com.mandiri.savin.data.model.ActivityModel
import com.mandiri.savin.data.network.repository.ActivityRepository
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

    suspend fun mappingRemoteToModel(response: List<ActivityResponse>): List<ActivityModel> {
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
