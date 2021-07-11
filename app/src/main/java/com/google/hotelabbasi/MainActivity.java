package com.google.hotelabbasi;import android.content.ClipData;import android.content.ClipboardManager;import android.content.Context;import android.content.Intent;import android.graphics.Typeface;import android.net.Uri;import android.os.Build;import android.os.Bundle;import android.util.Log;import android.view.View;import android.view.ViewGroup;import android.widget.GridLayout;import android.widget.ImageView;import android.widget.LinearLayout;import android.widget.RelativeLayout;import android.widget.ScrollView;import android.widget.TextView;import android.widget.Toast;import androidx.annotation.NonNull;import androidx.annotation.RequiresApi;import androidx.appcompat.app.AppCompatActivity;import androidx.cardview.widget.CardView;import androidx.constraintlayout.widget.ConstraintLayout;import androidx.core.content.res.ResourcesCompat;import androidx.recyclerview.widget.RecyclerView;import androidx.viewpager.widget.ViewPager;import androidx.viewpager2.widget.CompositePageTransformer;import androidx.viewpager2.widget.MarginPageTransformer;import androidx.viewpager2.widget.ViewPager2;import com.android.volley.Request;import com.android.volley.RequestQueue;import com.android.volley.Response;import com.android.volley.VolleyError;import com.android.volley.toolbox.JsonObjectRequest;import com.aniket.mutativefloatingactionbutton.MutativeFab;import com.facebook.shimmer.ShimmerFrameLayout;import com.google.android.material.bottomsheet.BottomSheetDialog;import com.google.android.material.button.MaterialButton;import com.google.gson.Gson;import com.google.hotelabbasi.ImageSliderTop.CustomVolleyRequest;import com.google.hotelabbasi.ImageSliderTop.SliderUtils;import com.google.hotelabbasi.ImageSliderTop.ViewPagerAdapter;import com.google.hotelabbasi.jsonschema2pojo.GetInfo.PrayTimeClassGetInfoMain;import com.loopj.android.http.AsyncHttpClient;import com.loopj.android.http.JsonHttpResponseHandler;import com.squareup.picasso.Picasso;import com.willy.ratingbar.BaseRatingBar;import com.willy.ratingbar.ScaleRatingBar;import org.json.JSONArray;import org.json.JSONException;import org.json.JSONObject;import java.util.ArrayList;import java.util.List;import cz.msebera.android.httpclient.Header;public class MainActivity extends AppCompatActivity {    ViewPager2 EghamatViewPager, locationViewPager, ResturanViewPager, JazebeViewPager;    Typeface typeface, typeface2, typeface3;    ConstraintLayout confirm_button, Layout_Rate, KoochitaTV, constraintLayout, constraintLayoutImageSlider;    TextView TxtPoeseshVaPasokhh, TxtGetYPorseshVaPasokh, TxtGetYNazareShome, TxtNazareShoma, TxtNazar, TxtMap, textView18, txtNumberImage, iccimmentFull, txtIcLike2, txtDisLike2, txtIcLike, txtDisLike, icCommenta, txtComment, txtIcLikeComment, txtDisLikeComment, ImgCall, TxtGhazaOtagh, txtFlot1, txtFlot2, txtflot3, txtflot4, txtFlot5, txtAddress, txtPhonNumber, TxtImageWeb, TxtSupport, txtImgVideoVlip, txtImgVideo, Txtstar, Txtstar2, Txtstar3, Txtstar4, Txtstar5, imageView2002, txtHotelTitle, txtDescription, txtSite, accelerate;    ShimmerFrameLayout shimmerFrameLayoutSliderTop;    LinearLayout line1, ImgRateViewOne, ImgRateViewOne2, ImgRateViewTwo, ImgRateViewTwo2, ImgRateViewThree, ImgRateViewThree2, ImgRateViewFoure, ImgRateViewFoure2, ImgRateViewFive, ImgRateViewFive2, shimerLayout_SliderTop, shimmer_layout_list;    View ViewView;    ImageView ImgBookMark2, ImgBookMark, img_logo_koochitaa;    ScrollView scrollView;    RelativeLayout RelImage, relativeLayout, RelTwitter;    String nameHotel, JsontxtHotelTitle;    String PicURL;    ViewPager viewPager;    CardView cardViewShareButtom;    LinearLayout sliderDotspanel;    RequestQueue rq;    List<SliderUtils> sliderImg;    ViewPagerAdapter viewPagerAdapter;    MutativeFab fab;    private int dotscount;    private ImageView[] dots;    @Override    protected void onCreate(Bundle savedInstanceState) {        super.onCreate(savedInstanceState);        setContentView(R.layout.activity_main);        FindViewByID();        startShimmer();        SetOnClickListener();        jsonParseGetInfo();        ImageSliderTop();        TopAttractionsViewPager();        EghamatViewPager();        JsonParseGetRate();        BoomghardiNazdikViewPager();        JsonParsgetFeatures();        ResturanViewPager();        compositePageTransformer();        TypeFace();        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {            ToolbarHide();        }        VideoPlayerClickListener();//        getPics();        rq = CustomVolleyRequest.getInstance(this).getRequestQueue();        sliderImg = new ArrayList<>();        viewPager = findViewById(R.id.viewPager);        sliderDotspanel = findViewById(R.id.SliderDots);    }    private void JsonParsegetNearbies() {        String url = "http://185.239.106.26/api/place/getNearbies/606ddc223f04952c46589811";        AsyncHttpClient client = new AsyncHttpClient();        client.get(url, new JsonHttpResponseHandler() {            @Override            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {                super.onSuccess(statusCode, headers, response);                try {                    JSONArray AllJson = response.getJSONArray("hotel");                    for (int i = 0; i < AllJson.length(); i++) {                        JSONObject object = AllJson.getJSONObject(i);                        nameHotel = object.getString("name");//                        Log.d("TAG", "onSuccess: " + nameHotel);                    }                } catch (Exception e) {//                    Log.d("TAG", "onSuccess: " + e);                }            }        });    }    private void SetOnClickListener() {        Layout_Rate.setOnClickListener(v -> showBottomSheetDialogShareButtomEmtiyaz(this));        cardViewShareButtom.setOnClickListener(v -> showBottomSheetDialogShareButtomShare(this));        ImgBookMark.setOnClickListener(new View.OnClickListener() {            @Override            public void onClick(View v) {                ImgBookMark.setVisibility(View.INVISIBLE);                ImgBookMark2.setVisibility(View.VISIBLE);            }        });    }    private void showBottomSheetDialogShareButtomEmtiyaz(Context context) {        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context, R.style.MyBottomSheetDialogTheme);        bottomSheetDialog.setContentView(R.layout.buttomsheet_emtiyaz);        bottomSheetDialog.setDismissWithAnimation(true);        MaterialButton BtnSubmit = bottomSheetDialog.findViewById(R.id.BtnSubmit);        BtnSubmit.setOnClickListener(v -> {            bottomSheetDialog.dismiss();        });        ScaleRatingBar ratingBar = new ScaleRatingBar(this);        ratingBar.setOnRatingChangeListener(new BaseRatingBar.OnRatingChangeListener() {            @Override            public void onRatingChange(BaseRatingBar ratingBar, float rating, boolean fromUser) {                Log.e("TAG", "onRatingChange: " + rating);            }        });        bottomSheetDialog.show();    }    private void showBottomSheetDialogShareButtomShare(Context context) {        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);        bottomSheetDialog.setContentView(R.layout.bottomsheetdialogemtiyazkarbar);        RelativeLayout relativeLayout = bottomSheetDialog.findViewById(R.id.RelTwitter);        RelativeLayout RelFacebook = bottomSheetDialog.findViewById(R.id.RelFacebook);        RelativeLayout RelCopy = bottomSheetDialog.findViewById(R.id.RelCopy);        ImageView icClose = bottomSheetDialog.findViewById(R.id.icClose);        bottomSheetDialog.setDismissWithAnimation(true);        String url = "https://koochita.com/show-place-details/hotels/%D9%87%D8%AA%D9%84_%D8%B9%D8%A8%D8%A7%D8%B3%DB%8C";        relativeLayout.setOnClickListener(v -> {            Intent intent = null;            try {                context.getPackageManager().getPackageInfo("com.twitter.android", 0);                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/intent/tweet?text=" + url));                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);            } catch (Exception e) {                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/intent/tweet?text=" + url));            }            context.startActivity(intent);        });        RelFacebook.setOnClickListener(v -> {            Intent intent = null;            try {                context.getPackageManager().getPackageInfo("com.facebook.katana", 0);                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/sharer/sharer.php?u=" + url));                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);            } catch (Exception e) {                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/sharer/sharer.php?u=" + url));            }            context.startActivity(intent);        });        RelCopy.setOnClickListener(v -> {            ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);            ClipData clip = ClipData.newPlainText("label", url);            clipboard.setPrimaryClip(clip);            Toast.makeText(context, "Done", Toast.LENGTH_LONG).show();        });        icClose.setOnClickListener(new View.OnClickListener() {            @Override            public void onClick(View v) {                bottomSheetDialog.setDismissWithAnimation(true);                bottomSheetDialog.dismiss();            }        });        bottomSheetDialog.show();    }    private void VideoPlayerClickListener() {        KoochitaTV.setOnClickListener(v -> {            String url = "https://koochitatv.com/video/show/8uU6LhcBap";            Intent i = new Intent(Intent.ACTION_VIEW);            i.setData(Uri.parse(url));            startActivity(i);        });    }    @RequiresApi(api = Build.VERSION_CODES.M)    private void ToolbarHide() {        scrollView.getViewTreeObserver().addOnScrollChangedListener(() -> {            int i = (int) ViewView.getY();            int i2 = scrollView.getScrollY();            if (scrollView.getScrollY() < RelImage.getY()) {                textView18.setTextColor(this.getResources().getColor(R.color.blue_web));            } else {                textView18.setTextColor(this.getResources().getColor(R.color.black));            }            if (scrollView.getScrollY() > RelImage.getY()) {                TxtMap.setTextColor(this.getResources().getColor(R.color.blue_web));            } else {                TxtMap.setTextColor(this.getResources().getColor(R.color.black));            }            if (scrollView.getScrollY() > TxtGetYNazareShome.getY()) {                TxtMap.setTextColor(this.getResources().getColor(R.color.black));            }            if (scrollView.getScrollY() > TxtGetYNazareShome.getY()) {                TxtNazar.setTextColor(this.getResources().getColor(R.color.blue_web));            } else {                TxtNazar.setTextColor(this.getResources().getColor(R.color.black));            }            if (scrollView.getScrollY() > TxtGetYPorseshVaPasokh.getY()) {                TxtPoeseshVaPasokhh.setTextColor(this.getResources().getColor(R.color.blue_web));            } else {                TxtPoeseshVaPasokhh.setTextColor(this.getResources().getColor(R.color.black));            }            Log.d("ASDASDASDASD", "ToolbarHide: " + scrollView.getScrollY());            if (scrollView.getScrollY() > ViewView.getY()) {                relativeLayout.setVisibility(View.VISIBLE);                fab.setVisibility(View.VISIBLE);                fab.setFabText("به" + " " + JsontxtHotelTitle + " امتیاز دهید ");                fab.getFabTextVisibility();            }            if (scrollView.getScrollY() < ViewView.getY()) {                relativeLayout.setVisibility(View.GONE);            }        });        scrollView.setOnScrollChangeListener((v, scrollX, scrollY, oldScrollX, oldScrollY) -> {            int v1 = scrollView.getScrollX();        });    }    private void JsonParseGetRate() {        String url = "http://185.239.106.26/api/place/getRates/606ddc223f04952c46589811";        AsyncHttpClient client = new AsyncHttpClient();        client.get(url, new JsonHttpResponseHandler() {            @Override            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {                super.onSuccess(statusCode, headers, response);                int JsonOne = 2;                int JsonTwo = 2;                int JsonThree = 2;                int JsonFour = 2;                int JsonFive = 2;                try {                    JSONObject jsonArray = response.getJSONObject("data");                    JsonOne = jsonArray.getInt("1");                    JsonTwo = jsonArray.getInt("2");                    JsonThree = jsonArray.getInt("3");                    JsonFour = jsonArray.getInt("4");                    JsonFive = jsonArray.getInt("5");                } catch (JSONException e) {                    e.printStackTrace();                }                Log.d("DDDDD", "onSuccess: " + JsonOne);                int Average = JsonOne + JsonTwo + JsonThree + JsonFour + JsonFive;//                >>>>>>>>>>>>>>>>>>>>>>>>>>UI Five<<<<<<<<<<<<<<<<<<<<<<<<<<             //                int FivePercentage = (JsonFive / Average) * 100;                float b = 100f;                float c = b - (float) FivePercentage;                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, (float) FivePercentage);                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, c);                ImgRateViewFive.setLayoutParams(layoutParams);                ImgRateViewFive2.setLayoutParams(layoutParams2);                txtFlot5.setText(FivePercentage + "%");//                >>>>>>>>>>>>>>>>>>>>>>>>>>UI Five<<<<<<<<<<<<<<<<<<<<<<<<<<             ////                >>>>>>>>>>>>>>>>>>>>>>>>>>UI Foue<<<<<<<<<<<<<<<<<<<<<<<<<<             //                int FourePercentage = (JsonFour / Average) * 100;                float d = 100f;                float e = d - (float) FourePercentage;                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, (float) FourePercentage);                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, e);                ImgRateViewFoure.setLayoutParams(layoutParams3);                ImgRateViewFoure2.setLayoutParams(layoutParams4);                txtflot4.setText(FourePercentage + "%");//                >>>>>>>>>>>>>>>>>>>>>>>>>>UI Foue<<<<<<<<<<<<<<<<<<<<<<<<<<             ////                >>>>>>>>>>>>>>>>>>>>>>>>>>UI Three<<<<<<<<<<<<<<<<<<<<<<<<<<             //                int ThreePercentage = (JsonThree / Average) * 100;                float f = 100f;                float g = f - (float) ThreePercentage;                LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, (float) ThreePercentage);                LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, g);                ImgRateViewThree.setLayoutParams(layoutParams5);                ImgRateViewThree2.setLayoutParams(layoutParams6);                txtflot3.setText(ThreePercentage + "%");//                >>>>>>>>>>>>>>>>>>>>>>>>>>UI Three<<<<<<<<<<<<<<<<<<<<<<<<<<             ////                >>>>>>>>>>>>>>>>>>>>>>>>>>UI Two<<<<<<<<<<<<<<<<<<<<<<<<<<             //                int TwoPercentage = (JsonTwo / Average) * 100;                float h = 100f;                float i = h - (float) TwoPercentage;                LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, (float) TwoPercentage);                LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, i);                ImgRateViewTwo.setLayoutParams(layoutParams7);                ImgRateViewTwo2.setLayoutParams(layoutParams8);                txtFlot2.setText(TwoPercentage + "%");//                >>>>>>>>>>>>>>>>>>>>>>>>>>UI Two<<<<<<<<<<<<<<<<<<<<<<<<<<             ////                >>>>>>>>>>>>>>>>>>>>>>>>>>UI One<<<<<<<<<<<<<<<<<<<<<<<<<<             //                int OnePercentage = (JsonOne / Average) * 100;                float j = 100f;                float k = j - (float) OnePercentage;                LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, (float) OnePercentage);                LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, k);                ImgRateViewOne.setLayoutParams(layoutParams9);                ImgRateViewOne2.setLayoutParams(layoutParams10);                txtFlot1.setText(OnePercentage + "%");//                >>>>>>>>>>>>>>>>>>>>>>>>>>UI One<<<<<<<<<<<<<<<<<<<<<<<<<<             //            }        });    }    private void FindViewByID() {        txtIcLike2 = findViewById(R.id.txtIcLike2);        ImgBookMark2 = findViewById(R.id.ImgBookMark2);        ImgBookMark = findViewById(R.id.ImgBookMark);        TxtPoeseshVaPasokhh = findViewById(R.id.TxtPoeseshVaPasokhh);        TxtGetYPorseshVaPasokh = findViewById(R.id.TxtGetYPorseshVaPasokh);        TxtGetYNazareShome = findViewById(R.id.TxtGetYNazareShome);        TxtNazareShoma = findViewById(R.id.TxtNazareShoma);        TxtNazar = findViewById(R.id.TxtNazar);        RelImage = findViewById(R.id.RelImage);        fab = findViewById(R.id.fab);        textView18 = findViewById(R.id.TxtMoarefiKoli);        TxtMap = findViewById(R.id.TxtMap);        img_logo_koochitaa = findViewById(R.id.img_logo_koochitaa);        cardViewShareButtom = findViewById(R.id.cardViewShareButtom);        txtNumberImage = findViewById(R.id.txtNumberImage);        txtDisLike2 = findViewById(R.id.txtDisLike2);        txtIcLike = findViewById(R.id.txtIcLike);        icCommenta = findViewById(R.id.icCommenta);        Layout_Rate = findViewById(R.id.layout_emtiyaz_karbar);        txtIcLike = findViewById(R.id.txtIcLike);        txtDisLike = findViewById(R.id.txtDisLike);        TxtGhazaOtagh = findViewById(R.id.TxtGhazaOtagh);        txtComment = findViewById(R.id.txtComment);        line1 = findViewById(R.id.line3);        KoochitaTV = findViewById(R.id.KoochitaTV);        constraintLayout = findViewById(R.id.accelerate);        ImgRateViewOne = findViewById(R.id.ImgRateViewOne);        ImgRateViewOne2 = findViewById(R.id.ImgRateViewOne2);        txtFlot2 = findViewById(R.id.txtFlot2);        ImgRateViewTwo = findViewById(R.id.ImgRateViewTwo);        txtFlot1 = findViewById(R.id.txtFlot1);        ImgRateViewTwo2 = findViewById(R.id.ImgRateViewTwo2);        txtflot3 = findViewById(R.id.txtflot3);        ImgRateViewThree = findViewById(R.id.ImgRateViewThree);        ImgRateViewThree2 = findViewById(R.id.ImgRateViewThree2);        txtflot4 = findViewById(R.id.txtflot4);        ImgRateViewFoure = findViewById(R.id.ImgRateViewFoure);        ImgRateViewFoure2 = findViewById(R.id.ImgRateViewFoure2);        txtFlot5 = findViewById(R.id.txtFlot5);        ImgRateViewFive = findViewById(R.id.ImgRateViewFive);        ImgRateViewFive2 = findViewById(R.id.ImgRateViewFive2);        Txtstar = findViewById(R.id.Txtstar);        TxtImageWeb = findViewById(R.id.TxtImageWeb);        txtPhonNumber = findViewById(R.id.txtPhonNumber);        txtAddress = findViewById(R.id.txtAddress);        txtImgVideo = findViewById(R.id.txtImgVideo);        txtImgVideoVlip = findViewById(R.id.txtImgVideoVlip);        Txtstar2 = findViewById(R.id.Txtstar2);        Txtstar3 = findViewById(R.id.Txtstar3);        Txtstar4 = findViewById(R.id.Txtstar4);        Txtstar5 = findViewById(R.id.Txtstar5);        constraintLayoutImageSlider = findViewById(R.id.ConstraintLayout_image_slider_top_mainactivity);        shimmerFrameLayoutSliderTop = findViewById(R.id.shimmer_view_container);        shimerLayout_SliderTop = findViewById(R.id.shimmer_layout_SliderTop);        relativeLayout = findViewById(R.id.rel);        accelerate = findViewById(R.id.accelerate00);        imageView2002 = findViewById(R.id.TxtLocation);        ViewView = findViewById(R.id.ViewView);        TxtSupport = findViewById(R.id.TxtSupport);        txtHotelTitle = findViewById(R.id.HotelTitle);        txtDescription = findViewById(R.id.txtDescription);        txtSite = findViewById(R.id.Site);        scrollView = findViewById(R.id.scrollViewMainActivity);        ImgCall = findViewById(R.id.TxtCall2);        iccimmentFull = findViewById(R.id.iccimmentFull);    }    private void TypeFace() {        typeface = Typeface.createFromAsset(getAssets(), "shazdemosafer.ttf");        typeface2 = Typeface.createFromAsset(getAssets(), "Shazdemosafer2.ttf");        typeface3 = Typeface.createFromAsset(getAssets(), "koochita.ttf");        accelerate.setTypeface(typeface);        ImgCall.setTypeface(typeface);        imageView2002.setTypeface(typeface);        Txtstar.setTypeface(typeface);        Txtstar2.setTypeface(typeface);        Txtstar3.setTypeface(typeface);        txtComment.setTypeface(typeface3);        txtDisLike.setTypeface(typeface3);        Txtstar4.setTypeface(typeface);        txtIcLike.setTypeface(typeface3);        iccimmentFull.setTypeface(typeface3);        txtDisLike2.setTypeface(typeface3);        txtIcLike2.setTypeface(typeface3);        Txtstar5.setTypeface(typeface);    }    private void Visibility() {        shimmerFrameLayoutSliderTop.stopShimmer();        shimmerFrameLayoutSliderTop.setVisibility(View.GONE);    }    private void startShimmer() {        shimmerFrameLayoutSliderTop.startShimmer();    }    private void getPics() {        String url = "http://185.239.106.26/api/place/getPics/606ddc223f04952c46589811";        AsyncHttpClient client = new AsyncHttpClient();        client.get(url, new JsonHttpResponseHandler() {            @Override            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {                super.onSuccess(statusCode, headers, response);                try {                    JSONArray jsonArray = response.getJSONArray("sitePics");                    for (int i = 0; i < jsonArray.length(); i++) {                        JSONObject object = jsonArray.getJSONObject(i);                        String PicURL = object.getString("url");                        Log.d("TAG", "onSuccess: " + PicURL);                    }                } catch (JSONException e) {                    Log.d("TAG", "onSuccess: " + e);                }            }        });    }    private void JsonParsgetFeatures() {        String url = "http://185.239.106.26/api/place/getFeatures/606ddc223f04952c465898fa";        AsyncHttpClient client = new AsyncHttpClient();        client.get(url, new JsonHttpResponseHandler() {            @Override            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {                super.onSuccess(statusCode, headers, response);                try {                    JSONArray allFeatures = response.getJSONArray("allFeatures");                    for (int i = 0; i < allFeatures.length(); i++) {                        JSONObject object = allFeatures.getJSONObject(i);                        String nameJson = object.getString("name");//                        Log.d("TAG", "onSuccess: " + nameJson);                        JSONArray jsonArray = object.getJSONArray("features");//                        Log.d("AAA", "onSuccess: " + jsonArray);                        View view = getLayoutInflater().inflate(R.layout.testlayout, null);                        TextView TxtGhazaOtagh = view.findViewById(R.id.TxtGhazaOtagh);                        GridLayout linear_layout = view.findViewById(R.id.linear_layout);                        for (int b = 0; b < jsonArray.length(); b++) {                            JSONObject object1 = jsonArray.getJSONObject(b);                            String tt = object1.getString("name");                            System.out.println(tt);                            TextView tv = new TextView(MainActivity.this);                            tv.setText(tt);                            tv.setTextSize(13);                            tv.setTypeface(ResourcesCompat.getFont(MainActivity.this, R.font.iransans));                            tv.setPadding(30, 30, 30, 0);                            linear_layout.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);                            linear_layout.addView(tv);                        }                        TxtGhazaOtagh.setText(nameJson);                        line1.addView(view);                    }                } catch (JSONException e) {                    e.printStackTrace();                }            }            @Override            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {                super.onFailure(statusCode, headers, responseString, throwable);//                Log.d("TAG", "onFailure: " + throwable);            }        });    }    private void jsonParseGetInfo() {        String url = "http://185.239.106.26/api/place/getInfo/هتل_سبلان";        AsyncHttpClient client = new AsyncHttpClient();        client.get(url, new JsonHttpResponseHandler() {            @Override            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {                super.onSuccess(statusCode, headers, response);                Gson gson = new Gson();                PrayTimeClassGetInfoMain pray = gson.fromJson(response.toString(), PrayTimeClassGetInfoMain.class);                String JsontxtPhonNumber = pray.getDetail().getPhone();                JsontxtHotelTitle = pray.getDetail().getName();                String JsontxtSite = pray.getDetail().getSite();                String status = pray.getDetail().getState();                String Image = pray.getDetail().getMapUrl();                Log.d("FFFASFASF", "onSuccess: " + JsontxtHotelTitle);                Picasso.get().load(Image).fit().centerCrop().into(img_logo_koochitaa);                String JsontxtDescription = pray.getDetail().getDescription();                String JsontxtAddress = pray.getDetail().getAddress();//                Log.d("asdasd", "onSuccess: " + status);                txtAddress.setText(JsontxtAddress);                txtDescription.setText(JsontxtDescription);                txtPhonNumber.setText(JsontxtPhonNumber);                txtHotelTitle.setText(JsontxtHotelTitle);                txtSite.setText(JsontxtSite);                Visibility();            }            @Override            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {                super.onFailure(statusCode, headers, responseString, throwable);            }        });    }    private void ImageSliderTop() {        String url = "http://185.239.106.26/api/place/getPics/606ddc223f04952c46589811";        JsonObjectRequest jsonArrayRequest = new JsonObjectRequest(Request.Method.GET, url, null, response -> {            for (int i = 0; i < response.length(); i++) {                SliderUtils sliderUtils = new SliderUtils();                try {                    JSONArray jsonObject = response.getJSONArray("sitePics");                    for (int j = 0; j < jsonObject.length(); j++) {                        JSONObject jsonObject1 = jsonObject.getJSONObject(i);                        String URL = jsonObject1.getString("url");                        String Number = String.valueOf(jsonObject.length());                        sliderUtils.setSliderImageUrl(URL);                        txtNumberImage.setText(Number);                        Log.d("AAA", "ImageSliderTop: " + Number);                    }                } catch (JSONException e) {                    e.printStackTrace();                }                sliderImg.add(sliderUtils);            }            viewPagerAdapter = new ViewPagerAdapter(sliderImg, MainActivity.this);            viewPager.setAdapter(viewPagerAdapter);            dotscount = viewPagerAdapter.getCount();            dots = new ImageView[dotscount];            for (int i = 0; i < dotscount; i++) {                dots[i] = new ImageView(MainActivity.this);//                dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_full_star));                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);                params.setMargins(0, 10, 0, 0);                sliderDotspanel.addView(dots[i], params);            }//            dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_star));        }, new Response.ErrorListener() {            @Override            public void onErrorResponse(VolleyError error) {            }        });        CustomVolleyRequest.getInstance(this).addToRequestQueue(jsonArrayRequest);    }    private void compositePageTransformer() {        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();        compositePageTransformer.addTransformer(new MarginPageTransformer(50));        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {            @Override            public void transformPage(@NonNull View page, float position) {                float r = 2 - Math.abs(position);                page.setScaleY(0.95f + r * 0.05f);            }        });//        locationViewPager.setPageTransformer(compositePageTransformer);        JazebeViewPager.setPageTransformer(compositePageTransformer);        ResturanViewPager.setPageTransformer(compositePageTransformer);        EghamatViewPager.setPageTransformer(compositePageTransformer);    }    private void BoomghardiNazdikViewPager() {        String url = "http://185.239.106.26/api/place/getNearbies/606ddc223f04952c46589811";        AsyncHttpClient client = new AsyncHttpClient();        client.get(url, new JsonHttpResponseHandler() {            @Override            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {                super.onSuccess(statusCode, headers, response);                try {                    JSONArray jsonArray = response.getJSONArray("adventure");                    for (int i = 0; i < jsonArray.length(); i++) {                        JSONObject jsonArray1 = jsonArray.getJSONObject(i);                        JSONObject jsonArray2 = jsonArray1.getJSONObject("pic");                        String PicUrl = jsonArray2.getString("pic");                        locationViewPager = findViewById(R.id.locationsviewPager);                        List<SliderModelTabiat> sliderModelTabiats = new ArrayList<>();                        for (int j = 0; j < jsonArray2.length(); j++) {                            SliderModelTabiat sliderModelTabiatMotionView = new SliderModelTabiat();                            sliderModelTabiatMotionView.imageUrl = PicUrl;                            sliderModelTabiatMotionView.title = "کوه صفه اسفهان";                            sliderModelTabiatMotionView.location = "اصفهان اصفهان";                            sliderModelTabiatMotionView.starRating = 4.5f;                            sliderModelTabiats.add(sliderModelTabiatMotionView);                            locationViewPager.setAdapter(new SliderBoomGardiNazdikAdapter(sliderModelTabiats));                            locationViewPager.setClipToPadding(false);                            locationViewPager.setClipChildren(false);                            locationViewPager.setOffscreenPageLimit(10);                            locationViewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);                        }                        Log.d("FFF", "onSuccess: " + jsonArray2.length());                    }                } catch (JSONException e) {                    e.printStackTrace();                }            }        });    }    private void ResturanViewPager() {        ResturanViewPager = findViewById(R.id.locationsviewPager3);        List<SliderModelResturan> sliderModelResturans = new ArrayList<>();        SliderModelResturan sliderModelResturan = new SliderModelResturan();        sliderModelResturan.imageUrl = "https://static.koochita.com/_images/restaurant/res_maral_isfahan/f-1.jpg";        sliderModelResturan.title = "رستوران مارال";        sliderModelResturan.location = "اصفهان اصفهان";        sliderModelResturan.starRating = 4.5f;        sliderModelResturans.add(sliderModelResturan);        SliderModelResturan sliderModelResturan2 = new SliderModelResturan();        sliderModelResturan2.imageUrl = "https://static.koochita.com/_images/restaurant/res_zhik_isfahan/f-1.jpg";        sliderModelResturan2.title = "رستوران فرنگی ژیک";        sliderModelResturan2.location = "اصفهان اصفهان";        sliderModelResturan2.starRating = 4.5f;        sliderModelResturans.add(sliderModelResturan2);        SliderModelResturan sliderModelResturan3 = new SliderModelResturan();        sliderModelResturan3.imageUrl = "https://static.koochita.com/_images/restaurant/res_mr.kotlet_isfahan/f-1.jpg";        sliderModelResturan3.title = "فست فود آقای کتلت";        sliderModelResturan3.location = "اصفهان اصفهان";        sliderModelResturan3.starRating = 4.5f;        sliderModelResturans.add(sliderModelResturan3);        ResturanViewPager.setAdapter(new SliderRestaurantsAdapter(sliderModelResturans));        ResturanViewPager.setClipToPadding(false);        ResturanViewPager.setClipChildren(false);        ResturanViewPager.setOffscreenPageLimit(3);        ResturanViewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);    }    private void EghamatViewPager() {        EghamatViewPager = findViewById(R.id.locationsviewPager4);        List<SliderModelEghamat> sliderModelEghamats = new ArrayList<>();        SliderModelEghamat sliderModelEghamat = new SliderModelEghamat();        sliderModelEghamat.imageUrl = "https://static.koochita.com/_images/hotels/hotel_abbasi/f-5.jpg";        sliderModelEghamat.title = "هتل عباسی";        sliderModelEghamat.location = "اصفهان اصفهان";        sliderModelEghamat.starRating = 4.5f;        sliderModelEghamats.add(sliderModelEghamat);        SliderModelEghamat sliderModelEghamat2 = new SliderModelEghamat();        sliderModelEghamat2.imageUrl = "https://static.koochita.com/_images/hotels/hotel_safir/f-1.jpg";        sliderModelEghamat2.title = "هتل سفیر";        sliderModelEghamat2.location = "اصفهان اصفهان";        sliderModelEghamat2.starRating = 4.5f;        sliderModelEghamats.add(sliderModelEghamat2);        SliderModelEghamat sliderModelEghamat3 = new SliderModelEghamat();        sliderModelEghamat3.imageUrl = "https://static.koochita.com/_images/hotels/hotel_pars/f-1.jpg";        sliderModelEghamat3.title = "هتل پارس";        sliderModelEghamat3.location = "اصفهان اصفهان";        sliderModelEghamat3.starRating = 4.5f;        sliderModelEghamats.add(sliderModelEghamat3);        EghamatViewPager.setAdapter(new SliderEghamatAdapter(sliderModelEghamats));        EghamatViewPager.setClipToPadding(false);        EghamatViewPager.setClipChildren(false);        EghamatViewPager.setOffscreenPageLimit(10);        EghamatViewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);    }    private void TopAttractionsViewPager() {        JazebeViewPager = findViewById(R.id.locationsviewPager2);        List<SliderModelJazebe> sliderModelJazebes = new ArrayList<>();        SliderModelJazebe sliderModelJazebe = new SliderModelJazebe();        sliderModelJazebe.imageUrl = "https://static.koochita.com/_images/amaken/chahar_bagh_school/f-1.jpg";        sliderModelJazebe.title = "مدرسه چهارباغ";        sliderModelJazebe.location = "اصفهان اصفهان";        sliderModelJazebe.starRating = 4.5f;        sliderModelJazebes.add(sliderModelJazebe);        SliderModelJazebe sliderModelJazebe2 = new SliderModelJazebe();        sliderModelJazebe2.imageUrl = "https://static.koochita.com/_images/amaken/honar_bazar/f-1.jpg";        sliderModelJazebe2.title = "بازار هنر";        sliderModelJazebe2.location = "اصفهان اصفهان";        sliderModelJazebe2.starRating = 4.5f;        sliderModelJazebes.add(sliderModelJazebe2);        SliderModelJazebe sliderModelJazebe3 = new SliderModelJazebe();        sliderModelJazebe3.imageUrl = "https://static.koochita.com/_images/amaken/chehelsotun/f-1.jpg";        sliderModelJazebe3.title = "کاخ چهل ستون";        sliderModelJazebe3.location = "اصفهان اصفهان";        sliderModelJazebe3.starRating = 4.5f;        sliderModelJazebes.add(sliderModelJazebe3);        JazebeViewPager.setAdapter(new SliderJazebeAdapter(sliderModelJazebes));        JazebeViewPager.setClipToPadding(false);        JazebeViewPager.setClipChildren(false);        JazebeViewPager.setOffscreenPageLimit(3);        JazebeViewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);    }}