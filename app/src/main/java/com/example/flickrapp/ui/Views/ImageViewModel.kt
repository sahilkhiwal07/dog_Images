package com.example.flickrapp.ui.Views

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flickrapp.data.Model.InfoDog
import com.example.flickrapp.data.Model.InfoDogItem
import com.example.flickrapp.data.network.LoadInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

const val API_KEY = "018e70ad-32d6-4223-b2b4-6d725549bca7"

class ImageViewModel : ViewModel() {

    private val imageLiveData: MutableLiveData<List<InfoDogItem>> = MutableLiveData()

    fun getAllImages(): LiveData<List<InfoDogItem>> {
        return imageLiveData
    }

    fun makeApiCall(query: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val dogs = LoadInfo.instance.getAllImages(API_KEY, query).body()
            if (dogs != null) {
                this@ImageViewModel.imageLiveData.postValue(dogs)
            }
        }
    }

}