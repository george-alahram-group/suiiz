package com.suiiz.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface SuiizDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun <T: Any> upsert() : T



}