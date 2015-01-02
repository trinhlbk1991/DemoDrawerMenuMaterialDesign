package com.icetea09.demomaterialdesigndrawermenu;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DrawerMenuItemAdapter extends BaseAdapter{

    List<DrawerMenuItem> mItems;
    Context mContext;

    public DrawerMenuItemAdapter(Context context,List<DrawerMenuItem> mItems) {
        this.mItems = mItems;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.layout_drawer_menu_item, null);
        }

        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.img_drawer_menu_item_icon);
        TextView tvTitle = (TextView) convertView.findViewById(R.id.tv_drawer_menu_item_text);

        DrawerMenuItem item = mItems.get(position);

        imgIcon.setImageResource(item.getIcon());
        tvTitle.setText(item.getText());

        return convertView;
    }
}
