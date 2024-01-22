package com.mandiri.savin.data.network.usecase

import com.mandiri.savin.data.model.ActivityModel
import com.mandiri.savin.data.network.repository.ActivityDetailsRepository
import com.mandiri.savin.data.network.repository.ActivityRepository
import com.mandiri.savin.model.ActivityDetailsResponse
import com.mandiri.savin.model.ActivityResponse
import javax.inject.Inject

class ActivityDetailsUseCase @Inject constructor(
    private val repository: ActivityDetailsRepository
) {
    suspend fun getActivityDetails(path: String): List<ActivityModel>? {
        repository.getActivityDetails(path).apply {
            if (isSuccessful) {
                return body()?.let { mappingRemoteToModel(it) }
            }
            return listOf()
        }
    }

    suspend fun mappingRemoteToModel(response: List<ActivityDetailsResponse>): List<ActivityModel> {
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
