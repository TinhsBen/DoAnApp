package com.example.a4foods.adapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a4foods.db.MyDatabase;
import com.example.a4foods.model.Cart;
import com.example.a4foods.model.Products;
import com.example.doanapp.R;

import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ProductVH> {
    Activity context = null;
    ArrayList<Cart> arrCart = null;
    MyDatabase db;
    int layoutid;

    public CartAdapter(Activity context, ArrayList<Cart> arrCart, int layoutid)
    {
        this.db = new MyDatabase(context);
        this.context = context;
        this.arrCart = arrCart;
        this.layoutid = layoutid;
    }

    @NonNull
    @Override
    public ProductVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutid, parent,false);
        return new CartAdapter.ProductVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductVH holder, int position) {
        Cart cart = arrCart.get(position);
        Products pro = db.getInfoPro(cart.getIdProCart());
        try {
            InputStream is = context.getAssets().open(pro.getImagePro());
            Bitmap bitmap = BitmapFactory.decodeStream(is);
            holder.imgPro.setImageBitmap(bitmap);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        holder.tvName.setText(pro.getName());

        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        String price = currencyVN.format(pro.getPrice());
        String nuoc = cart.getNuoc();
        String ankem = cart.getAnkem();
        holder.tvGia.setText(price);
        holder.tvNuoc.setText(nuoc);
        holder.tvAnkem.setText(ankem);
        holder.tvSoLuong.setText("x" + cart.getQuantity());
    }


    @Override
    public int getItemCount() {
        return arrCart.size();
    }
    class ProductVH extends RecyclerView.ViewHolder {

        ImageView imgPro;
        TextView tvName, tvGia, tvNuoc, tvAnkem, tvSoLuong;

        public ProductVH(@NonNull View itemView) {
            super(itemView);

            imgPro = (ImageView) itemView.findViewById(R.id.imgCartList);
            tvName = (TextView) itemView.findViewById(R.id.tvTenSP_Cart);
            tvGia = (TextView) itemView.findViewById(R.id.tvGia_Cart);
            tvNuoc = (TextView) itemView.findViewById(R.id.tvNuoc_Cart);
            tvAnkem = (TextView) itemView.findViewById(R.id.tvAnkemSP_Cart);
            tvSoLuong = (TextView) itemView.findViewById(R.id.tvSoLuong);
        }

    }
}
