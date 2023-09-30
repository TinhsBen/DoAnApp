package com.example.a4foods.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.a4foods.db.MyDatabase;
import com.example.a4foods.model.Products;
import com.example.doanapp.R;
import com.google.android.material.textfield.TextInputEditText;

public class EditPro extends AppCompatActivity {

    TextInputEditText edNamePro, edDescription, edPricepro, edImagepro, edSizepro, edColor;
    Button btnCateAdminAdd, btnBrandAdminAdd, btnXoa, btnSua;
    MyDatabase db;
    Products pro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_pro);

        AnhXa();
        db = new MyDatabase(EditPro.this);

        Intent intent = getIntent();
        pro = (Products) intent.getSerializableExtra("productAdmin");

        String sCate = "Loại";
        switch (pro.getCategory()){
            case 1:
                sCate = "Gợi ý";
                break;
            case 2:
                sCate = "Mua nhiều";
                break;
            case 3:
                sCate = "Món mới";
                break;
            case 4:
                sCate = "Ngẫu nhiên";
                break;
        }
        String sbrand = "Mục";
        switch (pro.getBrand()){
            case 1:
                sbrand = "Combo";
                break;
            case 2:
                sbrand = "Cơm";
                break;
            case 3:
                sbrand = "Salad";
                break;
            case 4:
                sbrand = "Ăn vặt";
                break;
        }

        edNamePro.setText(pro.getName());
        edDescription.setText(pro.getDescription());
        btnCateAdminAdd.setText(sCate);
        btnBrandAdminAdd.setText(sbrand);
        edPricepro.setText(String.valueOf(pro.getPrice()));
        edImagepro.setText(pro.getImagePro());
        edSizepro.setText(pro.getNuoc());
        edColor.setText(pro.getAnkem());
    }

    public void XoaProAdmin(View view) {
        db.DeletePro(pro);
        Toast.makeText(EditPro.this, "Đã xóa", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(EditPro.this, MainActivityAdmin.class);
        startActivity(intent);
    }

    public void SuaProAdmin(View view) {
        String name = edNamePro.getText().toString();
        String des = edDescription.getText().toString();
        int cate = 1;
        switch (btnCateAdminAdd.getText().toString()){
            case "Gợi ý":
                cate = 1;
                break;
            case "Món mới":
                cate = 2;
                break;
            case "Mua nhiều":
                cate = 3;
                break;
            case "Ngẫu nhiên":
                cate = 4;
                break;
        }
        int brand = 1;
        switch (btnBrandAdminAdd.getText().toString()){
            case "Combo":
                brand = 1;
                break;
            case "Cơm":
                brand = 2;
                break;
            case "Salad":
                brand = 3;
                break;
            case "Ăn vặt":
                brand = 4;
                break;
        }
        int price = Integer.parseInt(edPricepro.getText().toString());
        String image = edImagepro.getText().toString();
        String size = edSizepro.getText().toString();
        String color = edColor.getText().toString();

        Products products = new Products(pro.getId(), name, des, cate, brand, price,image, size, color);
        db.EditPro(products);

        Toast.makeText(EditPro.this, "Sửa thành công", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(EditPro.this, MainActivityAdmin.class);
        startActivity(intent);

    }

    private void AnhXa() {
        edNamePro = (TextInputEditText) findViewById(R.id.edNamePro2);
        edDescription = (TextInputEditText) findViewById(R.id.edDescription2);
        edPricepro = (TextInputEditText) findViewById(R.id.edPricepro2);
        edImagepro = (TextInputEditText) findViewById(R.id.edImagepro2);
        edSizepro = (TextInputEditText) findViewById(R.id.edSizepro2);
        edColor = (TextInputEditText) findViewById(R.id.edColor2);
        btnCateAdminAdd = (Button) findViewById(R.id.btnCateAdminAdd2);
        btnBrandAdminAdd = (Button) findViewById(R.id.btnBrandAdminAdd2);
        btnXoa = (Button) findViewById(R.id.btnXoa);
        btnSua = (Button) findViewById(R.id.btnSua);
    }

    public void IconHomeAdminOnclickListener(View view) {
        Intent intent = new Intent(EditPro.this, MainActivityAdmin.class);
        startActivity(intent);
    }
}