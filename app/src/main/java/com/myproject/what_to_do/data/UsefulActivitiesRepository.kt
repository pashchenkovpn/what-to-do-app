package com.myproject.what_to_do.data

import android.util.Log
import com.myproject.what_to_do.entity.UsefulActivity
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

class UsefulActivitiesRepository @Inject constructor() {

    private val defaultAnswer = UsefulActivityDto(1.0,"No activity", "", 1, 1.0, "","")

    suspend fun getUsefulActivity(): UsefulActivity? {
        val response: Response<UsefulActivityDto> = try {
            RetrofitInstance.usefulActivitiesApi.getUsefulActivityFromJson()
        } catch (e: IOException) {
            Log.e("TAG", "IOException, unexpected response")
            return defaultAnswer
        }
        catch (e: HttpException) {
            Log.e("TAG", "HttpException, unexpected response")
            return defaultAnswer
        }
        return if (response.isSuccessful && response.body() != null) response.body() else defaultAnswer
    }


}