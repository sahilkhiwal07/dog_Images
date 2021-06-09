package com.example.flickrapp.ui.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.flickrapp.R
import com.example.flickrapp.data.Model.InfoDogItem

class ImageAdapter(
    private val context: Context,
    private val myClick: MyClick
) :
    ListAdapter<InfoDogItem, ImageAdapter.ImageHolder>(DIFF_ITEM_CALLBACK) {

    companion object {
        val DIFF_ITEM_CALLBACK = object : DiffUtil.ItemCallback<InfoDogItem>() {
            override fun areItemsTheSame(oldItem: InfoDogItem, newItem: InfoDogItem): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: InfoDogItem, newItem: InfoDogItem): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item, parent, false)
        return ImageHolder(view)
    }

    override fun onBindViewHolder(holder: ImageHolder, position: Int) {

        getItem(position)?.let { data ->

            holder.bind(data)

            holder.singleItem.setOnClickListener {
                myClick.myCLickListener(data)
            }
        }
    }

    class ImageHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val images: AppCompatImageView = itemView.findViewById(R.id.dog_image)
        private val name: AppCompatTextView = itemView.findViewById(R.id.dog_bread)
        val singleItem: CardView = itemView.findViewById(R.id.cardView)

        fun bind(infoDogItem: InfoDogItem) {
            name.text = infoDogItem.name
            Glide.with(itemView.context)
                .load(infoDogItem.image?.url)
                .into(images)
        }
    }

    interface MyClick {
        fun myCLickListener(infoDogItem: InfoDogItem)
    }

}