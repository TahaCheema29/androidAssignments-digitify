package com.example.androidassignments.RecyclerViews.StaggeredRV

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.androidassignments.R
import com.example.androidassignments.databinding.ActivityStaggeredRvBinding

class StaggeredRvActivity : AppCompatActivity() {
    private lateinit var binding:ActivityStaggeredRvBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityStaggeredRvBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataSet= arrayOf(
            StaggeredRvModel(R.drawable.pexels_pixabay_268533,"FirstPic"),
            StaggeredRvModel(R.drawable.pexels_ollivves_931007,"SecondPic"),
            StaggeredRvModel(R.drawable.pexels_8moments_1266810,"ThirdPic"),
            StaggeredRvModel(R.drawable.valerie_jardin_misc_1,"FourthPic"),
            StaggeredRvModel(R.drawable.valerie_jardin_misc_4,"FifthPic"),
            StaggeredRvModel(R.drawable.valerie_jardin_random_objects_3,"SixthPic"),
            StaggeredRvModel(R.drawable.valerie_jardin_random_objects_4,"EighthPic"),
            StaggeredRvModel(R.drawable.valerie_jardin_random_things_1,"NinthPic"),
            StaggeredRvModel(R.drawable.valerie_jardin_random_things_3,"tenthPic"),
            StaggeredRvModel(R.drawable.valerie_jardin_random_things_5,"EleventhPic"),
            StaggeredRvModel(R.drawable.valerie_jardin_random_things_21,"TwelvethPic"),
            StaggeredRvModel(R.drawable.valerie_jardin_random_things_7,"thirteenPic"),
            StaggeredRvModel(R.drawable.valerie_jardin_a_window_in_a_window_1,"FourteenPic"),
            StaggeredRvModel(R.drawable.valerie_jardin_random_things_6,"FifteenPic")
            )


        val staggeredRvAdapter=StaggeredRvAdapter(dataSet,this)
        val recyclerView=binding.recyclerView
        recyclerView.adapter=staggeredRvAdapter
        recyclerView.layoutManager=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

    }
}