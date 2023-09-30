package com.example.a4foods.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.a4foods.adapter.ListOrderAdminAdapter;
import com.example.a4foods.db.MyDatabase;
import com.example.doanapp.R;
import com.example.a4foods.model.Order;

import java.util.ArrayList;

public class ListOrderForAdmin extends AppCompatActivity implements ListOrderAdminAdapter.Listener {

    ArrayList<Order> arrOrder;
    RecyclerView rcvOrder;
    ListOrderAdminAdapter listOrderForAdmin;
    TextView tvMaDon, tvThoiGian;
    MyDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_order_for_admin);

        db = new MyDatabase(ListOrderForAdmin.this);
        rcvOrder = (RecyclerView) findViewById(R.id.rcvAllOrder);
        tvMaDon = (TextView) findViewById(R.id.tvMaDon);
        tvThoiGian = (TextView) findViewById(R.id.tvThoiGian);


        arrOrder = new ArrayList<Order>();

        arrOrder = db.selectOrderForAdmin();


        listOrderForAdmin = new ListOrderAdminAdapter(ListOrderForAdmin.this, arrOrder, R.layout.item_order_for_admin, ListOrderForAdmin.this);
        rcvOrder.setAdapter(listOrderForAdmin);

        rcvOrder.setLayoutManager(new LinearLayoutManager(ListOrderForAdmin.this, LinearLayoutManager.VERTICAL, false));
        rcvOrder.addItemDecoration(new DividerItemDecoration(ListOrderForAdmin.this, LinearLayoutManager.VERTICAL));
    }

    public void IconHomeAdminOnclickListener(View view) {
        Intent intent = new Intent(ListOrderForAdmin.this, MainActivityAdmin.class);
        startActivity(intent);
    }

    @Override
    public void setOnItemClickListener(Order order) {
        Intent intentPro = new Intent(ListOrderForAdmin.this, OrderDetailAdminActivity.class);
        intentPro.putExtra("orderAdmin", order);
        startActivity(intentPro);
    }
}