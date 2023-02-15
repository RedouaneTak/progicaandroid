package com.example.progica_android.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.progica_android.databinding.ListViewItemBinding
import com.example.progica_android.network.Gite

class GiteListAdapter(val clickListener: GiteListener) :
    ListAdapter<Gite, GiteListAdapter.GiteViewHolder>(DiffCallback) {

    class GiteViewHolder(
        var binding: ListViewItemBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(clickListener: GiteListener, gite: Gite) {
            binding.gite = gite
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Gite>() {
        override fun areItemsTheSame(oldItem: Gite, newItem: Gite): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Gite, newItem: Gite): Boolean {
            return oldItem.nomGite == newItem.nomGite
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GiteListAdapter.GiteViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return GiteListAdapter.GiteViewHolder(
            ListViewItemBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: GiteViewHolder, position: Int) {
        val amphibian = getItem(position)
        holder.bind(clickListener, amphibian)
    }
}

class GiteListener(val clickListener: (gite: Gite) -> Unit) {
    fun onClick(gite: Gite) = clickListener(gite)
}