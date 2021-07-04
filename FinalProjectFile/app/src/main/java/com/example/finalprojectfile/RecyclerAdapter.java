package com.example.finalprojectfile;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    String data[];
    Context context;
    int lastPosition = -1;
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
        setAnimation(holder.itemView, position);

    }

    private void setAnimation(View itemView, int position) {
        Context cont = itemView.getContext();
        if(position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(cont, android.R.anim.fade_in);
            itemView.setAnimation(animation);
            lastPosition = position;

        }
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
            //context = itemView.getContext();
            imageview = itemView.findViewById(R.id.customImageView);
            textview = itemView.findViewById(R.id.customTextView);
            this.onNoteListener = onNoteListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onNoteListener.onNoteClick(getAdapterPosition());
            Context cont = v.getContext();
            switch(getAdapterPosition()) {
                case 0:
                    Intent testIntent1 = new Intent(cont, Page_Penang.class);
                    cont.startActivity(testIntent1);
                    break;
                case 1:
                    Intent testIntent2 = new Intent(cont, Page_Johor.class);
                    cont.startActivity(testIntent2);
                    break;
                case 2:
                    Intent testIntent3 = new Intent(cont, Page_Melaka.class);
                    cont.startActivity(testIntent3);
                    break;
                case 3:
                    Intent testIntent4 = new Intent(cont, Page_Negeri_Sembilan.class);
                    cont.startActivity(testIntent4);
                    break;
                case 4:
                    Intent testIntent5 = new Intent(cont, Page_Pahang.class);
                    cont.startActivity(testIntent5);
                    break;
                case 5:
                    Intent testIntent6 = new Intent(cont, Page_Kelantan.class);
                    cont.startActivity(testIntent6);
                    break;
                case 6:
                    Intent testIntent7 = new Intent(cont, Page_Kedah.class);
                    cont.startActivity(testIntent7);
                    break;

            }


        }
    }

    public interface OnNoteListener{
        void onNoteClick(int position);
    }
}
