package com.myproject.what_to_do.domain

import com.myproject.what_to_do.data.UsefulActivitiesRepository
import com.myproject.what_to_do.entity.UsefulActivity
import javax.inject.Inject

class GetUsefulActivityUseCase @Inject constructor(private val repo: UsefulActivitiesRepository) {

    suspend fun execute(): UsefulActivity? {
        return repo.getUsefulActivity()
    }
}