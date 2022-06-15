package com.example.rick.view.adapter

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.rick.R
import com.example.rick.data.model.CharacterResult
import com.example.rick.databinding.ListItemBinding

class ListAdapter(val context: Context) : RecyclerView.Adapter<ListViewHolder>() {
    private val listCharacter = emptyList<CharacterResult>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.binding.apply {
            tvName.text = listCharacter[position].name
            tvIsAlive.text = listCharacter[position].status
            tvSpecies.text = listCharacter[position].species
            tvOrigin.text = listCharacter[position].origin.name
            tvCreated.text = listCharacter[position].created
            Glide.with(ivCharacter)
                .load(listCharacter[position].image)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(ivCharacter)
            setStatus(ivIndicatorIsAlive, listCharacter[position].status, context)
        }
    }

    override fun getItemCount() = listCharacter.size

    private fun setStatus(imageView: ImageView, status: String, context: Context) {
        if (status == "Alive") {
            imageView.setColorFilter(ContextCompat.getColor(context, R.color.green))
        } else {
            imageView.setColorFilter(ContextCompat.getColor(context, R.color.vermilion))
        }
    }
}

class ListViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)