package com.farazpardazan.weather.framework.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "entity_city", primaryKeys = ["id"])
class CityEntity(
    @field:ColumnInfo(name = "id")      val id: Int,
    @field:ColumnInfo(name = "name")    var name: String,
    @field:ColumnInfo(name = "state")   var state: String,
    @field:ColumnInfo(name = "country") var country: String,
    @field:ColumnInfo(name = "lon")     val lon: Double,
    @field:ColumnInfo(name = "lat")     val lat: Double
)
