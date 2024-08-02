package com.example.androidassignments.RecyclerViews.LinearRV

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.androidassignments.R

class LinearRvAdapter(private val dataSet:Array<LinearRvModel>, private val context: Context):
    RecyclerView.Adapter<LinearRvAdapter.ViewHolder>(){

    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        lateinit var imgView:ImageView
        lateinit var titleView:TextView
        lateinit var descripView:TextView
        lateinit var dateView: TextView

        init {
            imgView=view.findViewById(R.id.imageView2)
            titleView=view.findViewById(R.id.textView5)
            descripView=view.findViewById(R.id.editText)
            dateView=view.findViewById(R.id.textView7)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context)
            .inflate(R.layout.linear_rv_item,parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imgView.setImageResource(dataSet[position].imgSrc)
        holder.titleView.setText(dataSet[position].titleSrc)
        holder.descripView.setText(dataSet[position].descriptionSrc)
        holder.dateView.setText(dataSet[position].dateSrc)
        val text=holder.dateView.text.toString()
        holder.dateView.setOnClickListener{
            Toast.makeText(context, "$text", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount()=dataSet.size
}