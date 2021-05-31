package com.example.wordapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wordapp.adapter.detailAdapter
import com.example.wordapp.adapter.letterAdapter
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.internal.ToolbarUtils
import java.util.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // setting up back button in toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar_detail)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val letterId = intent?.extras?.getString("letter").toString()
        val headertext = findViewById<CollapsingToolbarLayout>(R.id.toolbarlayout)
        headertext.setTitle("Words from letter ${letterId.uppercase()}")
        Toast.makeText(this, "Selected letter ${letterId.uppercase()}", Toast.LENGTH_SHORT).show()


        val recycler_view2 : RecyclerView = findViewById(R.id.recycler_view2)
        recycler_view2.adapter = detailAdapter(letterId,context = this)
        recycler_view2.layoutManager = LinearLayoutManager(this)
        recycler_view2.setHasFixedSize(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}