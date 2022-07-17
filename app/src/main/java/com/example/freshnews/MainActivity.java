package com.example.freshnews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity<newsJsonArray> extends AppCompatActivity implements NewsItemClicked {

    JSONArray newsJsonArray = null;
    NewsListAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Acceess RecyclerView
        RecyclerView rv =  (findViewById(R.id.RecyclerView));
        rv.setLayoutManager(new LinearLayoutManager(this));

         fetchData();
         NewsListAdapter mAdapter = new NewsListAdapter(this);
         rv.setAdapter(mAdapter);


    }
    // create a fetch data method here
    private void fetchData() {
        String url = "https://newsapi.org/v2/top-headlines?country=in&apiKey=1f4a12d2698e432ea9cf18126dcc7acd";
        // Request a string response from the provided URL.
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        newsJsonArray = response.getJSONArray("articles");
                        ArrayList<News> newsArray = ArrayList<News>();
                            int i;
                        for(i = 0; i <= newsJsonArray.length(); i++ {
                            String newsJsonObject = ((JSONArray) newsJsonArray).getJSONObject(i);
                           // create instance of News class
                            News news = new News(
                                   ((JSONObject) newsJsonObject).getString("title"),
                            ((JSONObject) newsJsonObject).getString("author"),
                            ((JSONObject) newsJsonObject).getString("url"),
                            ((JSONObject) newsJsonObject).getString("urlToImage")
                           );
                            newsArray.add(news);
                        }
                        mAdapter.updateNews(newsArray);
                    },
                    Response.ErrorListener {

                    }
                    )
                            MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);

                        public void onItemClicked(News item) {

                            customTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                            customTabsIntent customTabsIntent = builder.build();
                            customTabsIntent.launchUrl(this, Uri.parse(item.url));
                        }



        }

    }
}
