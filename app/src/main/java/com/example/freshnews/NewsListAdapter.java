package com.example.freshnews;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NewsListAdapter extends RecyclerView.Adapter<NewsViewHolder> {

    private final int items;
    private final ArrayList<String> listener;
    private Object NewsItemClicked = null;

    // create a constructor to initialize the above items, ArrayList & NewsItemClicked
    NewsListAdapter(int items, ArrayList<String> listener , Object NewsItemClicked)
        {
            this.items = items;
            this.listener = listener;
            this.NewsItemClicked = NewsItemClicked;
        }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // To convert from xml to view format use Layout Inflater
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news,parent, false);
        return new NewsViewHolder(view);
//        view.setOnClickListener() {
//            listener.onItemClicked(items[viewHolder.adapterPosition]);
//        }
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {

        int currentItem = items.get(position);
        TextView textView = itemView.findViewById(R.id.item_textview);
        holder.textView.text = currentItem;
    }

    @Override
    public int getItemCount() { return items.size(); }
}

class NewsViewHolder extends RecyclerView.ViewHolder {

    // take default constructor
    public NewsViewHolder(@NonNull View itemView) {
        super(itemView);

        // Define click listener for the ViewHolder's View
        TextView textView;
        textView = (TextView) itemView.findViewById(R.id.item_textview);
    }
//    public TextView getTextView() {
//            return textView;
//    }
}

//interface NewsItemClicked {
//    fun onItemClicked(item :String);
//}
