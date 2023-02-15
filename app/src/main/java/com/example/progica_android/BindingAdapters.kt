package com.example.progica_android

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.progica_android.network.Gite
import com.example.progica_android.ui.GiteApiStatus
import com.example.progica_android.ui.GiteListAdapter

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView,data:List<Gite>?){
    val adapter = recyclerView.adapter as GiteListAdapter
    adapter.submitList(data)

}

@BindingAdapter("apiStatus")
fun bindStatus(statusImageView: ImageView, status: GiteApiStatus?) {

    when(status) {
        GiteApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            println("status LOADING")

        }
        GiteApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
            println("status DONE")
        }
        GiteApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            println("status ERROR")

        }
        else -> {}
    }
}