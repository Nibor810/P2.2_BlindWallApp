package com.example.arthur.p22_blindwallsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listview;
    private BlindWallAdapter adapter;
    private ArrayList<BlindWallItem> blindWallItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Blind Walls");
        listview = findViewById(R.id.main_listview);
        adapter = new BlindWallAdapter(this,blindWallItems);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(this);
        new BlindWallsList(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        BlindWallItem item = blindWallItems.get(position);
        Intent intent = new Intent(getApplicationContext(),BlindWallDetailActivity.class);
        intent.putExtra("BLIND_WALL_ITEM", item);
    }

    public void loadBlindWallItems(){
        //TODO: Hier moet de bliendwall json worden ingelezen, vervolgens BlindwallItems van worden gemaakt en in de blindwallitems array worden gestopt
    }
}
