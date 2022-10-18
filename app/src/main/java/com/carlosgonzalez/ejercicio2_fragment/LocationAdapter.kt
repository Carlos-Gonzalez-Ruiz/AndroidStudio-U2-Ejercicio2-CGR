package com.carlosgonzalez.ejercicio2_fragment

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.carlosgonzalez.ejercicio2_fragment.databinding.LocationViewBinding

class LocationAdapter(val locations : List<Location>, val onClickListener : (Location) -> Unit) : RecyclerView.Adapter<LocationAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) = ViewHolder(parent.inflate(R.layout.location_view, false))

    override fun onBindViewHolder(holder : ViewHolder, position : Int) {
        val location = locations[position]

        holder.bind(location)
        holder.itemView.setOnClickListener {
            onClickListener(location)
        }
    }

    override fun getItemCount() = locations.size

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        private val binding = LocationViewBinding.bind(view)
        fun bind (location : Location) {
            binding.ivPicture.loadURL(location.urlPicture)
            binding.btnName.text = location.name
        }
    }
}