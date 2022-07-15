package com.example.freshnews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Acceess RecyclerView
        RecyclerView rv =  (findViewById(R.id.RecyclerView));
        rv.setLayoutManager(new LinearLayoutManager(this));

         ArrayList<String> items = fetchData();
//         val adapter: NewsListAdapter = NewsListAdapter(items);
         NewsListAdapter adapter = new NewsListAdapter(items);
//        RecipeAdapter adapter = new RecipeAdapter(list , this);
         rv.setAdapter(adapter);


    }
    private ArrayList<String> fetchData() {
        ArrayList<String> list = new ArrayList<>();

        for(int i = 0; i <= 100; i++) {
            list.add("Item " + i);
        }
        return list;
    }

//--------------------------------------------------------------------//
    //-> Try to implement onItemClick event for items
//    @Override
//    public void onItemClicked(items, Strings){
//
//    }
//
//                override fun void onItemClicked(item : String) {
//        Toast.makeText(this, "clicked item is " + " " + item,Toast.LENGTH_LONG).show();
//    }
}