package com.cmcc.androidknowledge.mvvm;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cmcc.androidknowledge.R;
import com.cmcc.androidknowledge.databinding.ItemSwordsmanBinding;

import java.util.List;

public class SwordsmanAdapter extends RecyclerView.Adapter<SwordsmanAdapter.SwordsmanViewHolder> {

    private List<Swordsman> mList;
    public SwordsmanAdapter(List<Swordsman> mList){
        this.mList = mList;
    }

    @NonNull
    @Override
    public SwordsmanAdapter.SwordsmanViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemSwordsmanBinding itemSwordsmanBinding = (ItemSwordsmanBinding) DataBindingUtil
                .inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.item_swordsman,viewGroup,false);
        return new SwordsmanViewHolder(itemSwordsmanBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull SwordsmanAdapter.SwordsmanViewHolder viewHolder, int i) {
           Swordsman swordsman = mList.get(i);
           viewHolder.getBinding().setSwordsman(swordsman);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class SwordsmanViewHolder extends RecyclerView.ViewHolder{
        ItemSwordsmanBinding binding;
        public SwordsmanViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = (ItemSwordsmanBinding) binding;
        }

        public ItemSwordsmanBinding getBinding(){
            return binding;
        }
    }
}
