package com.example.freshnews;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NewsListAdapter(private int items = ArrayList<String>,private val listener: NewsItemClicked) extends RecyclerView.Adapter<NewsViewHolder> {
    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news,parent, false);
        viewHolder = NewsViewHolder(view);
        view.setOnClickListener() {
            listener.onItemClicked(items[viewHolder.adapterPosition]);
        }
        return NewsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        int currentItem = items[position];
        TextView textView = itemView.findViewById(R.id.item_textview);
        holder.textView.text = currentItem;
    }

    @Override
    public int getItemCount() {
//        return 0;
       return items.size;
    }
}
class NewsViewHolder extends RecyclerView.ViewHolder {

    public NewsViewHolder(@NonNull View itemView) {
        super(itemView);

        TextView textView = itemView.findViewById(R.id.item_textview);

    }
}
interface NewsItemClicked {
    fun onItemClicked(item :String);
}