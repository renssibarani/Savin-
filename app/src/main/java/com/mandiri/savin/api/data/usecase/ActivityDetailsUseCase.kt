package com.mandiri.savin.api.data.usecase

import com.mandiri.savin.api.entity.ActivityModel
import com.mandiri.savin.api.data.repository.ActivityDetailsRepository
import com.mandiri.savin.model.HistoryDetailsResponse
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

    fun mappingRemoteToModel(response: List<HistoryDetailsResponse>): List<ActivityModel> {
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
