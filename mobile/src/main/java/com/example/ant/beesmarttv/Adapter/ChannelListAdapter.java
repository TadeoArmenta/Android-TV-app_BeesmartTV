package com.example.ant.beesmarttv.Adapter;

import android.animation.LayoutTransition;
import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ant.beesmarttv.R;
import com.example.ant.beesmarttv.common.Common;
import com.example.ant.beesmarttv.model.Channel;

import java.util.ArrayList;

/**
 * Created by ant on 9/23/15.
 */
public class ChannelListAdapter extends RecyclerView.Adapter<ChannelListAdapter.CustomChannelViewHolder> {

    Activity mActivity;
    ArrayList<Channel> dataList;
    LayoutInflater inflater = null;
    int selectedIndex = -1;

    public ChannelListAdapter(Activity activity, ArrayList<Channel> list)   {

        mActivity = activity;
        dataList = list;
        selectedIndex = 0;
    }

    public void setSelectedIndex(int index)  {
        selectedIndex = index;
    }

    @Override
    public CustomChannelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_channel_list_cell, parent, false);
        CustomChannelViewHolder viewHolder = new CustomChannelViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomChannelViewHolder holder, int position) {
        Channel channel = dataList.get(position);
        holder.name.setText(channel.channel_name);
        holder.icon.setImageResource(channel.channel_icon);

        if (selectedIndex == position)  {
            holder.background.setBackgroundResource(R.drawable.custom_selected_back);
        }
        else    {
            holder.background.setBackground(null);
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class CustomChannelViewHolder extends RecyclerView.ViewHolder   {

        public TextView name;
        public ImageView icon;
        public RelativeLayout background;

        public CustomChannelViewHolder(View view)  {

            super(view);
            name = (TextView)view.findViewById(R.id.channel_name);
            icon = (ImageView)view.findViewById(R.id.channel_icon);
            background = (RelativeLayout)view.findViewById(R.id.background);
        }
    }
}