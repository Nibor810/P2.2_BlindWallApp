package com.example.arthur.p22_blindwallsapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by robin on 9-11-2017.
 */

public class BlindWallAdapter extends ArrayAdapter<BlindWallItem>{

    public BlindWallAdapter(@NonNull Context context, @NonNull List<BlindWallItem> objects) {
        super(context, 0,objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        BlindWallItem item = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.blind_walls_listview_row,parent,false);
        }
        TextView titel = convertView.findViewById(R.id.textViewRow_Titel);
        TextView year = convertView.findViewById(R.id.textViewRow_Year);
        titel.setText(item.getTitel());
        year.setText(String.valueOf(item.getYear()));
        return convertView;
    }
}
