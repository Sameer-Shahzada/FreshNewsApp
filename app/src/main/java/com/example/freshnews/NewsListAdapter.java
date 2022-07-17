package com.example.freshnews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class NewsListAdapter extends RecyclerView.Adapter<NewsViewHolder> {

    private Object ArrayList;
    // data fields
    private final ArrayList<News> items;

    private final NewsItemClicked listener;
//    private Object viewHolder;

    //    private Object NewsItemClicked = null;
//    Context context;

    // create a constructor to initialize the above items & NewsItemClicked
    NewsListAdapter(ArrayList<News> items , NewsItemClicked listener)
        {
            this.items = items;
            this.listener = listener;

        }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // To convert from xml to view format use Layout Inflater
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news,parent, false);
        // create an instance of NewsViewHolder
        NewsViewHolder viewHolder = new NewsViewHolder(view);
        // handle on click event for view
        // click listener object
        view.setOnClickListener(new View.OnClickListener() {
            // define method here
            @Override
            public void onClick(View view) {
                // code
                listener.onItemClicked(items.get(viewHolder.getAbsoluteAdapterPosition()));
            }
        });

        return viewHolder;
//
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {

        News currentItem = items.get(position);
        holder.textView.setText(currentItem.title);
        holder.textView.setText(currentItem.author);
        Glide.with(holder.itemView.getContext().load(currentItem.imageUrl).into(holder.image));
    }

    public void updateNews(ArrayList<News> updateNews)
    {
        items.clear();
        items.addAll(updateNews);

        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() { return items.size(); }
}

class NewsViewHolder extends RecyclerView.ViewHolder {

    //define data fields here to access findviewby id
    TextView textView;
    ImageView imageView;

    // default constructor
    public NewsViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.image);
        textView = itemView.findViewById(R.id.title);
        textView = itemView.findViewById(R.id.author);
    }

}
// create an interface for NewsItemClicked
interface NewsItemClicked {
    void onItemClicked(News News);
}
