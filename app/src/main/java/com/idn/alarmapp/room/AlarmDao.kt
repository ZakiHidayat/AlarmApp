package com.idn.alarmapp.room

import android.graphics.Movie
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface AlarmDao {
    @Insert
    fun addAlarm (alarm : Alarm)

    @Query ("SELECT * FROM alarm")
    // LiveData untuk memberitahu perubahan data yang terjadi di activity secara langsung
    // sehingga recyclerview dapat memperbarui data secara langsung
    fun getAlarm(): LiveData<List<Alarm>>

    @Delete
    fun deleteAlarm(alarm: Alarm)
}