package com.google.hotelabbasi.slider.Boom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.hotelabbasi.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SliderViewPagerAdapter extends RecyclerView.Adapter<SliderViewPagerAdapter.TravelLocationViewHolder> {

    private final List<ModelSliderViewPager> modelSliderViewPagers;

    public SliderViewPagerAdapter(List<ModelSliderViewPager> modelSliderViewPagers) {
        this.modelSliderViewPagers = modelSliderViewPagers;
    }



    @NonNull
    @Override
    public TravelLocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TravelLocationViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_container_location,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull TravelLocationViewHolder holder, int position) {
        holder.setLocationData(modelSliderViewPagers.get(position));
    }

    @Override
    public int getItemCount() {
        return modelSliderViewPagers.size();
    }

    static class TravelLocationViewHolder extends RecyclerView.ViewHolder {

        private final ImageView kbvLocation;
        private final TextView txtTitle;
        private final TextView txtLocation;

        TravelLocationViewHolder(@NonNull View itemView) {
            super(itemView);
            kbvLocation = itemView.findViewById(R.id.kbvLocation);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtLocation = itemView.findViewById(R.id.txtlocation);
        }

        void setLocationData(ModelSliderViewPager modeladventureViewPager) {
            Picasso.get().load( modeladventureViewPager.imageUrl).placeholder(R.drawable.loading_slider).error(R.drawable.loading_slider).into(kbvLocation);
            txtTitle.setText(modeladventureViewPager.title);
            txtLocation.setText(modeladventureViewPager.location);
        }
    }
}
