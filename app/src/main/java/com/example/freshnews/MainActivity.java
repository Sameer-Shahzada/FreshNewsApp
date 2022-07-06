package com.example.freshnews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //        recyclerview.layoutManager = LinearLayoutManager(this); //-> kt code
        // Acceess RecyclerView
        RecyclerView rv =  (findViewById(R.id.RecyclerView));
        rv.setLayoutManager(new LinearLayoutManager(this));

        // val items = fetchData()
        // val adapter: NewsListAdapter = NewsListAdapter(items);
        // recyclerView.adapter = adapter;

        // write above line in java

    }
    private fun fetchdata() {
        val list = ArrayList<String>()
                for(i in 0 until 100) {
                    list.add("Item $i");
        }
        return list;
                }
                override fun onItemClicked(item : String) {
        Toast.makeText(this, "clicked item is " + " " + item,Toast.LENGTH_LONG).show();
    }
}