package com.example.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ReadRvAdapter extends RecyclerView.Adapter<ReadRvAdapter.NewsViewHolder> {

    private Context context;
    private List<ReadDataModel> newsItemList;

    public ReadRvAdapter(Context context, List<ReadDataModel> newsItemList) {
        this.context = context;
        this.newsItemList = newsItemList;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.read_rv_row, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        ReadDataModel currentItem = newsItemList.get(position);
        holder.imageView.setImageResource(currentItem.getImage());
        holder.dateView.setText(currentItem.getDate());
    }

    @Override
    public int getItemCount() {
        return newsItemList.size();
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView dateView;

        public NewsViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_read);
            dateView = itemView.findViewById(R.id.tv_read);
        }
    }
}
