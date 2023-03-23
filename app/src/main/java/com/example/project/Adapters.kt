package com.example.project

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView


class Adapters(val context: FragmentActivity?):RecyclerView.Adapter<Adapters.MyViewHolder>() {

    lateinit var list: List<Int>
    fun setContentlist(list: List<Int>){
        this.list=list
        notifyDataSetChanged()
    }


    inner class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
        var image=itemView.findViewById<ImageView>(R.id.imageview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view= LayoutInflater.from(context).inflate(R.layout.image_layout, parent, false)
        return MyViewHolder(view)

    }

    override fun onBindViewHolder(holder: Adapters.MyViewHolder, position: Int) {

        holder.image.setImageResource(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

}