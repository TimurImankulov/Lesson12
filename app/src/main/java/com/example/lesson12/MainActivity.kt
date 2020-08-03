package com.example.lesson12

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), RecyclerviewListener {

    private var recyclerView: RecyclerView? = null
    val adapter = RecyclerviewAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView()
        setupRecyclerView()
    }

    private fun setupView() {
        recyclerView = findViewById(R.id.recyclerView)
    }

    private fun setupRecyclerView() {
        recyclerView?.adapter = adapter
        adapter.update(getData())
    }

    private fun getData(): ArrayList<DataClass> {
        val list = arrayListOf<DataClass>()

        for (i in 1..10) {
            list.add(DataClass("Name $i", "Phone number $i"))
        }
        return list
    }

    override fun itemClicks(position: Int) {
        adapter.delete(position)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.add -> adapter.add(DataClass("Name", "Phone number"))
            }
        return super.onOptionsItemSelected(item)
    }
}