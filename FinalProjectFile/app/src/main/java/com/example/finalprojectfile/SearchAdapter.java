package com.example.finalprojectfile;

import android.content.Context;
import android.content.Intent;
import android.net.sip.SipSession;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> implements Filterable {
    private ArrayList<SearchItem> mSearchList;
    public ArrayList<SearchItem> mSearchListFull;

    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public static class SearchViewHolder extends RecyclerView.ViewHolder{

        public ImageView mImageView;
        public TextView mTextView;

        public SearchViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            //Context = itemView.getContext();
            mImageView = itemView.findViewById(R.id.customCardImageView);
            mTextView = itemView.findViewById(R.id.customCardTextView);

        }

        public void bind(final SearchItem searchItem){

            mTextView.setText(searchItem.getmText1());
            mImageView.setImageResource(searchItem.getmImageResource());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Context context = itemView.getContext();
                    Intent intent = new Intent(context, searchItem.getmLaunchClass());
                    context.startActivity(intent);
                }
            });
        }
    }

    public SearchAdapter(Context context, ArrayList<SearchItem> searchlist){
        mSearchList = searchlist;
        mSearchListFull = new ArrayList<>(searchlist);
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_recommendcardlayout, parent, false);
        SearchViewHolder svh = new SearchViewHolder(v, mListener);
        return svh;
    }

    @Override
    public void onBindViewHolder(@NonNull  SearchAdapter.SearchViewHolder holder, int position) {
        final SearchItem currentItem = mSearchList.get(position);

        holder.bind(currentItem);
    }

    @Override
    public int getItemCount() {
        return mSearchList.size();
    }

    @Override
    public Filter getFilter() {
        return searchFilter;
    }

    private Filter searchFilter= new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<SearchItem> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(mSearchListFull);//
            }
            else{
                String filterPattern = constraint.toString().toLowerCase().trim();

                for(SearchItem item : mSearchListFull){
                    if(item.getmText1().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);//
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;

        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mSearchList.clear();
            mSearchList.addAll((List) results.values);
            notifyDataSetChanged();
        }

    };
}
