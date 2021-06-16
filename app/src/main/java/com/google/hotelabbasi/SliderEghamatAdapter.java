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

public class SliderEghamatAdapter extends RecyclerView.Adapter<SliderEghamatAdapter.TravelLocationViewHolder>{

    private List<SliderModelEghamat> sliderModelEghamats;

    public SliderEghamatAdapter(List<SliderModelEghamat> sliderModelEghamats) {
        this.sliderModelEghamats = sliderModelEghamats;
    }

    @NonNull
    @Override
    public TravelLocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TravelLocationViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_container_location,
                        parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull TravelLocationViewHolder holder, int position) {
        holder.setLocationData(sliderModelEghamats.get(position));

    }

    @Override
    public int getItemCount() {
        return sliderModelEghamats.size();
    }

    static class TravelLocationViewHolder extends RecyclerView.ViewHolder{

        private ImageView kbvLocation;
        private TextView txtTitle, txtLocation;

        public TravelLocationViewHolder(@NonNull View itemView) {
            super(itemView);

            kbvLocation = itemView.findViewById(R.id.kbvLocation);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtLocation = itemView.findViewById(R.id.txtlocation);
        }
        void setLocationData(SliderModelEghamat sliderModelTabiat) {
            Picasso.get().load(sliderModelTabiat.imageUrl).into(kbvLocation);
            txtTitle.setText(sliderModelTabiat.title);
            txtLocation.setText(sliderModelTabiat.location);
        }
    }
}

