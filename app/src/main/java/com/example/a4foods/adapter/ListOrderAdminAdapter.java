package com.example.a4foods.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanapp.R;
import com.example.a4foods.db.MyDatabase;
import com.example.a4foods.model.Order;

import java.util.ArrayList;

public class ListOrderAdminAdapter extends RecyclerView.Adapter<ListOrderAdminAdapter.ProductVH>{
    Activity context = null;
    ArrayList<Order> arrOrder = null;
    MyDatabase db;
    int layoutid;
    Listener listener;

    public ListOrderAdminAdapter(Activity context, ArrayList<Order> arrOrder, int layoutid, Listener listener)
    {
        this.db = new MyDatabase(context);
        this.context = context;
        this.arrOrder = arrOrder;
        this.layoutid = layoutid;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ListOrderAdminAdapter.ProductVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutid, parent,false);
        return new ListOrderAdminAdapter.ProductVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListOrderAdminAdapter.ProductVH holder, int position) {
        Order order = arrOrder.get(position);

        if(order.getIdOrder() <10){
            holder.tvMaDon.setText("Mã đơn hàng: 0" + String.valueOf(order.getIdOrder()));
        }
        else {
            holder.tvMaDon.setText("Mã đơn hàng: " + String.valueOf(order.getIdOrder()));
        }
        holder.tvThoiGian.setText("Thời gian đặt: " + order.getDate());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.setOnItemClickListener(order);
            }
        });

    }


    @Override
    public int getItemCount() {
        return arrOrder.size();
    }
    class ProductVH extends RecyclerView.ViewHolder {

        TextView tvMaDon, tvThoiGian;

        public ProductVH(@NonNull View itemView) {
            super(itemView);

            tvMaDon = (TextView) itemView.findViewById(R.id.tvMaDon);
            tvThoiGian = (TextView) itemView.findViewById(R.id.tvThoiGian);
        }

    }
    public interface Listener{
        void setOnItemClickListener(Order order);
    }
}
