package com.carlosgonzalez.ejercicio2_fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide

/* Abstracción / Extensión para cargar imágenes con Glide. */
fun ImageView.loadURL(url : String) {
    Glide
        .with(this)
        .load(url)
        .into(this)
}

/* Abstracción / Extensión para inflar la vista en ContactsAdapter */
fun ViewGroup.inflate(layout : Int, attach : Boolean) = LayoutInflater
    .from(context)
    .inflate(   layout,
        this,
        attach
    )