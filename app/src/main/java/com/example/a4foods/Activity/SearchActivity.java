package com.example.a4foods.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.a4foods.Admin.EditPro;
import com.example.a4foods.adapter.ProductAdapter;
import com.example.a4foods.db.MyDatabase;
import com.example.a4foods.model.Products;
import com.example.doanapp.R;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity implements ProductAdapter.Listener {

    SearchView search;
    TextView tvEmpty;
    RecyclerView rvSearch;
    ArrayList<Products> products;
    ProductAdapter productAdapter;
    MyDatabase db;
    String flag = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        search = (SearchView) findViewById(R.id.sv_search);
        tvEmpty = (TextView) findViewById(R.id.tv_emptySearch);
        rvSearch = (RecyclerView) findViewById(R.id.rvSearch);
        db = new MyDatabase(SearchActivity.this);
        products = new ArrayList<Products>();

        products = db.layTatCaDuLieu();
        productAdapter = new ProductAdapter(SearchActivity.this, products, SearchActivity.this);
        rvSearch.setAdapter(productAdapter);
        rvSearch.setLayoutManager(new GridLayoutManager(this, 2));

        Intent intent = getIntent();
        flag = intent.getStringExtra("flag");

        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                products.clear();
                products.addAll(db.search(query));
                productAdapter.notifyDataSetChanged();

                if(productAdapter.getItemCount() > 0){
                    tvEmpty.setVisibility(View.GONE);
                }else {
                    tvEmpty.setVisibility(View.VISIBLE);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                products.clear();
                products.addAll(db.search(newText));
                productAdapter.notifyDataSetChanged();

                if(productAdapter.getItemCount() > 0){
                    tvEmpty.setVisibility(View.GONE);
                } else if (newText.isEmpty()) {
                    tvEmpty.setVisibility(View.VISIBLE);
                }else {
                    tvEmpty.setVisibility(View.GONE);
                }


                return false;
            }
        });
    }

    @Override
    public void setOnItemClickListener(Products product) {
        if(flag.equals("admin")){
            Intent intentEdit = new Intent(SearchActivity.this, EditPro.class);
            intentEdit.putExtra("productAdmin", product);
            startActivity(intentEdit);
        }
        if(flag.equals("user")){
            Intent intentPro = new Intent(SearchActivity.this, ProductInfo.class);
            intentPro.putExtra("product", product);
            startActivity(intentPro);
        }

    }
}