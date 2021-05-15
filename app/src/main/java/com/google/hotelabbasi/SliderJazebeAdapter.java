package com.google.hotelabbasi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SliderJazebeAdapter extends RecyclerView.Adapter<SliderJazebeAdapter.SliderJazebeViewHolder> {

    private final List<SliderModelJazebe> sliderModelJazebes;

    public SliderJazebeAdapter(List<SliderModelJazebe> sliderModelJazebes) {
        this.sliderModelJazebes = sliderModelJazebes;
    }

    @NonNull
    @Override
    public SliderJazebeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SliderJazebeViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_container_location,
                        parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull SliderJazebeViewHolder holder, int position) {
        holder.setLocationData(sliderModelJazebes.get(position));
    }

    @Override
    public int getItemCount() {
        return sliderModelJazebes.size();
    }


    static class SliderJazebeViewHolder extends RecyclerView.ViewHolder {

        private ImageView kbvLocation;

        private TextView txtTitle, txtLocation;


        public SliderJazebeViewHolder(@NonNull View itemView) {
            super(itemView);

            kbvLocation = itemView.findViewById(R.id.kbvLocation);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtLocation = itemView.findViewById(R.id.txtlocation);

        }

        void setLocationData(SliderModelJazebe sliderModel) {
            Picasso.get().load(sliderModel.imageUrl).into(kbvLocation);
            txtTitle.setText(sliderModel.title);
            txtLocation.setText(sliderModel.location);
        }
    }
}
