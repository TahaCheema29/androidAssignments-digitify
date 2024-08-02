package com.example.androidassignments.UIpractice

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidassignments.R

class RvAdapter(private val codeArray:Array<RvModel?>, private val context: Context):
        RecyclerView.Adapter<RvAdapter.ViewHolder>(){

        class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

            var numView: TextView = view.findViewById(R.id.editTextText6)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view= LayoutInflater.from(parent.context)
                .inflate(R.layout.binding_rv_item,parent,false)

            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.numView.text = codeArray[position]?.number
        }

        override fun getItemCount()=codeArray.size
}