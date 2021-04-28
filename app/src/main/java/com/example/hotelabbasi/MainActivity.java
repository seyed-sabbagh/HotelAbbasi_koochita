package com.example.hotelabbasi;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ViewPager2 locationViewPager = findViewById(R.id.locationsviewPager);

        List<SliderModel> sliderModels = new ArrayList<>();

        SliderModel sliderModelMotionView = new SliderModel();
        sliderModelMotionView.imageUrl = "https://images.unsplash.com/photo-1511739001486-6bfe10ce785f?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=334&q=80";
        sliderModelMotionView.title = "آموزش واویشکا";
        sliderModelMotionView.location = " ۱۴ روز پیش";
        sliderModelMotionView.starRating = 4.5f;
        sliderModels.add(sliderModelMotionView);


        SliderModel sliderModelMotionView2 = new SliderModel();
        sliderModelMotionView2.imageUrl = "https://images.unsplash.com/photo-1511739001486-6bfe10ce785f?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=334&q=80";
        sliderModelMotionView2.title = "آموزش واویشکا";
        sliderModelMotionView2.location = "۱۴ روز پیش";
        sliderModelMotionView2.starRating = 4.5f;
        sliderModels.add(sliderModelMotionView2);


        SliderModel sliderModelMotionView3 = new SliderModel();
        sliderModelMotionView3.imageUrl = "https://images.unsplash.com/photo-1511739001486-6bfe10ce785f?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=334&q=80";
        sliderModelMotionView3.title = "آموزش واویشکا";
        sliderModelMotionView3.location = "۱۴ روز پیش";
        sliderModelMotionView3.starRating = 4.5f;
        sliderModels.add(sliderModelMotionView3);


        SliderModel sliderModelMotionView4 = new SliderModel();
        sliderModelMotionView4.imageUrl = "https://images.unsplash.com/photo-1511739001486-6bfe10ce785f?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=334&q=80";
        sliderModelMotionView4.title = "آموزش واویشکا";
        sliderModelMotionView4.location = "۱۴ روز پیش";
        sliderModelMotionView4.starRating = 4.5f;
        sliderModels.add(sliderModelMotionView4);


        locationViewPager.setAdapter(new SliderBoomGardiNazdikAdapter(sliderModels));


        locationViewPager.setClipToPadding(false);
        locationViewPager.setClipChildren(false);
        locationViewPager.setOffscreenPageLimit(3);
        locationViewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);


        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(20));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.95f + r * 0.05f);
            }
        });

        locationViewPager.setPageTransformer(compositePageTransformer);

    }
    }
