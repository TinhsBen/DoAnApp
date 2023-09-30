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

import com.example.a4foods.model.Products;
import com.example.doanapp.R;
import com.example.a4foods.db.MyDatabase;
import com.example.a4foods.model.Order;

import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ProductVH>{
    Activity context = null;
    ArrayList<Order> arrOrder = null;
    MyDatabase db;
    int layoutid;

    public OrderAdapter(Activity context, ArrayList<Order> arrOrder, int layoutid)
    {
        this.db = new MyDatabase(context);
        this.context = context;
        this.arrOrder = arrOrder;
        this.layoutid = layoutid;
    }

    @NonNull
    @Override
    public OrderAdapter.ProductVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutid, parent,false);
        return new OrderAdapter.ProductVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.ProductVH holder, int position) {
        Order order = arrOrder.get(position);
        Products pro = db.getInfoPro(order.getIdProOrder());
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
        String nuoc = order.getNuoc();
        String ankem = order.getAnkem();
        holder.tvGia.setText(price);
        holder.tvNuoc.setText(nuoc);
        holder.tvAnkem.setText(ankem);
        holder.tvSoLuong.setText("x" + order.getQuantity());
    }


    @Override
    public int getItemCount() {
        return arrOrder.size();
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
