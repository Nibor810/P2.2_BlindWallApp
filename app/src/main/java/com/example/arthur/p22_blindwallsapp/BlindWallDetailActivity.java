package com.example.arthur.p22_blindwallsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BlindWallDetailActivity extends AppCompatActivity {

    private BlindWallItem item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blind_wall_detail);
        Intent intent = getIntent();
        item = (BlindWallItem) intent.getSerializableExtra("BLIND_WALL_ITEM");
        TextView titel = findViewById(R.id.textView_Titel);
        TextView description = findViewById(R.id.textView_Description);
        titel.setText(item.getTitel());
        description.setText(item.getDescriptionEN());
    }
}
