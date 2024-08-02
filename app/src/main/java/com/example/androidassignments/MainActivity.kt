package com.example.androidassignments

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import android.Manifest
import java.io.File

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)



        val songList= arrayListOf<SongModel>()
        getAllSongs(songList)
    }

    @SuppressLint("Recycle", "Range")
    private fun getAllSongs(songsList: ArrayList<SongModel>) {
        val selection = MediaStore.Audio.Media.IS_MUSIC + " != 0"
        val projection = arrayOf(
            MediaStore.Audio.Media._ID,
            MediaStore.Audio.Media.TITLE,
            MediaStore.Audio.Media.ARTIST,
            MediaStore.Audio.Media.DURATION,
            MediaStore.Audio.Media.DATE_ADDED,
            MediaStore.Audio.Media.DATA,
            MediaStore.Audio.Media.ALBUM_ID
        )

        val cursor = this.contentResolver.query(
            MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
            projection, selection, null, MediaStore.Audio.Media.DATE_ADDED + " DESC ", null
        )

        if (cursor != null) {
            Log.d("TAG", "hey")
            if (cursor.moveToFirst()) {
                Log.d("TAG", "hey1")
                do {
                    val id = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media._ID))
                    val title =
                        cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE))
                    val artists =
                        cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST))
                    val duration =
                        cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION))
                    val dateAdded =
                        cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATE_ADDED))
                    val art_Uri =
                        cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID))
                    val path = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA))

                    val uri = Uri.parse("content://media/external/audio/albumart")
                    val artUri = Uri.withAppendedPath(uri, art_Uri).toString()
                    if (File(path).exists()) {
                        songsList.add(SongModel(id, title, artists, duration, dateAdded, artUri))
                    }
                } while (cursor.moveToNext())
                cursor.close()
            }else{
                Log.d("TAG","bye")
            }
        }
    }
}

data class SongModel(
    val id:String,
    val title:String,
    val artist:String,
    val duration:String,
    val dateAdded:String,
    val artUri:String
)