package com.farshidabz.squarerepo.util.extension

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView


/**
 * DataBinding adapter extension to set RecyclerView Adapter
 *
 * @param adapter the RecyclerView.Adapter to set adapter.
 *
 * app:adapter should be load into XML layout file
 * */
@BindingAdapter(value = ["app:adapter"])
fun RecyclerView.bindRecyclerViewAdapter(adapter: RecyclerView.Adapter<*>) {
    this.run {
        this.adapter = adapter
    }
}