package com.example.a4foods.Activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.a4foods.ui.Login;
import com.example.a4foods.adapter.CartAdapter;
import com.example.a4foods.db.MyDatabase;
import com.example.a4foods.model.Cart;
import com.example.a4foods.model.Order;
import com.example.a4foods.model.Products;
import com.example.doanapp.R;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

public class PayProductActivity extends AppCompatActivity {

    ArrayList<Cart> arrCart;
    RecyclerView rcvOrder;
    CartAdapter cartAdapter;
    TextView tvNameUserOrder, tvPhoneUserOrder, tvAddressUserOrder, tvTienHang, tvTongTienHang, tvShip;
    Button btnOrder;
    MyDatabase db;
    int moneySum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_product);

        rcvOrder = (RecyclerView) findViewById(R.id.rcvOrder);
        tvNameUserOrder = (TextView) findViewById(R.id.tvNameUserOrder);
        tvPhoneUserOrder = (TextView) findViewById(R.id.tvPhoneUserOrder);
        tvAddressUserOrder = (TextView) findViewById(R.id.tvAddressUserOrder);
        tvTienHang = (TextView) findViewById(R.id.tvTienHang);
        tvTongTienHang = (TextView) findViewById(R.id.tvTongTienHang);
        tvShip = (TextView) findViewById(R.id.tvShip);
        btnOrder = (Button) findViewById(R.id.btnOrder);
        db = new MyDatabase(PayProductActivity.this);

        Intent intent = getIntent();
        tvNameUserOrder.setText(Login.getName());
        tvPhoneUserOrder.setText(Login.getPhone());
        tvAddressUserOrder.setText(Login.getAddress());
        arrCart = (ArrayList<Cart>) intent.getSerializableExtra("arrCartOrder");

        cartAdapter = new CartAdapter(this, arrCart, R.layout.item_info_pro);
        rcvOrder.setAdapter(cartAdapter);

        rcvOrder.setLayoutManager(new LinearLayoutManager(PayProductActivity.this, LinearLayoutManager.VERTICAL, false));
        rcvOrder.addItemDecoration(new DividerItemDecoration(PayProductActivity.this, LinearLayoutManager.VERTICAL));

        for (Cart item: arrCart) {
            Products pro = db.getInfoPro(item.getIdProCart());
            moneySum += pro.getPrice();
        }

        //don vi tien VN
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        String price = currencyVN.format(moneySum);
        tvTienHang.setText(price);

        if(moneySum > 3000000){
            tvShip.setPaintFlags(tvShip.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            tvTongTienHang.setText(price);
        }else {
            int tongTien = moneySum + 30000;
            String priceSum = currencyVN.format(tongTien);
            tvTongTienHang.setText(priceSum);
        }



        btnOrder.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(PayProductActivity.this);

                dialog.setContentView(R.layout.item_layout_tick);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                Button btnXemdonhang = dialog.findViewById(R.id.btnXemdonhang);
                Button btnHome = dialog.findViewById(R.id.btnHome);

                //sử dụng phương thức format() để định dạng ngày giờ hiện tại rồi gán cho chuỗi dateTime
                LocalDateTime current = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
                String dateTime = current.format(formatter);

                for (Cart item: arrCart) {
                    Order order = new Order(Login.getLogin(), item.getIdProCart(), item.getQuantity(), dateTime, item.getAnkem(), item.getNuoc(), Login.getName(), Login.getPhone(), Login.getAddress(), 0);
                    db.AddOrder(order);
                }

                
                btnXemdonhang.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(PayProductActivity.this, OrderDetailActivity.class);
                        startActivity(intent);
                    }
                });
                dialog.show();

                btnHome.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(PayProductActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });
    }

}