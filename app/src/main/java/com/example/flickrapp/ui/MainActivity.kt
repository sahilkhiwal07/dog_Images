package com.example.flickrapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flickrapp.R
import com.example.flickrapp.data.Model.InfoDogItem
import com.example.flickrapp.ui.Adapters.ImageAdapter
import com.example.flickrapp.ui.Views.ImageViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ImageAdapter.MyClick {

    private val adapter: ImageAdapter by lazy {
        ImageAdapter(applicationContext, this)
    }

    private val imageViewModel: ImageViewModel by lazy {
        ViewModelProvider(this).get(ImageViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setRecyclerView()
        initViewModel()
//        searchItem()

    }

//    private fun searchItem() {
//        search_bar.setOnQueryTextListener(object :
//            androidx.appcompat.widget.SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                return false
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                imageViewModel.makeApiCall(newText.toString())
//                return true
//            }
//        })
//    }

    private fun initViewModel() {
        imageViewModel.getAllImages().observe(this, {
            adapter.submitList(it)
        })

        imageViewModel.makeApiCall("pitbull")

    }

    private fun setRecyclerView() {
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun myCLickListener(infoDogItem: InfoDogItem) {
        startActivity(Detailed.newIntent(applicationContext, infoDogItem))
    }

}

