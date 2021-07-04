package com.example.finalprojectfile;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Recommendations1Adapter extends RecyclerView.Adapter<Recommendations1Adapter.RecViewHolder> {

    private final int limit = 3;
    private ArrayList<RecommendationsItem> mRecList;

    public static class RecViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImageView1;
        public TextView mTextView1;

        public RecViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView1 = itemView.findViewById(R.id.customCardImageView);
            mTextView1 = itemView.findViewById(R.id.customCardTextView);
        }

        public void bind(final RecommendationsItem recommendationsItem){

            mTextView1.setText(recommendationsItem.getmText1());
            mImageView1.setImageResource(recommendationsItem.getmImageResource());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*
                    if(listener != null){
                        int position = getAdapterPosition();
                        //String name = mSearchListFull.get(position).getmText1();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }*/

                    Context context = itemView.getContext();
                    Intent intent = new Intent(context, recommendationsItem.getmLaunchClass());
                    context.startActivity(intent);
                }
            });
        }
    }

    public Recommendations1Adapter(ArrayList<RecommendationsItem> recommendationsItemArrayList){
        mRecList = recommendationsItemArrayList;
    }

    @NonNull
    @Override
    public RecViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_recommendcardlayout, parent, false);
        RecViewHolder rvh = new RecViewHolder(v);
        return rvh;
    }

    @Override
    public void onBindViewHolder(@NonNull  Recommendations1Adapter.RecViewHolder holder, int position) {
        RecommendationsItem currentItem = mRecList.get(position);

        //holder.mImageView1.setImageResource(currentItem.getmImageResource());
        //holder.mTextView1.setText(currentItem.getmText1());
        holder.bind(currentItem);
    }

    @Override
    public int getItemCount() {
        if(mRecList.size()>limit){
            return limit;
        }
        else
            return mRecList.size();
    }
}
