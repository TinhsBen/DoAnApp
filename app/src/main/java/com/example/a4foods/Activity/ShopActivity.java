package com.example.a4foods.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.a4foods.adapter.ProductAdapter;
import com.example.a4foods.db.MyDatabase;
import com.example.a4foods.model.Products;
import com.example.doanapp.R;

import java.util.ArrayList;

public class ShopActivity extends AppCompatActivity implements ProductAdapter.Listener {

    RecyclerView rcvAllPro;
    ArrayList<Products> allPro;
    ProductAdapter proAdapter;
    ImageView imgBack;
    Button btnHang, btnLoai, btnGia;
    String flag = "";

    MyDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        rcvAllPro = (RecyclerView) findViewById(R.id.rcvAllPro);
        imgBack = (ImageView) findViewById(R.id.imgBack);
        btnHang = (Button) findViewById(R.id.btnHang);
        btnLoai = (Button) findViewById(R.id.btnLoai);
        btnGia = (Button) findViewById(R.id.btnGia);
        database = new MyDatabase(ShopActivity.this);

        Intent intent = getIntent();
        allPro = (ArrayList<Products>) intent.getSerializableExtra("pro");
        proAdapter = new ProductAdapter(ShopActivity.this, allPro, ShopActivity.this);
        rcvAllPro.setAdapter(proAdapter);
        rcvAllPro.setLayoutManager(new GridLayoutManager(this, 2));


        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        ArrayList<String> s = database.layLoai();
        String[] cate = s.toArray(new String[s.size()]);
        btnLoai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialogColor = new AlertDialog.Builder(ShopActivity.this);
                dialogColor.setItems(cate, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int c) {
                        btnLoai.setText(cate[c]);
                        int idCate = database.layIdLoai(cate[c]);
                        allPro.clear();
                        allPro.addAll(database.layDuLieuCategory(idCate));
                        proAdapter.notifyDataSetChanged();
                    }
                });
                dialogColor.create().show();
            }
        });

    }

    @Override
    public void setOnItemClickListener(Products product) {
        Intent intentPro = new Intent(ShopActivity.this, ProductInfo.class);
        intentPro.putExtra("product", product);
        startActivity(intentPro);

    }


    public void SearchOnclickListener(View view) {
        Intent intent = new Intent(ShopActivity.this, SearchActivity.class);
        intent.putExtra("flag", "user");
        startActivity(intent);
    }
}