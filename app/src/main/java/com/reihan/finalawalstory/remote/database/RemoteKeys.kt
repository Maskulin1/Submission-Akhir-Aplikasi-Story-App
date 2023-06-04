package com.reihan.finalawalstory.remote.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "remote_story")
data class RemoteKeys (
    @PrimaryKey val id: String,
    val prevKey : Int?,
    val nextKey : Int?
)