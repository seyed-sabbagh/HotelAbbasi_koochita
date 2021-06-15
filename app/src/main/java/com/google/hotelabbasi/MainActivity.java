package com.google.hotelabbasi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.gson.Gson;
import com.google.hotelabbasi.jsonschema2pojo.GetRate.PrayTimeClassGetRate;
import com.google.hotelabbasi.jsonschema2pojo.PrayTimeClassGetInfo;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
    ViewPager2 JazebeViewPager;
    ViewPager2 locationViewPager;
    ViewPager2 ResturanViewPager;
    TextView ImgCall;
    ViewPager2 EghamatViewPager;
    Typeface typeface, typeface2;
    ConstraintLayout layout_emtiyaz_karbar, ConstVideo, constraintLayout, cont_list, constraintLayoutImageSlider;
    TextView txtFlot1, txtFlot2, txtflot3, txtflot4, txtFlot5, txtAddress, txtPhonNumber, TxtImageWeb, TxtSupport, txtImgVideoVlip, TxtBag, TxtBookmark, txtImgVideo, Txtstar, Txtstar2, Txtstar3, Txtstar4, Txtstar5, imageView2002, txtHotelTitle, txtDescription, txtSite, accelerate;
    ShimmerFrameLayout shimmerFrameLayoutSliderTop, shimmer_list;
    LinearLayout line1, ImgRateViewOne, ImgRateViewOne2, ImgRateViewTwo, ImgRateViewTwo2, ImgRateViewThree, ImgRateViewThree2, ImgRateViewFoure, ImgRateViewFoure2, ImgRateViewFive, ImgRateViewFive2, shimerLayout_SliderTop, shimmer_layout_list;
    View ViewView;
    ScrollView scrollView;
    RelativeLayout relativeLayout;
    private CardView cardView;
    private RequestQueue mqueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FindViewByID();

        layout_emtiyaz_karbar.setOnClickListener(v -> showBottomSheetDialogEmtiyazKarbar());


        startShimmer();
        jsonParseGetInfo();
        ImageSliderTop();
        jazebeViewPager();
        EghamatViewPager();
        JsonParseGetRate();
        locationViewPager();
        JsonParsgetFeatures();
        ResturanViewPager();
        compositePageTransformer();
        TypeFace();
        ToolbarHide();
        VideoPlayerClickListener();


    }

    private void showBottomSheetDialogEmtiyazKarbar() {
        BottomSheet bottomSheet = new BottomSheet();
        bottomSheet.show(getSupportFragmentManager(), "TAG");
    }

    private void VideoPlayerClickListener() {
        ConstVideo.setOnClickListener(v -> {

            String url = "https://koochitatv.com/video/show/8uU6LhcBap";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void ToolbarHide() {

        scrollView.getViewTreeObserver().addOnScrollChangedListener(() -> {
            int i = (int) ViewView.getY();
            int i2 = scrollView.getScrollY();
//            Log.d("TAG", "onScrollChange: " + i + " " + i2);

            if (scrollView.getScrollY() > ViewView.getY()) {

                relativeLayout.setVisibility(View.VISIBLE);

            }
            if (scrollView.getScrollY() < ViewView.getY()) {
                relativeLayout.setVisibility(View.GONE);
            }
        });


        scrollView.setOnScrollChangeListener((v, scrollX, scrollY, oldScrollX, oldScrollY) -> {
//
//                ConstraintLayout.LayoutParams l = (ConstraintLayout.LayoutParams) constraintLayout.getLayoutParams();
//                l.setMargins(0,90,0,0);
//                constraintLayout.setLayoutParams(l);


            int v1 = scrollView.getScrollX();


//
//                final Handler handler = new Handler();
//                handler.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//
//                    }
//                }, 2000);


        });


    }

    private void JsonParseGetRate() {

        String url = "http://185.239.106.26/api/place/getRates/606ddc223f04952c46589811";

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new JsonHttpResponseHandler() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                Gson gson = new Gson();
                PrayTimeClassGetRate pray = gson.fromJson(response.toString(), PrayTimeClassGetRate.class);

                int JsonOne = pray.get1();
                int JsonTwo = pray.get2();
                int JsonThree = pray.get3();
                int JsonFour = pray.get4();
                int JsonFive = pray.get5();

                int Average = JsonOne + JsonTwo + JsonThree + JsonFour + JsonFive;


//                >>>>>>>>>>>>>>>>>>>>>>>>>>UI Five<<<<<<<<<<<<<<<<<<<<<<<<<<             //
                int FivePercentage = (JsonFive / Average) * 100;
                float b = 100f;
                float c = b - (float) FivePercentage;
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, (float) FivePercentage);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, c);
                ImgRateViewFive.setLayoutParams(layoutParams);
                ImgRateViewFive2.setLayoutParams(layoutParams2);
                txtFlot5.setText(FivePercentage + "%");
//                >>>>>>>>>>>>>>>>>>>>>>>>>>UI Five<<<<<<<<<<<<<<<<<<<<<<<<<<             //
//                >>>>>>>>>>>>>>>>>>>>>>>>>>UI Foue<<<<<<<<<<<<<<<<<<<<<<<<<<             //

                int FourePercentage = (JsonFour / Average) * 100;
                float d = 100f;
                float e = d - (float) FourePercentage;
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, (float) FourePercentage);
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, e);
                ImgRateViewFoure.setLayoutParams(layoutParams3);
                ImgRateViewFoure2.setLayoutParams(layoutParams4);
                txtflot4.setText(FourePercentage + "%");

//                >>>>>>>>>>>>>>>>>>>>>>>>>>UI Foue<<<<<<<<<<<<<<<<<<<<<<<<<<             //
//                >>>>>>>>>>>>>>>>>>>>>>>>>>UI Three<<<<<<<<<<<<<<<<<<<<<<<<<<             //
                int ThreePercentage = (JsonThree / Average) * 100;
                float f = 100f;
                float g = f - (float) ThreePercentage;
                LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, (float) ThreePercentage);
                LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, g);
                ImgRateViewThree.setLayoutParams(layoutParams5);
                ImgRateViewThree2.setLayoutParams(layoutParams6);
                txtflot3.setText(ThreePercentage + "%");
//                >>>>>>>>>>>>>>>>>>>>>>>>>>UI Three<<<<<<<<<<<<<<<<<<<<<<<<<<             //
//                >>>>>>>>>>>>>>>>>>>>>>>>>>UI Two<<<<<<<<<<<<<<<<<<<<<<<<<<             //
                int TwoPercentage = (JsonTwo / Average) * 100;
                float h = 100f;
                float i = h - (float) TwoPercentage;
                LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, (float) TwoPercentage);
                LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, i);
                ImgRateViewTwo.setLayoutParams(layoutParams7);
                ImgRateViewTwo2.setLayoutParams(layoutParams8);
                txtFlot2.setText(TwoPercentage + "%");
//                >>>>>>>>>>>>>>>>>>>>>>>>>>UI Two<<<<<<<<<<<<<<<<<<<<<<<<<<             //
//                >>>>>>>>>>>>>>>>>>>>>>>>>>UI One<<<<<<<<<<<<<<<<<<<<<<<<<<             //
                int OnePercentage = (JsonOne / Average) * 100;
                float j = 100f;
                float k = j - (float) OnePercentage;

                LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, (float) OnePercentage);
                LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, k);
                ImgRateViewOne.setLayoutParams(layoutParams9);
                ImgRateViewOne2.setLayoutParams(layoutParams10);

                txtFlot1.setText(OnePercentage + "%");
//                >>>>>>>>>>>>>>>>>>>>>>>>>>UI One<<<<<<<<<<<<<<<<<<<<<<<<<<             //

            }

        });


    }

    private void FindViewByID() {
        layout_emtiyaz_karbar = findViewById(R.id.layout_emtiyaz_karbar);
        line1 = findViewById(R.id.line3);
        ConstVideo = findViewById(R.id.ConstVideo);
        constraintLayout = findViewById(R.id.accelerate);
        ImgRateViewOne = findViewById(R.id.ImgRateViewOne);
        ImgRateViewOne2 = findViewById(R.id.ImgRateViewOne2);
        txtFlot2 = findViewById(R.id.txtFlot2);
        ImgRateViewTwo = findViewById(R.id.ImgRateViewTwo);
        txtFlot1 = findViewById(R.id.txtFlot1);
        ImgRateViewTwo2 = findViewById(R.id.ImgRateViewTwo2);
        txtflot3 = findViewById(R.id.txtflot3);
        ImgRateViewThree = findViewById(R.id.ImgRateViewThree);
        ImgRateViewThree2 = findViewById(R.id.ImgRateViewThree2);
        txtflot4 = findViewById(R.id.txtflot4);
        ImgRateViewFoure = findViewById(R.id.ImgRateViewFoure);
        ImgRateViewFoure2 = findViewById(R.id.ImgRateViewFoure2);
        txtFlot5 = findViewById(R.id.txtFlot5);
        ImgRateViewFive = findViewById(R.id.ImgRateViewFive);
        ImgRateViewFive2 = findViewById(R.id.ImgRateViewFive2);
        Txtstar = findViewById(R.id.Txtstar);
        TxtImageWeb = findViewById(R.id.TxtImageWeb);
        TxtBag = findViewById(R.id.TxtBag);
        txtPhonNumber = findViewById(R.id.txtPhonNumber);
        txtAddress = findViewById(R.id.txtAddress);
        txtImgVideo = findViewById(R.id.txtImgVideo);
        txtImgVideoVlip = findViewById(R.id.txtImgVideoVlip);
        Txtstar2 = findViewById(R.id.Txtstar2);
        Txtstar3 = findViewById(R.id.Txtstar3);
        TxtBookmark = findViewById(R.id.TxtBookmark);
        Txtstar4 = findViewById(R.id.Txtstar4);
        Txtstar5 = findViewById(R.id.Txtstar5);
        constraintLayoutImageSlider = findViewById(R.id.ConstraintLayout_image_slider_top_mainactivity);
        shimmerFrameLayoutSliderTop = findViewById(R.id.shimmer_view_container);
        shimerLayout_SliderTop = findViewById(R.id.shimmer_layout_SliderTop);
        relativeLayout = findViewById(R.id.rel);
        accelerate = findViewById(R.id.accelerate00);
        cardView = findViewById(R.id.imageVsiew666);
        imageView2002 = findViewById(R.id.TxtLocation);
        ViewView = findViewById(R.id.ViewView);
        TxtSupport = findViewById(R.id.TxtSupport);
        txtHotelTitle = findViewById(R.id.HotelTitle);
        txtDescription = findViewById(R.id.txtDescription);
        txtSite = findViewById(R.id.Site);
        scrollView = findViewById(R.id.scrollViewMainActivity);
        mqueue = Volley.newRequestQueue(this);
        ImgCall = findViewById(R.id.TxtCall2);

    }

    private void TypeFace() {

        typeface = Typeface.createFromAsset(getAssets(), "shazdemosafer.ttf");
        typeface2 = Typeface.createFromAsset(getAssets(), "Shazdemosafer2.ttf");
        accelerate.setTypeface(typeface);
        ImgCall.setTypeface(typeface);
        imageView2002.setTypeface(typeface);
        Txtstar.setTypeface(typeface);
        Txtstar2.setTypeface(typeface);
        TxtBag.setTypeface(typeface);
        Txtstar3.setTypeface(typeface);
        Txtstar4.setTypeface(typeface);
        txtImgVideo.setTypeface(typeface);
        Txtstar5.setTypeface(typeface);
        TxtBookmark.setTypeface(typeface);
        TxtImageWeb.setTypeface(typeface);
        TxtSupport.setTypeface(typeface);
        txtImgVideoVlip.setTypeface(typeface);
    }

    private void Visibility() {
        shimmerFrameLayoutSliderTop.stopShimmer();
        shimmerFrameLayoutSliderTop.setVisibility(View.GONE);

    }

    private void startShimmer() {

        shimmerFrameLayoutSliderTop.startShimmer();


    }

    private void JsonParsgetFeatures() {
        String url = "http://185.239.106.26/api/place/getFeatures/606ddc223f04952c46589811";
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                try {
                    JSONArray allFeatures = response.getJSONArray("allFeatures");

                    for (int i = 0; i < allFeatures.length(); i++) {
                        JSONObject object = allFeatures.getJSONObject(i);

                        String tt2 = object.getString("name");

                        Log.d("TAG", "onSuccess: " + tt2);

                        JSONArray jsonArray = object.getJSONArray("features");
                        for (int j = 0; j < jsonArray.length(); j++) {
                            JSONObject object1 = jsonArray.getJSONObject(j);
                            String tt = object1.getString("type");

                        }


                        for (int j = 0; j < 1; j++) {
                            Typeface typeface = Typeface.createFromAsset(getAssets(), "iransans.ttf");
                            TextView tv = new TextView(MainActivity.this);
                            tv.setText(tt2);
                            tv.setTextSize(20);
                            line1.addView(tv);
                            tv.setTypeface(typeface);
                        }

                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
                Log.d("TAG", "onFailure: " + throwable);
            }
        });

    }

    private void jsonParseGetInfo() {
        String url = "http://185.239.106.26/api/place/getInfo/%D9%87%D8%AA%D9%84_%D8%B9%D8%A8%D8%A7%D8%B3%DB%8C";
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                Gson gson = new Gson();
                PrayTimeClassGetInfo pray = gson.fromJson(response.toString(), PrayTimeClassGetInfo.class);
                String JsontxtPhonNumber = pray.getPhone();
                String JsontxtHotelTitle = pray.getName();
                String JsontxtSite = pray.getSite();
                String JsontxtDescription = pray.getDescription();
                String JsontxtAddress = pray.getAddress();

                txtAddress.setText(JsontxtAddress);
                txtDescription.setText(JsontxtDescription);
                txtPhonNumber.setText(JsontxtPhonNumber);
                txtHotelTitle.setText(JsontxtHotelTitle);
                txtSite.setText(JsontxtSite);
                Visibility();

            }
        });

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
        compositePageTransformer.addTransformer(new MarginPageTransformer(50));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 2 - Math.abs(position);
                page.setScaleY(0.95f + r * 0.05f);
            }
        });

        locationViewPager.setPageTransformer(compositePageTransformer);

        JazebeViewPager.setPageTransformer(compositePageTransformer);

        ResturanViewPager.setPageTransformer(compositePageTransformer);

        EghamatViewPager.setPageTransformer(compositePageTransformer);

    }

    private void locationViewPager() {


        locationViewPager = findViewById(R.id.locationsviewPager);

        List<SliderModelTabiat> sliderModelTabiats = new ArrayList<>();

        SliderModelTabiat sliderModelTabiatMotionView = new SliderModelTabiat();
        sliderModelTabiatMotionView.imageUrl = "https://static.koochita.com/_images/majara/soffe/f-1.jpg";
        sliderModelTabiatMotionView.title = "کوه صفه اسفهان";
        sliderModelTabiatMotionView.location = "اصفهان اصفهان";
        sliderModelTabiatMotionView.starRating = 4.5f;
        sliderModelTabiats.add(sliderModelTabiatMotionView);


        SliderModelTabiat sliderModelTabiatMotionView2 = new SliderModelTabiat();
        sliderModelTabiatMotionView2.imageUrl = "https://static.koochita.com/_images/majara/lader/f-1.jpg";
        sliderModelTabiatMotionView2.title = "چشمه و آبشار لادر";
        sliderModelTabiatMotionView2.location = "خمینی شهر";
        sliderModelTabiatMotionView2.starRating = 4.5f;
        sliderModelTabiats.add(sliderModelTabiatMotionView2);


        SliderModelTabiat sliderModelTabiatMotionView3 = new SliderModelTabiat();
        sliderModelTabiatMotionView3.imageUrl = "https://static.koochita.com/_images/majara/ghare_kolahrod/f-1.jpg";
        sliderModelTabiatMotionView3.title = "غار کلهرود اصفهان";
        sliderModelTabiatMotionView3.location = "شاهین شهر";
        sliderModelTabiatMotionView3.starRating = 4.5f;
        sliderModelTabiats.add(sliderModelTabiatMotionView3);


        locationViewPager.setAdapter(new SliderBoomGardiNazdikAdapter(sliderModelTabiats));


        locationViewPager.setClipToPadding(false);
        locationViewPager.setClipChildren(false);
        locationViewPager.setOffscreenPageLimit(10);
        locationViewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);


    }

    private void ResturanViewPager() {
        ResturanViewPager = findViewById(R.id.locationsviewPager3);
        List<SliderModelResturan> sliderModelResturans = new ArrayList<>();

        SliderModelResturan sliderModelResturan = new SliderModelResturan();
        sliderModelResturan.imageUrl = "https://static.koochita.com/_images/restaurant/res_maral_isfahan/f-1.jpg";
        sliderModelResturan.title = "رستوران مارال";
        sliderModelResturan.location = "اصفهان اصفهان";
        sliderModelResturan.starRating = 4.5f;
        sliderModelResturans.add(sliderModelResturan);


        SliderModelResturan sliderModelResturan2 = new SliderModelResturan();
        sliderModelResturan2.imageUrl = "https://static.koochita.com/_images/restaurant/res_zhik_isfahan/f-1.jpg";
        sliderModelResturan2.title = "رستوران فرنگی ژیک";
        sliderModelResturan2.location = "اصفهان اصفهان";
        sliderModelResturan2.starRating = 4.5f;
        sliderModelResturans.add(sliderModelResturan2);


        SliderModelResturan sliderModelResturan3 = new SliderModelResturan();
        sliderModelResturan3.imageUrl = "https://static.koochita.com/_images/restaurant/res_mr.kotlet_isfahan/f-1.jpg";
        sliderModelResturan3.title = "فست فود آقای کتلت";
        sliderModelResturan3.location = "اصفهان اصفهان";
        sliderModelResturan3.starRating = 4.5f;
        sliderModelResturans.add(sliderModelResturan3);

        ResturanViewPager.setAdapter(new SliderRestaurantsAdapter(sliderModelResturans));


        ResturanViewPager.setClipToPadding(false);
        ResturanViewPager.setClipChildren(false);
        ResturanViewPager.setOffscreenPageLimit(3);
        ResturanViewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);


    }

    private void EghamatViewPager() {
        EghamatViewPager = findViewById(R.id.locationsviewPager4);

        List<SliderModelEghamat> sliderModelEghamats = new ArrayList<>();

        SliderModelEghamat sliderModelEghamat = new SliderModelEghamat();


        sliderModelEghamat.imageUrl = "https://static.koochita.com/_images/hotels/hotel_abbasi/f-5.jpg";
        sliderModelEghamat.title = "هتل عباسی";
        sliderModelEghamat.location = "اصفهان اصفهان";
        sliderModelEghamat.starRating = 4.5f;
        sliderModelEghamats.add(sliderModelEghamat);

        SliderModelEghamat sliderModelEghamat2 = new SliderModelEghamat();

        sliderModelEghamat2.imageUrl = "https://static.koochita.com/_images/hotels/hotel_safir/f-1.jpg";
        sliderModelEghamat2.title = "هتل سفیر";
        sliderModelEghamat2.location = "اصفهان اصفهان";
        sliderModelEghamat2.starRating = 4.5f;
        sliderModelEghamats.add(sliderModelEghamat2);

        SliderModelEghamat sliderModelEghamat3 = new SliderModelEghamat();

        sliderModelEghamat3.imageUrl = "https://static.koochita.com/_images/hotels/hotel_pars/f-1.jpg";
        sliderModelEghamat3.title = "هتل پارس";
        sliderModelEghamat3.location = "اصفهان اصفهان";
        sliderModelEghamat3.starRating = 4.5f;
        sliderModelEghamats.add(sliderModelEghamat3);


        EghamatViewPager.setAdapter(new SliderEghamatAdapter(sliderModelEghamats));


        EghamatViewPager.setClipToPadding(false);
        EghamatViewPager.setClipChildren(false);
        EghamatViewPager.setOffscreenPageLimit(10);
        EghamatViewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

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
