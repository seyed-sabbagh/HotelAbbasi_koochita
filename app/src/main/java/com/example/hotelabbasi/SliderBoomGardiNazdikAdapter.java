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

    private List<SliderModel> sliderModels;

    public SliderBoomGardiNazdikAdapter(List<SliderModel> sliderModels) {
        this.sliderModels = sliderModels;
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
        holder.setLocationData(sliderModels.get(position));
    }

    @Override
    public int getItemCount() {
        return sliderModels.size();
    }

    static class TravelLocationViewHolder extends RecyclerView.ViewHolder {

        private KenBurnsView kbvLocation;
        private TextView txtTitle, txtLocation, txtStarRating;

        TravelLocationViewHolder(@NonNull View itemView) {
            super(itemView);
            kbvLocation = itemView.findViewById(R.id.kbvLocation);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtLocation = itemView.findViewById(R.id.txtlocation);
            txtStarRating = itemView.findViewById(R.id.txtstarrating);
        }

        void setLocationData(SliderModel sliderModel) {
            Picasso.get().load(sliderModel.imageUrl).into(kbvLocation);
            txtTitle.setText(sliderModel.title);
            txtLocation.setText(sliderModel.location);
            txtStarRating.setText(String.valueOf(sliderModel.starRating));
        }
    }
}
