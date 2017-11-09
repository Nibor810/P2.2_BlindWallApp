package com.example.arthur.p22_blindwallsapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by robin on 9-11-2017.
 */

public class BlindWallAdapter extends ArrayAdapter<BlindWallItem>{

    public BlindWallAdapter(@NonNull Context context, @NonNull List<BlindWallItem> objects) {
        super(context, 0,objects);
    }
}
