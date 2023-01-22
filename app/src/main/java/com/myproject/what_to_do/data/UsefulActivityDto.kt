package com.myproject.what_to_do.data

import com.myproject.what_to_do.entity.UsefulActivity

class UsefulActivityDto(
    override val accessibility: Double,
    override val activity: String,
    override val link: String,
    override val participants: Int,
    override val price: Double,
    override val type: String,
    override val key: String
) : UsefulActivity