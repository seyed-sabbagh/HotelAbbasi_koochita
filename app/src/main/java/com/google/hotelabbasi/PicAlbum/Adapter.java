package com.google.hotelabbasi.PicAlbum;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.hotelabbasi.R;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import static com.google.hotelabbasi.PicAlbum.PicAlbumActivity.ImgAlbumMainA;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    ListItem currentItem;
    private Context mContext;
    private ArrayList<ListItem> listItems;

    public Adapter(Context mContext, ArrayList<ListItem> listItems) {
        this.mContext = mContext;
        this.listItems = listItems;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.recyclerviewalbum_item, parent, false);


        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {

        currentItem = listItems.get(position);


        String ImageUrl = currentItem.getImageUrl();

        Picasso.get().load(ImageUrl).into(holder.imageViewAlbum);

        holder.imageViewAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("SSS", "onClick: " + position);

                String aa = listItems.get(position).getImageUrl();
                Picasso.get().load(aa).fit().centerCrop().into(ImgAlbumMainA);

            }
        });


    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageViewAlbum;
        public RecyclerView recyclerView;


        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            imageViewAlbum = itemView.findViewById(R.id.image_viewAlbum);

            recyclerView = itemView.findViewById(R.id.RecyclerViewAlbum);


        }


    }


}
