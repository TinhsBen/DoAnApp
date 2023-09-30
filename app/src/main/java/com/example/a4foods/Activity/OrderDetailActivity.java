package com.example.a4foods.Activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.a4foods.ui.Login;
import com.example.a4foods.adapter.OrderAdapter;
import com.example.a4foods.db.MyDatabase;
import com.example.a4foods.model.Order;
import com.example.a4foods.model.Products;
import com.example.doanapp.R;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class OrderDetailActivity extends AppCompatActivity {


    ArrayList<Order> arrOrder;
    RecyclerView rcvOrder;
    OrderAdapter orderAdapter;
    TextView tvNameUserOrder, tvPhoneUserOrder, tvAddressUserOrder, tvTongTienHang, tvThongBao;
    MyDatabase db;
    Button btnDonDangGiao, btnDonDaGiao;
    ScrollView scrMyOrder;
    TableLayout tblGioHang;
    LinearLayout profileOrder;
    int moneySum = 0;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

        db = new MyDatabase(OrderDetailActivity.this);
        rcvOrder = (RecyclerView) findViewById(R.id.rcvOrderD);
        tvNameUserOrder = (TextView) findViewById(R.id.tvNameUserOrderD);
        tvPhoneUserOrder = (TextView) findViewById(R.id.tvPhoneUserOrderD);
        tvAddressUserOrder = (TextView) findViewById(R.id.tvAddressUserOrderD);
        tvTongTienHang = (TextView) findViewById(R.id.tvTongTienD);
        btnDonDangGiao = (Button) findViewById(R.id.btnDonDangGiao);
        btnDonDaGiao = (Button) findViewById(R.id.btnDonDaGiao);
        scrMyOrder = (ScrollView) findViewById(R.id.scrMyOder);
        tvThongBao = (TextView) findViewById(R.id.tvThongBao);
        tblGioHang = (TableLayout) findViewById(R.id.tbloGioHang);
        profileOrder = (LinearLayout) findViewById(R.id.profileOrder);

        arrOrder = new ArrayList<Order>();

        arrOrder = db.selectOrder(Login.getLogin(), 0);


        if(arrOrder.isEmpty()){
            scrMyOrder.setVisibility(View.GONE);
            tvThongBao.setVisibility(View.VISIBLE);
        }

        orderAdapter = new OrderAdapter(this, arrOrder, R.layout.item_info_pro);
        rcvOrder.setAdapter(orderAdapter);

        rcvOrder.setLayoutManager(new LinearLayoutManager(OrderDetailActivity.this, LinearLayoutManager.VERTICAL, false));
        rcvOrder.addItemDecoration(new DividerItemDecoration(OrderDetailActivity.this, LinearLayoutManager.VERTICAL));

        tvNameUserOrder.setText(arrOrder.get(0).getName());
        tvPhoneUserOrder.setText(arrOrder.get(0).getPhone());
        tvAddressUserOrder.setText(arrOrder.get(0).getAddress());

        for (Order item: arrOrder) {
            Products pro = db.getInfoPro(item.getIdProOrder());
            moneySum += pro.getPrice();
        }

        //don vi tien VN
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        String price = currencyVN.format(moneySum);
        tvTongTienHang.setText(price);
    }

    public void btnDangGiaoOnclick(View view) {
        btnDonDaGiao.setBackgroundColor(Color.rgb(192,192,192));
        btnDonDangGiao.setBackgroundColor(Color.rgb(232, 232, 232));
        tblGioHang.setVisibility(View.VISIBLE);
        profileOrder.setVisibility(View.VISIBLE);
        arrOrder.clear();
        arrOrder.addAll(db.selectOrder( Login.getLogin(), 0));
        orderAdapter.notifyDataSetChanged();
        if(arrOrder.isEmpty()){
            scrMyOrder.setVisibility(View.GONE);
            tvThongBao.setVisibility(View.VISIBLE);
        }
        else {
            scrMyOrder.setVisibility(View.VISIBLE);
            tvThongBao.setVisibility(View.GONE);
        }
    }

    public void btnDaGiaoOnclick(View view) {
        btnDonDangGiao.setBackgroundColor(Color.rgb(192,192,192));
        btnDonDaGiao.setBackgroundColor(Color.rgb(232, 232, 232));
        tblGioHang.setVisibility(View.GONE);
        profileOrder.setVisibility(View.GONE);
        arrOrder.clear();
        arrOrder.addAll(db.selectOrder( Login.getLogin(), 1));
        orderAdapter.notifyDataSetChanged();
        if(arrOrder.isEmpty()){
            scrMyOrder.setVisibility(View.GONE);
            tvThongBao.setVisibility(View.VISIBLE);
        }
        else {
            scrMyOrder.setVisibility(View.VISIBLE);
            tvThongBao.setVisibility(View.GONE);
        }
    }

    public void BackInfoOnclickListener(View view) {
        Intent intent = new Intent(OrderDetailActivity.this, MainActivity.class);
        startActivity(intent);
    }
}