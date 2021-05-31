package com.example.wordapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wordapp.R

class detailAdapter(private val letterId: String,context:Context) :
    RecyclerView.Adapter<detailAdapter.detailViewHolder>() {
    private val wordlist: List<String>

    init {
        // Retrieve the list of words from res/values/arrays.xml
        val words = context.resources.getStringArray(R.array.words).toList()
        wordlist = words
            // Returns items in a collection if the conditional clause is true,
            // in this case if an item starts with the given letter,
            // ignoring UPPERCASE or lowercase.
            .filter { it.startsWith(letterId, ignoreCase = true) }
            // Returns a collection that it has shuffled in place
            .shuffled()
            // Returns the first n items as a [List]
            .take(5)
            // Returns a sorted version of that [List]
            .sorted()
    }
    class detailViewHolder(view:View):RecyclerView.ViewHolder(view){
        val letter_button = view.findViewById<TextView>(R.id.letter_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): detailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.letter,parent,false)
        return detailViewHolder(view)
    }

    override fun onBindViewHolder(holder: detailViewHolder, position: Int) {
        val currentItem = wordlist[position]
        holder.letter_button.text = currentItem
    }

    override fun getItemCount(): Int{
        return wordlist.size
    }
}