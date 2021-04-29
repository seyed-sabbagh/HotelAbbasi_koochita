package com.example.hotelabbasi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SliderBoomGardiNazdikAdapter extends RecyclerView.Adapter<SliderBoomGardiNazdikAdapter.TravelLocationViewHolder> {

    private final List<SliderModelTabiat> sliderModelTabiats;

    public SliderBoomGardiNazdikAdapter(List<SliderModelTabiat> sliderModelTabiats) {
        this.sliderModelTabiats = sliderModelTabiats;
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
        holder.setLocationData(sliderModelTabiats.get(position));
    }

    @Override
    public int getItemCount() {
        return sliderModelTabiats.size();
    }

    static class TravelLocationViewHolder extends RecyclerView.ViewHolder {

        private KenBurnsView kbvLocation;
        private TextView txtTitle, txtLocation;

        TravelLocationViewHolder(@NonNull View itemView) {
            super(itemView);
            kbvLocation = itemView.findViewById(R.id.kbvLocation);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtLocation = itemView.findViewById(R.id.txtlocation);
        }

        void setLocationData(SliderModelTabiat sliderModelTabiat) {
            Picasso.get().load(sliderModelTabiat.imageUrl).into(kbvLocation);
            txtTitle.setText(sliderModelTabiat.title);
            txtLocation.setText(sliderModelTabiat.location);
        }
    }
}
