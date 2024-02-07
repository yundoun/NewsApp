package com.example.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FirstRvAdapter extends RecyclerView.Adapter<FirstRvAdapter.MyViewHolder> {

    Context context;

    ArrayList<FirstDataModel> firstDataModels;

    public FirstRvAdapter(Context context, ArrayList<FirstDataModel> dataModels){
        this.context = context;
        this.firstDataModels = dataModels;
    }

    public FirstRvAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 레이아웃 인플레이터를 사용하여 rv_row.xml 레이아웃을 뷰로 변환합니다.
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.first_rv_row, parent, false);

        // 생성된 뷰를 사용하여 MyViewHolder 객체를 생성하고 반환합니다.
        return new FirstRvAdapter.MyViewHolder(view);
    }

    public void onBindViewHolder(@NonNull FirstRvAdapter.MyViewHolder holder, int position) {
        // 현재 위치의 DataModel 객체를 가져와서, 텍스트와 이미지를 뷰 홀더의 뷰에 설정합니다.
        holder.tvTitle.setText(firstDataModels.get(position).getTitle());
    }
    public int getItemCount() {
        return firstDataModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
        }
    }

}
