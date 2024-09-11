package com.zeus.roomdb.entities

import androidx.room.Entity

@Entity(tableName = "locations", primaryKeys = ["name", "url"])
data class LocationEntity(
    val name: String,
    val url: String
)
