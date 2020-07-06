package com.farazpardazan.weather.framework.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.farazpardazan.weather.framework.database.entity.CityEntity

@Dao
interface CityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(cityEntity: CityEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg cityEntities: CityEntity)

    @Update
    fun update(vararg cityEntities: CityEntity)

    @Delete
    fun delete(vararg cityEntities: CityEntity)

    @Query("DELETE FROM entity_city")
    fun deleteAllItems()

    @Query(
        "SELECT * FROM entity_city " +
                "ORDER BY name DESC"
    )
    fun getAllItems(): LiveData<List<CityEntity>>

    /**
     * Synchronized FUNCTIONALITY
     */

    @Query(
        "SELECT * FROM entity_city " +
                "WHERE name=:name"
    )
    fun find(name: String): CityEntity
}
