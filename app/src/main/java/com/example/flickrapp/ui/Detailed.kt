package com.example.flickrapp.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.flickrapp.R
import com.example.flickrapp.data.Model.InfoDogItem
import kotlinx.android.synthetic.main.detailed_activity.*

class Detailed : AppCompatActivity() {

    private var infoDogItem: InfoDogItem? = null

    companion object {

        private const val DOG = "DOG"

        fun newIntent(context: Context, infoDogItem: InfoDogItem): Intent {
            val intent = Intent(context, Detailed::class.java)
            intent.putExtra(DOG, infoDogItem)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detailed_activity)

        infoDogItem = intent?.getParcelableExtra<InfoDogItem>(DOG)

        setData()

    }

    private fun setData() {
        infoDogItem?.let { dog ->
            dog_breads.text = dog.name
            dog_origin.text = dog.origin
            dog_life_span.text = dog.life_span
            dog_height.text = dog.height?.imperial
            height_metric.text = dog.height?.metric
            dog_weight.text = dog.weight?.imperial
            weight_metric.text = dog.weight?.metric
            dog_temperament.text = dog.temperament
            dog_history.text = dog.history
            dog_description.text = dog.description

            Glide.with(applicationContext)
                .load(dog.image?.url)
                .into(dog_images)
        }

    }

}