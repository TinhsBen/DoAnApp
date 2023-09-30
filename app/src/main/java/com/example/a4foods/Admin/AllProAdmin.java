package com.example.a4foods.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.a4foods.adapter.ProductAdapter;
import com.example.a4foods.db.MyDatabase;
import com.example.a4foods.model.Products;
import com.example.doanapp.R;
import com.example.a4foods.Activity.SearchActivity;

import java.util.ArrayList;

public class AllProAdmin extends AppCompatActivity implements ProductAdapter.Listener {

    RecyclerView rcvAllPro;
    ArrayList<Products> allPro;
    ProductAdapter proAdapter;
    ImageView imgBack;

    String flag = "";

    MyDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_pro_admin);

        rcvAllPro = (RecyclerView) findViewById(R.id.rcvAllPro);
        imgBack = (ImageView) findViewById(R.id.imgBack);
        database = new MyDatabase(AllProAdmin.this);

        allPro = (ArrayList<Products>) database.layTatCaDuLieu();
        proAdapter = new ProductAdapter(AllProAdmin.this, allPro, AllProAdmin.this);
        rcvAllPro.setAdapter(proAdapter);
        rcvAllPro.setLayoutManager(new GridLayoutManager(this, 2));


        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


    }

    @Override
    public void setOnItemClickListener(Products product) {
        Intent intentPro = new Intent(AllProAdmin.this, EditPro.class);
        intentPro.putExtra("productAdmin", product);
        startActivity(intentPro);

    }


    public void SearchOnclickListener(View view) {
        Intent intent = new Intent(AllProAdmin.this, SearchActivity.class);
        intent.putExtra("flag", "admin");
        startActivity(intent);
    }
}