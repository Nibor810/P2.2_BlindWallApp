package com.example.arthur.p22_blindwallsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listview;
    private BlindWallAdapter adapter;
    private ArrayList<BlindWallItem> blindWallItems = new ArrayList<>();
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Blind Walls");
        requestQueue = Volley.newRequestQueue(MainActivity.this);
        //loadBlindWallItems();
        callBlindWallAPI();
        listview = findViewById(R.id.main_listview);
        adapter = new BlindWallAdapter(this,blindWallItems);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        BlindWallItem item = blindWallItems.get(position);
        Intent intent = new Intent(getApplicationContext(),BlindWallDetailActivity.class);
        intent.putExtra("BLIND_WALL_ITEM", item);
        startActivity(intent);
    }

//    public void callBlindWallAPI(){
//        String url = "https://api.blindwalls.gallery/apiv2/murals";
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
//
//            @Override
//            public void onResponse(JSONArray response) {
//                loadJsonArray(response);
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.d("API_CALL_ERROR", "API CALL ERROR");
//            }
//        });
//        requestQueue.add(jsonArrayRequest);
//    }

    public void callBlindWallAPI(){
        String url = "https://api.blindwalls.gallery/apiv2/murals";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        loadJsonArray(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("API_CALL_ERROR", "API CALL ERROR");
            }
        });


        requestQueue.add(stringRequest);
    }

    public void loadJsonArray(String array){
        JSONObject jsonWall;
        JSONArray jsonWalls;
        try {
            jsonWalls = new JSONArray(array);
            int length = jsonWalls.length();
            for(int i = 0; i < length;i++){
                jsonWall =jsonWalls.getJSONObject(i);
                BlindWallItem blindWallItem = new BlindWallItem(jsonWall);
                blindWallItems.add(blindWallItem);
            }
            adapter.notifyDataSetChanged();
        } catch (JSONException e){
            e.printStackTrace();
        }
    }

    public void loadBlindWallItems(){
        //TODO: Hier moet de bliendwall json worden ingelezen, vervolgens BlindwallItems van worden gemaakt en in de blindwallitems array worden gestopt
        blindWallItems.add(new BlindWallItem(1,"Titel 1","Autheur 1",2016,"DummyDescription 1"));
        blindWallItems.add(new BlindWallItem(2,"Titel 2","Autheur 2",2017,"DummyDescription 2"));
        blindWallItems.add(new BlindWallItem(3,"Titel 3","Autheur 3",2015,"DummyDescription 3"));
        blindWallItems.add(new BlindWallItem(4,"Titel 4","Autheur 4",2014,"DummyDescription 4"));
//        String json = loadJson();
//        JSONArray jsonWalls;
//        JSONObject jsonWall;
//        try {
//            jsonWalls = new JSONArray(json);
//            for(int i = 0; i < jsonWalls.length();i++){
//                jsonWall =jsonWalls.getJSONObject(i);
//                BlindWallItem blindWallItem = new BlindWallItem(jsonWall);
//                blindWallItems.add(blindWallItem);
//            }
//        } catch (JSONException e){
//            e.printStackTrace();
//        }
    }

    public String loadJson(){
        String json = null;
        try {
            InputStream is = this.getAssets().open("walls.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer,"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

}
