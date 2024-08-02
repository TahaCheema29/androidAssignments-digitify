package com.example.androidassignments.dataPersistence

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface CourseDoa {
    @Query("SELECT * FROM courses ORDER BY courses.id ASC")
    fun getAllCourses(): LiveData<List<Course>>
    @Insert(onConflict= OnConflictStrategy.IGNORE)
    suspend fun insertCourse(course:Course)
    @Delete
    suspend fun deleteCourse(course:Course)
    @Update
    suspend fun updateCourse(course:Course)
}