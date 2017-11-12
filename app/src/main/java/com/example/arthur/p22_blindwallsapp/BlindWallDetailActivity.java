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

import java.util.Locale;

public class BlindWallDetailActivity extends AppCompatActivity {

    private BlindWallItem item;
    TextView description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blind_wall_detail);
        Intent intent = getIntent();
        item = (BlindWallItem) intent.getSerializableExtra("BLIND_WALL_ITEM");
        TextView titel = findViewById(R.id.textView_Titel);
        description = findViewById(R.id.textView_Description);
        titel.setText(item.getTitel());
        setTextToRightLanguage();
        callAPIImage();
    }

    private void setTextToRightLanguage(){
        String language = getResources().getConfiguration().locale.getLanguage();
        if(language.equals("en"))
            description.setText(item.getDescriptionEN());
        else if(language.equals("nl"))
            description.setText(item.getDescriptionNL());
        else
            description.setText(item.getDescriptionEN());
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
