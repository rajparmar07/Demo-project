package com.example.githubdemo.activity.retrofitActivity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.githubdemo.R;
import com.example.githubdemo.activity.retrofitActivity.model.ListModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListDataAdapter extends RecyclerView.Adapter<ListDataAdapter.ListDataViewHolder> {

    private Context context;
    private List<ListModel> dataList;

    public ListDataAdapter(Context context, List<ListModel> dataList){
        this.context = context;
        this.dataList = dataList;
    }
    @NonNull
    @Override
    public ListDataAdapter.ListDataViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        return new ListDataViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull  ListDataAdapter.ListDataViewHolder holder, int position) {
        holder.tvTitleCard.setText(dataList.get(position).getTitle());
        Picasso.get().load(dataList.get(position).getThumbnailUrl()).into(holder.ivListItem);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ListDataViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitleCard;
        ImageView ivListItem;

        public ListDataViewHolder(@NonNull  View itemView) {
            super(itemView);
            tvTitleCard = itemView.findViewById(R.id.tvTitleCard);
            ivListItem = itemView.findViewById(R.id.ivListItem);
        }
    }
}
