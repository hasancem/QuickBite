package edu.sabanciuniv.it535.quickbite.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bumptech.glide.Glide

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import edu.sabanciuniv.it535.quickbite.databinding.FragmentYemeklerListBinding
import edu.sabanciuniv.it535.quickbite.ui.adapter.YemeklerAdapter
import edu.sabanciuniv.it535.quickbite.retrofit.RetrofitClient
import edu.sabanciuniv.it535.quickbite.retrofit.YemeklerDao
import edu.sabanciuniv.it535.quickbite.data.entity.YemeklerCevap

class YemeklerListFragment : Fragment() {

    private lateinit var binding: FragmentYemeklerListBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentYemeklerListBinding.inflate(inflater, container, false)
        binding.recyclerView.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        fetchData()
        return binding.root
    }

    private fun fetchData() {

        val yemeklerDao = RetrofitClient.instance.create(YemeklerDao::class.java)
        val call = yemeklerDao.getYemekler()

        call.enqueue(object : Callback<YemeklerCevap> {
            override fun onResponse(call: Call<YemeklerCevap>, response: Response<YemeklerCevap>) {
                if (response.isSuccessful) {
                    val yemeklerList = response.body()?.yemekler ?: emptyList()
                    val yemeklerAdapter = YemeklerAdapter(requireContext(), yemeklerList)
                    binding.recyclerView.adapter = yemeklerAdapter
                }
            }

            override fun onFailure(call: Call<YemeklerCevap>, t: Throwable) {
                // Handle failure
            }
        })
    }


}