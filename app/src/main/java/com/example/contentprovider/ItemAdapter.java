package com.example.contentprovider;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ItemAdapter extends BaseAdapter {
    private Activity activity;
    private List<Item> itemList;

    public ItemAdapter(Activity activity, List<Item> itemList) {
        this.activity = activity;
        this.itemList = itemList;
    }

    @Override

    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = activity.getLayoutInflater();
        view = inflater.inflate(R.layout.activity_item,null);
        TextView nameTVAX = view.findViewById(R.id.nameTV);
        TextView phoneTVAX = view.findViewById(R.id.phoneTV);
        Item item = itemList.get(i);
        nameTVAX.setText(item.getTen());
        phoneTVAX.setText(item.getSoDT());
        return view;
    }
}
