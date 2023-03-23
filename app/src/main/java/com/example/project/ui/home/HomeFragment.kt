package com.example.project.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.project.Adapters
import com.example.project.R
import com.example.project.databinding.FragmentHomeBinding
import com.example.project.model.FoodsData
import com.example.project.uitle.FoodsAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    private lateinit var foodsAdapter: FoodsAdapter
    private lateinit var foodsData: ArrayList<FoodsData>
    lateinit var adapters: Adapters

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val scrollView:ScrollView=binding.scrollbar
        val viewpager2: ViewPager2 =binding.viewPager
        val textView: TextView =binding.text
        val recyclerview:RecyclerView =binding.foodsRecycler

        return root
    }

    override fun onStart() {
        super.onStart()
        setContentView(R.layout.fragment_home)

        var list= mutableListOf<Int>()

        foodsData= ArrayList<FoodsData>()
        foodsAdapter=FoodsAdapter(context,foodsData)
        foodsRecycler.layoutManager=LinearLayoutManager(context)
        foodsRecycler.adapter=foodsAdapter
        listFoods();

        list.add(R.drawable.slideone)
        list.add(R.drawable.slidetwo)
        list.add(R.drawable.slidethree)
        list.add(R.drawable.slidefour)

        adapters = Adapters(getActivity())
        adapters.setContentlist(list)
        viewPager.adapter=adapters

        circleIndicator.setViewPager(viewPager)
    }

    private fun listFoods() {
        foodsData.add(FoodsData(R.drawable.chickenfajitapizza,"Chicken Fajita Pizza","Rs.450"))
        foodsData.add(FoodsData(R.drawable.chickentikkapizza,"Chicken Tikka Pizza","Rs.470"))
        foodsData.add(FoodsData(R.drawable.bbqchickenpizza,"BBQ Chicken Pizza","Rs.480"))
        foodsData.add(FoodsData(R.drawable.tandoorichickenpizza,"Tandoori Chicken Pizza","Rs.490"))
        foodsData.add(FoodsData(R.drawable.zingerburger,"Zinger Burger","Rs.470"))
        foodsData.add(FoodsData(R.drawable.pattyburger,"Patty Burger","Rs.210"))
        foodsData.add(FoodsData(R.drawable.cheeseburger,"Cheese Burger","Rs.195"))
        foodsData.add(FoodsData(R.drawable.beefburger,"Beef Burger","Rs.230"))
        foodsData.add(FoodsData(R.drawable.frenchfries,"French Fries","Rs.395"))
        foodsData.add(FoodsData(R.drawable.chickennuggets,"Chicken Nuggets","Rs.305"))
        foodsData.add(FoodsData(R.drawable.chickensandwich,"Chicken Sandwich","Rs.375"))
        foodsData.add(FoodsData(R.drawable.friedchicken,"Fried Chicken","Rs.105"))

    }


    private fun setContentView(fragmentHome: Int) {
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}