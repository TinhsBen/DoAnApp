package com.example.a4foods.Admin;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.a4foods.db.MyDatabase;
import com.example.a4foods.model.Products;
import com.example.doanapp.R;
import com.google.android.material.textfield.TextInputEditText;

public class AddProduct extends AppCompatActivity {

    TextInputEditText edNamePro, edDescription, edPricepro, edImagepro, edSizepro, edColor;
    Button btnCateAdminAdd, btnBrandAdminAdd, btnThem;
    MyDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        AnhXa();
        db = new MyDatabase(AddProduct.this);

        String[] strBrand = db.selectNameBrand().split(",");
        btnBrandAdminAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialogColor = new AlertDialog.Builder(AddProduct.this);
                dialogColor.setItems(strBrand, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int c) {
                        btnBrandAdminAdd.setText(strBrand[c]);
                    }
                });
                dialogColor.create().show();
            }
        });


        String[] strCate = db.selectNameCategory().split(",");
        btnCateAdminAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialogColor = new AlertDialog.Builder(AddProduct.this);
                dialogColor.setItems(strCate, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int c) {
                        btnCateAdminAdd.setText(strCate[c]);
                    }
                });
                dialogColor.create().show();
            }
        });

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edNamePro.getText().toString();
                String des = edDescription.getText().toString();
                int cate = 1;
                switch (btnCateAdminAdd.getText().toString()){
                    case "Thể thao":
                        cate = 1;
                        break;
                    case "Sneaker":
                        cate = 2;
                        break;
                    case "Running":
                        cate = 3;
                        break;
                    case "Bóng đá":
                        cate = 4;
                        break;
                }
                int brand = 1;
                switch (btnBrandAdminAdd.getText().toString()){
                    case "Nike":
                        cate = 1;
                        break;
                    case "Adidas":
                        cate = 2;
                        break;
                    case "Mlb":
                        cate = 3;
                        break;
                    case "Puma":
                        cate = 4;
                        break;
                }
                int price = Integer.parseInt(edPricepro.getText().toString());
                String image = edImagepro.getText().toString();
                String size = edSizepro.getText().toString();
                String color = edColor.getText().toString();

                Products products = new Products(name, des, cate, brand, price,image, size, color);
                db.AddPro(products);

                Toast.makeText(AddProduct.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AddProduct.this, MainActivityAdmin.class);
                startActivity(intent);
            }
        });
    }

    private void AnhXa() {
        edNamePro = (TextInputEditText) findViewById(R.id.edNamePro);
        edDescription = (TextInputEditText) findViewById(R.id.edDescription);
        edPricepro = (TextInputEditText) findViewById(R.id.edPricepro);
        edImagepro = (TextInputEditText) findViewById(R.id.edImagepro);
        edSizepro = (TextInputEditText) findViewById(R.id.edSizepro);
        edColor = (TextInputEditText) findViewById(R.id.edColor);
        btnCateAdminAdd = (Button) findViewById(R.id.btnCateAdminAdd);
        btnBrandAdminAdd = (Button) findViewById(R.id.btnBrandAdminAdd);
        btnThem = (Button) findViewById(R.id.btnThem);
    }

    public void IconHomeAdminOnclickListener(View view) {
        Intent intent = new Intent(AddProduct.this, MainActivityAdmin.class);
        startActivity(intent);
    }
}