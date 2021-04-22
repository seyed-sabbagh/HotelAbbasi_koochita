package com.example.hotelabbasi;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/*

        //////////////////////////////////////////////ScrollClick//////////////////////////////////////////////
            ScrollView scrollView;
             ImageView img_logo_koochita;

        img_logo_koochita = findViewById(R.id.img_logo_koochita);

        img_logo_koochita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollView = findViewById(R.id.scrollViewMainActivity);
                scrollView.scrollTo(0, R.id.include);
            }
        });


        //////////////////////////////////////////////ScrollClick//////////////////////////////////////////////
*/


//////////////////////////////////////////////Slider//////////////////////////////////////////////
        ImageSlider imageSlider = findViewById(R.id.image_slider);

        List<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel("https://static.koochita.com/_images/hotels/hotel_abbasi/s-1.jpg"));
        slideModels.add(new SlideModel("https://static.koochita.com/_images/hotels/hotel_abbasi/s-5.jpg"));
        slideModels.add(new SlideModel("https://static.koochita.com/_images/hotels/hotel_abbasi/s-2.jpg"));
        slideModels.add(new SlideModel("https://static.koochita.com/_images/hotels/hotel_abbasi/s-1.jpg"));

        imageSlider.startSliding(3000);
        imageSlider.setImageList(slideModels, false);

//////////////////////////////////////////////Slider//////////////////////////////////////////////

    }
}