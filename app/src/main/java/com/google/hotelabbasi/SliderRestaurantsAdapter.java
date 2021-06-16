package com.google.hotelabbasi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class SliderRestaurantsAdapter extends RecyclerView.Adapter<SliderRestaurantsAdapter.TravelLocationViewHolder> {

    private final List<SliderModelResturan> sliderModelResturans;

    public SliderRestaurantsAdapter(List<SliderModelResturan> sliderModelResturans) {
        this.sliderModelResturans = sliderModelResturans;
    }

    @NonNull
    @Override
    public TravelLocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TravelLocationViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_container_location,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull TravelLocationViewHolder holder, int position) {
        holder.setLocationData(sliderModelResturans.get(position));
    }

    @Override
    public int getItemCount() {
        return sliderModelResturans.size();
    }

    static class TravelLocationViewHolder extends RecyclerView.ViewHolder{

        private ImageView kbvLocation;
        private TextView txttitle,txtlocation;

        public TravelLocationViewHolder(@NonNull View itemView) {
            super(itemView);
            kbvLocation = itemView.findViewById(R.id.kbvLocation);
            txtlocation = itemView.findViewById(R.id.txtlocation);
            txttitle = itemView.findViewById(R.id.txtTitle);
        }
        void setLocationData(SliderModelResturan sliderModelTabiat) {
            Picasso.get().load(sliderModelTabiat.imageUrl).into(kbvLocation);
            txttitle.setText(sliderModelTabiat.title);
            txtlocation.setText(sliderModelTabiat.location);
        }
    }

}

