package com.example.arthur.p22_blindwallsapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;

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
        callAPIImage();
    }

    private void callAPIImage(){
        String url = "https://api.blindwalls.gallery/"+item.getImageURL();
        ImageRequest imageRequest = new ImageRequest(
                url, // Image URL
                new Response.Listener<Bitmap>() { // Bitmap listener
                    @Override
                    public void onResponse(Bitmap response) {
                        // Do something with response
                        ImageView image = findViewById(R.id.blindwall_Image);
                        image.setImageBitmap(response);
                    }
                },
                0, // Image width
                0, // Image height
                ImageView.ScaleType.CENTER_CROP, // Image scale type
                Bitmap.Config.RGB_565, //Image decode configuration
                new Response.ErrorListener() { // Error listener
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Do something with error response
                        Log.d("ERROR", "Image Error");
                    }
                }
        );
        MyVolleyRequestQueue.getInstance(this).getRequestQueue().add(imageRequest);
    }
}
