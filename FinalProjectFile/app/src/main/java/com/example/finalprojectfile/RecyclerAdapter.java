package com.example.finalprojectfile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    String data[];
    Context context;
    ArrayList<FeaturedHelperClass> featuredLocations;

    private OnNoteListener mOnNoteListener;

    public RecyclerAdapter(ArrayList<FeaturedHelperClass> featuredLocations, OnNoteListener onNoteListener)
    {
        this.featuredLocations = featuredLocations;
        this.mOnNoteListener = onNoteListener;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_cardlayout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view, mOnNoteListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        FeaturedHelperClass featuredHelperClass = featuredLocations.get(position);

        holder.imageview.setImageResource(featuredHelperClass.getImage());
        holder.textview.setText(featuredHelperClass.getStatenames());

    }

    @Override
    public int getItemCount() {
        return featuredLocations.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView textview;
        ImageView imageview;
        OnNoteListener onNoteListener;

        public ViewHolder(@NonNull View itemView, OnNoteListener onNoteListener) {
            super(itemView);
            imageview = itemView.findViewById(R.id.customImageView);
            textview = itemView.findViewById(R.id.customTextView);
            this.onNoteListener = onNoteListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onNoteListener.onNoteClick(getAdapterPosition());

        }
    }

    public interface OnNoteListener{
        void onNoteClick(int position);
    }
}
