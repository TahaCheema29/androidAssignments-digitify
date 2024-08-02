package com.example.androidassignments.DataPersistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Course::class], version = 1, exportSchema = false)
abstract class CourseDataBase: RoomDatabase() {
    abstract fun courseDoa():CourseDoa
    companion object{
        @Volatile
        private var Instance:CourseDataBase?=null

        fun getDataBase(context: Context):CourseDataBase{
            return Instance?: synchronized(this){
                Room.databaseBuilder(context,CourseDataBase::class.java,"course_database")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance=it }
            }
        }
    }
}