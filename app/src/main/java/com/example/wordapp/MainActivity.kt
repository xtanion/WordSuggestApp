package com.example.wordapp

import android.app.UiModeManager.MODE_NIGHT_YES
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wordapp.adapter.letterAdapter
import com.example.wordapp.module.letterList
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var isLinearLayoutManager = true

        val recycler_view = findViewById<RecyclerView>(R.id.recycler_view)
        val alphabets = generateAlphabets()

        recycler_view.adapter = letterAdapter(alphabets)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)

        val theme_button = findViewById<ImageView>(R.id.change_theme)
        theme_button.setOnClickListener{
            if (isDarkThemeOn() == "Night") {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                theme_button.setImageResource(R.drawable.ic_baseline_wb_sunny_24)
            }
            else if (isDarkThemeOn() == "Day"){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                theme_button.setImageResource(R.drawable.ic_baseline_bedtime_24)
            }
            else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
                theme_button.setImageResource(R.drawable.ic_baseline_bedtime_24)
            }
        }
    }

    private fun generateAlphabets(): List<letterList> {
        val list = ArrayList<letterList>()

        for (i in 'a'..'z'){
            val append = letterList(i.toString())
            list+= append
        }
        return list
    }
    private fun Context.isDarkThemeOn(): String {
        val theme : String = when{
            resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK == UI_MODE_NIGHT_YES -> "Night"
            resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK == UI_MODE_NIGHT_NO -> "Day"
            else -> "Default"
        }
        return theme
    }
}
