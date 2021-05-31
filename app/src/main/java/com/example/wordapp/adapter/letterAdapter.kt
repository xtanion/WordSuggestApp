package com.example.wordapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wordapp.DetailActivity
import com.example.wordapp.R
import com.example.wordapp.module.letterList

class letterAdapter(private val letter_list: List<letterList>):
    RecyclerView.Adapter<letterAdapter.letterViewHolder>() {

    class letterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val letter_button = itemView.findViewById<TextView>(R.id.letter_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): letterViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.letter,parent,false)
        return letterViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: letterViewHolder, position: Int) {
        val currentItem = letter_list[position]
        holder.letter_button.text = currentItem.letter
        holder.letter_button.setOnClickListener{
            val context = holder.letter_button.context
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("letter",holder.letter_button.text.toString())
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return letter_list.size
    }
}