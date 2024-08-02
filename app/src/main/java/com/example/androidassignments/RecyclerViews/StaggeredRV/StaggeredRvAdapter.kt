package com.example.androidassignments.RecyclerViews.StaggeredRV

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidassignments.R
class StaggeredRvAdapter(private val dataSet:Array<StaggeredRvModel>,private val context: Context):
    RecyclerView.Adapter<StaggeredRvAdapter.ViewHolder>() {

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        var imgView:ImageView = view.findViewById(R.id.imageView5)
        var nameView:TextView = view.findViewById(R.id.textView11)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context)
            .inflate(R.layout.staggered_rv_item,parent,false)

        return ViewHolder(view)
    }

    override fun getItemCount()=dataSet.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imgView.setImageResource(dataSet[position].imgSrc)
        holder.nameView.text = dataSet[position].nameSrc
        holder.imgView.setOnClickListener{
            showDialogBox(dataSet[position].imgSrc)
        }
    }

    private fun showDialogBox(imgSrc: Int){
        var dialog=Dialog(context)
        val dialogView=LayoutInflater.from(context).inflate(R.layout.custom_dailog,null)
        val imageView=dialogView.findViewById<ImageView>(R.id.dialogImageView)
        imageView.setImageResource(imgSrc)
        dialog.setContentView(dialogView)
        dialog.show()
    }
}