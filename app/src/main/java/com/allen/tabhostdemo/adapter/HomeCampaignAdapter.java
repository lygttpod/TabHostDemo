package com.allen.tabhostdemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.allen.tabhostdemo.R;
import com.allen.tabhostdemo.bean.HomeCampaign;

import java.util.List;

/**
 * Created by Allen on 2016/2/2.
 */
public class HomeCampaignAdapter extends RecyclerView.Adapter<HomeCampaignAdapter.ViewHolder> {
    private List<HomeCampaign> homeCampaigns;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item_layout, parent);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(HomeCampaignAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
