package com.example.project.uitle

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.project.R
import com.example.project.databinding.ItemFoodsBinding
import com.example.project.model.FoodsData
import com.example.project.view.MainActivity5
import com.example.project.view.MainActivity6

class FoodsAdapter(private var c: Context?, private val foodsList: List<FoodsData>): RecyclerView.Adapter<FoodsAdapter.FoodViewHolder>() {
    inner class FoodViewHolder(val v:ItemFoodsBinding):RecyclerView.ViewHolder(v.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val v=DataBindingUtil.inflate<ItemFoodsBinding>(inflater,R.layout.item_foods,parent,false)
        return FoodViewHolder(v)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val foodsLists=foodsList[position]
        holder.v.isFoodsList=foodsLists
        holder.v.foodImg.setImageResource(foodsLists.foodsImg)
        holder.v.root.setOnClickListener{
            if(foodsLists.foodsName=="Chicken Fajita Pizza"||foodsLists.foodsName=="Chicken Tikka Pizza"||foodsLists.foodsName=="BBQ Chicken Pizza"||foodsLists.foodsName=="Tandoori Chicken Pizza" ){
                var imgF:Int=foodsLists.foodsImg
                var foodsIntent = Intent(c, MainActivity5::class.java)
                foodsIntent.putExtra("foodsName", foodsLists.foodsName)
                foodsIntent.putExtra("foodsInfo", foodsLists.foodsInfo)
                foodsIntent.putExtra("foodsImg", imgF)
                c!!.startActivity(foodsIntent)
            }
            else
            {
                var imgF:Int=foodsLists.foodsImg
                var foodsIntent = Intent(c, MainActivity6::class.java)
                foodsIntent.putExtra("foodsName", foodsLists.foodsName)
                foodsIntent.putExtra("foodsInfo", foodsLists.foodsInfo)
                foodsIntent.putExtra("foodsImg", imgF)
                c!!.startActivity(foodsIntent)
            }
        }
    }

    override fun getItemCount(): Int {
        return foodsList.size
    }
}