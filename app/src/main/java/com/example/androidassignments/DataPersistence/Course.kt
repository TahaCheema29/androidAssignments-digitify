package com.example.androidassignments.dataPersistence

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "courses")
data class Course(
    @PrimaryKey(autoGenerate = true)
    var id:Int=0,
    @ColumnInfo(name = "Course Name")
    var courseName:String,
    @ColumnInfo(name="Course Duration")
    var courseDuration:String,
    @ColumnInfo(name="Course Tracks")
    var courseTracks:String,
    @ColumnInfo(name="Course Description")
    var courseDescription:String
)
