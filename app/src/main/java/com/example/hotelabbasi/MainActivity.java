package com.example.hotelabbasi;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager2 JazebeViewPager;
    ViewPager2 locationViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageSliderTop();
        jazebeViewPager();
        locationViewPager();
        compositePageTransformer();


    }

    private void ImageSliderTop() {
        ImageSlider imageSlider = findViewById(R.id.image_slider);

        List<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel("https://static.koochita.com/_images/hotels/hotel_abbasi/s-1.jpg"));
        slideModels.add(new SlideModel("https://static.koochita.com/_images/hotels/hotel_abbasi/s-5.jpg"));
        slideModels.add(new SlideModel("https://static.koochita.com/_images/hotels/hotel_abbasi/s-2.jpg"));
        slideModels.add(new SlideModel("https://static.koochita.com/_images/hotels/hotel_abbasi/s-1.jpg"));

        imageSlider.startSliding(3000);
        imageSlider.setImageList(slideModels, false);
    }

    private void compositePageTransformer() {
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

        JazebeViewPager.setPageTransformer(compositePageTransformer);


    }

    private void locationViewPager() {


        locationViewPager = findViewById(R.id.locationsviewPager);

        List<SliderModel> sliderModels = new ArrayList<>();

        SliderModel sliderModelMotionView = new SliderModel();
        sliderModelMotionView.imageUrl = "https://static.koochita.com/_images/majara/soffe/f-1.jpg";
        sliderModelMotionView.title = "کوه صفه اسفهان";
        sliderModelMotionView.location = "اصفهان اصفهان";
        sliderModelMotionView.starRating = 4.5f;
        sliderModels.add(sliderModelMotionView);


        SliderModel sliderModelMotionView2 = new SliderModel();
        sliderModelMotionView2.imageUrl = "https://static.koochita.com/_images/majara/lader/f-1.jpg";
        sliderModelMotionView2.title = "چشمه و آبشار لادر";
        sliderModelMotionView2.location = "خمینی شهر";
        sliderModelMotionView2.starRating = 4.5f;
        sliderModels.add(sliderModelMotionView2);


        SliderModel sliderModelMotionView3 = new SliderModel();
        sliderModelMotionView3.imageUrl = "https://static.koochita.com/_images/majara/ghare_kolahrod/f-1.jpg";
        sliderModelMotionView3.title = "غار کلهرود اصفهان";
        sliderModelMotionView3.location = "شاهین شهر";
        sliderModelMotionView3.starRating = 4.5f;
        sliderModels.add(sliderModelMotionView3);


        locationViewPager.setAdapter(new SliderBoomGardiNazdikAdapter(sliderModels));


        locationViewPager.setClipToPadding(false);
        locationViewPager.setClipChildren(false);
        locationViewPager.setOffscreenPageLimit(10);
        locationViewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);


    }

    private void jazebeViewPager() {


        JazebeViewPager = findViewById(R.id.locationsviewPager2);
        List<SliderModelJazebe> sliderModelJazebes = new ArrayList<>();


        SliderModelJazebe sliderModelJazebe = new SliderModelJazebe();
        sliderModelJazebe.imageUrl = "https://static.koochita.com/_images/amaken/chahar_bagh_school/f-1.jpg";
        sliderModelJazebe.title = "مدرسه چهارباغ";
        sliderModelJazebe.location = "اصفهان اصفهان";
        sliderModelJazebe.starRating = 4.5f;
        sliderModelJazebes.add(sliderModelJazebe);

        SliderModelJazebe sliderModelJazebe2 = new SliderModelJazebe();
        sliderModelJazebe2.imageUrl = "https://static.koochita.com/_images/amaken/honar_bazar/f-1.jpg";
        sliderModelJazebe2.title = "بازار هنر";
        sliderModelJazebe2.location = "اصفهان اصفهان";
        sliderModelJazebe2.starRating = 4.5f;
        sliderModelJazebes.add(sliderModelJazebe2);

        SliderModelJazebe sliderModelJazebe3 = new SliderModelJazebe();
        sliderModelJazebe3.imageUrl = "https://static.koochita.com/_images/amaken/chehelsotun/f-1.jpg";
        sliderModelJazebe3.title = "کاخ چهل ستون";
        sliderModelJazebe3.location = "اصفهان اصفهان";
        sliderModelJazebe3.starRating = 4.5f;
        sliderModelJazebes.add(sliderModelJazebe3);

        JazebeViewPager.setAdapter(new SliderJazebeAdapter(sliderModelJazebes));


        JazebeViewPager.setClipToPadding(false);
        JazebeViewPager.setClipChildren(false);
        JazebeViewPager.setOffscreenPageLimit(3);
        JazebeViewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

    }
}
