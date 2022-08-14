package com.example.contactkeeping;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.NewsViewHolder>
{

    private Context context;
    private List<Contact> newsList;

    public ContactAdapter(Context context,List<Contact> newsList) {
        this.context = context;
        this.newsList = newsList;

    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflate = LayoutInflater.from(context);
        View view = inflate.inflate(R.layout.single_item,null);
        NewsViewHolder holder = new NewsViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        Contact model = newsList.get(position);
        holder.NameTextView.setText(model.getName());
        holder.NumberTextView.setText(model.getNumber());
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    class NewsViewHolder extends RecyclerView.ViewHolder
    {

        TextView NameTextView,NumberTextView;
        NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            NameTextView = itemView.findViewById(R.id.txtvw_name);
            NumberTextView = itemView.findViewById(R.id.txtvw_num);

        }
    }

}

