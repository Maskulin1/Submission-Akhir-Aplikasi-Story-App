package com.reihan.finalawalstory.ui.location

import com.google.gson.annotations.SerializedName
import com.reihan.finalawalstory.remote.database.ListStory

data class GetStoryResponse (

    @field:SerializedName("listStory")
    val listStory: List<ListStory>,

    @field:SerializedName("error")
    val error: Boolean,

    @field:SerializedName("message")
    val message: String

)