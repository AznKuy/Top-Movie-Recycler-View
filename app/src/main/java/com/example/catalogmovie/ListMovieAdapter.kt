package com.example.catalogmovie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListMovieAdapter(private val listMovie: ArrayList<Movie>) :
    RecyclerView.Adapter<ListMovieAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_movie, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listMovie.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (title, year, rate, duration, description, cover) = listMovie[position]
        holder.imgMovie.setImageResource(cover)
        holder.tvTitle.text = title
        holder.tvYear.text = year
        holder.tvRate.text = rate
        holder.tvDuration.text = duration
//        holder.tvDescription.text = description
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgMovie: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvTitle: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvYear: TextView = itemView.findViewById(R.id.tv_year)
        val tvRate: TextView = itemView.findViewById(R.id.tv_rate)
        var tvDuration: TextView = itemView.findViewById(R.id.tv_duration)
//        val tvDescription: TextView = itemView.findViewById(R.id.tv_description)


    }
}