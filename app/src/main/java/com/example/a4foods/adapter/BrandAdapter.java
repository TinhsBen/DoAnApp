package com.example.a4foods.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a4foods.model.Brand;
import com.example.doanapp.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class BrandAdapter extends RecyclerView.Adapter<BrandAdapter.BrandVH> {

    ArrayList<Brand> brands;
    Listener listener;
    Context context;

    public BrandAdapter(ArrayList<Brand> brands, Listener listener, Context context) {
        this.brands = brands;
        this.listener = listener;
        this.context = context;
    }

    @NonNull
    @Override
    public BrandVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_brand, parent,false);
        return new BrandVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BrandVH holder, int position) {
        Brand brand = brands.get(position);

        try {
            InputStream is = context.getAssets().open(brand.getImageBrand());
            Bitmap bitmap = BitmapFactory.decodeStream(is);
            holder.imgBrand.setImageBitmap(bitmap);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //holder.imgBrand.setImageResource(brand.getImageBrand());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.setOnItemBrandClick(brand);
            }
        });
    }

    @Override
    public int getItemCount() {
        return brands.size();
    }

    public class BrandVH extends RecyclerView.ViewHolder {

        ImageView imgBrand;

        public BrandVH(@NonNull View itemView) {
            super(itemView);
            imgBrand = (ImageView) itemView.findViewById(R.id.imgLogo);
        }
    }
    public interface Listener{
        void setOnItemBrandClick(Brand brand);
    }
}
