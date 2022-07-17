package com.example.freshnews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NewsItemClicked {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Acceess RecyclerView
        RecyclerView rv =  (findViewById(R.id.RecyclerView));
        rv.setLayoutManager(new LinearLayoutManager(this));

         ArrayList<String> items = fetchData();
         NewsListAdapter adapter = new NewsListAdapter(items,this);
         rv.setAdapter(adapter);


    }
    private ArrayList<String> fetchData() {
        ArrayList<String> list = new ArrayList<>();

        for(int i = 0; i <= 100; i++) {
            list.add("Item " + i);
        }
        return list;
    }

    @Override
    public void onItemClicked(String item) {
        Toast.makeText(this,"Clicked " + item,Toast.LENGTH_LONG).show();
    }

//    @Override
//    public void onPointerCaptureChanged(boolean hasCapture) {
//
//    }

}