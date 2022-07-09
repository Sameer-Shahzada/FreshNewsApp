package com.example.freshnews;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NewsListAdapter(int items, ArrayList<String> listener, NewsItemClicked) extends RecyclerView.Adapter<NewsViewHolder>
{
    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Layout Inflater code
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news,parent, false);
        viewHolder = NewsViewHolder(view);
        view.setOnClickListener() {
            listener.onItemClicked(items[viewHolder.adapterPosition]);
        }
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {

        View currentItem = items.get(position);
        TextView textView = itemView.findViewById(R.id.item_textview);
        holder.textView.text = currentItem;
    }

    @Override
    public int getItemCount() {
//        return 0;
       return items.size();

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
    }
}

interface NewsItemClicked {
    fun onItemClicked(item :String);
}

//------------------------------------------------------------------------------------------//

//
//public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
//
//    private String[] localDataSet;
//
//    /**
//     * Provide a reference to the type of views that you are using
//     * (custom ViewHolder).
//     */
//    public static class ViewHolder extends RecyclerView.ViewHolder {
//        private final TextView textView;
//
//        public ViewHolder(View view) {
//            super(view);
//            // Define click listener for the ViewHolder's View
//
//            textView = (TextView) view.findViewById(R.id.textView);
//        }
//
//        public TextView getTextView() {
//            return textView;
//        }
//    }
//
//    /**
//     * Initialize the dataset of the Adapter.
//     *
//     * @param dataSet String[] containing the data to populate views to be used
//     * by RecyclerView.
//     */
//    public CustomAdapter(String[] dataSet) {
//        localDataSet = dataSet;
//    }
//
//    // Create new views (invoked by the layout manager)
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
//        // Create a new view, which defines the UI of the list item
//        View view = LayoutInflater.from(viewGroup.getContext())
//                .inflate(R.layout.text_row_item, viewGroup, false);
//
//        return new ViewHolder(view);
//    }
//
//    // Replace the contents of a view (invoked by the layout manager)
//    @Override
//    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
//
//        // Get element from your dataset at this position and replace the
//        // contents of the view with that element
//        viewHolder.getTextView().setText(localDataSet[position]);
//    }
//
//    // Return the size of your dataset (invoked by the layout manager)
//    @Override
//    public int getItemCount() {
//        return localDataSet.length;
//    }
//}
