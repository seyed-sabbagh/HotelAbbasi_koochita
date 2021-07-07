package com.google.hotelabbasi.PicAlbum;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.hotelabbasi.R;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PicAlbumActivity extends AppCompatActivity {

    public static ImageView ImgAlbumMainA;
    private RecyclerView recyclerView;
    private Adapter adapter;
    private ArrayList<ListItem> listItems;
    private Context context;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic_album);

        ImgAlbumMainA = findViewById(R.id.ImgAlbumMainA);


        recyclerView = findViewById(R.id.RecyclerViewAlbum);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>();
        requestQueue = Volley.newRequestQueue(this);

        String url = "http://185.239.106.26/api/place/getPics/606ddc223f04952c46589811";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray jsonArray = response.getJSONArray("sitePics");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String s = jsonObject.getString("url");

                        listItems.add(new ListItem(s));
                        adapter = new Adapter(PicAlbumActivity.this, listItems);
                        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(context, 4);
                        recyclerView.setLayoutManager(layoutManager);
                        Picasso.get().load(s).fit().centerCrop().into(ImgAlbumMainA);
                        recyclerView.setAdapter(adapter);



                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("AAA", "onErrorResponse: " + error);
            }
        });
        requestQueue.add(request);



    }
}