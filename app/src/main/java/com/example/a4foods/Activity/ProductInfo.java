package com.example.a4foods.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a4foods.Fragment.Fragment1;
import com.example.a4foods.ui.Login;
import com.example.a4foods.adapter.ViewPagerAdapter;
import com.example.a4foods.db.MyDatabase;
import com.example.a4foods.model.Cart;
import com.example.a4foods.model.Products;
import com.example.doanapp.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputEditText;

import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class ProductInfo extends AppCompatActivity {

    ViewPager vpPro;
    TabLayout tabLayout;
    ViewPagerAdapter viewAdap;
    TextView tvName, tvPrice, tvDes, tvQuantity;
    Button btnAddCart, btnAnkem, btnNuoc;
    ImageView subQuantity, sumQuantity;
    Products pro;
    MyDatabase db;
    Fragment1 fragment1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_info);

        AnhXa();



        Intent intent = getIntent();
        pro = (Products) intent.getSerializableExtra("product");

        try {
            InputStream is = this.getAssets().open(pro.getImagePro());
            Bitmap bitmap = BitmapFactory.decodeStream(is);
            viewAdap = new ViewPagerAdapter(getSupportFragmentManager(), bitmap);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        vpPro.setAdapter(viewAdap);
        tabLayout.setupWithViewPager(vpPro);

        //vpPro.setBackgroundResource(R.drawable.adidas_boost_cloud1);
        tvName.setText(pro.getName());
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        String price = currencyVN.format(pro.getPrice());
        tvPrice.setText(price);
        tvDes.setText(pro.getDescription());



        String[] ankems = pro.getAnkem().split(" ");
        btnAnkem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialogColor = new AlertDialog.Builder(ProductInfo.this);
                dialogColor.setItems(ankems, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int c) {
                        btnAnkem.setText(ankems[c]);
                    }
                });
                dialogColor.create().show();
            }
        });


        String[] option = pro.getNuoc().split(" ");
        btnNuoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialogSize = new AlertDialog.Builder(ProductInfo.this);
                dialogSize.setItems(option, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        btnNuoc.setText("Nước " + option[i]);
                    }
                });
                dialogSize.create().show();
            }
        });


        btnAddCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(btnNuoc.getText().toString().equals("Nước")){
                    Toast.makeText(ProductInfo.this, "Vui lòng chọn nước!", Toast.LENGTH_LONG).show();
                } else if (btnAnkem.getText().toString().equals("Đồ ăn kèm")) {
                    Toast.makeText(ProductInfo.this, "Vui lòng chọn đồ ăn kèm!", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(ProductInfo.this, CartActivity.class);
                    Cart cart = new Cart(pro.getId(), Login.getLogin(), Integer.parseInt(tvQuantity.getText().toString()), btnAnkem.getText().toString(), btnNuoc.getText().toString());
                    db.CheckAndAddCart(cart);
                    startActivity(intent);
                }

            }
        });

    }


    private void AnhXa() {
        vpPro = (ViewPager) findViewById(R.id.vp_SP);
        tvName = (TextView) findViewById(R.id.tvTenSP);
        tvPrice = (TextView) findViewById(R.id.tvGia);
        tvDes = (TextView) findViewById(R.id.tvMota);
        tabLayout = findViewById(R.id.tablo_SP);
        vpPro = (ViewPager) findViewById(R.id.vp_SP);
        btnAddCart = (Button) findViewById(R.id.btnAddSP);
        btnAnkem = (Button) findViewById(R.id.btnAnkem);
        btnNuoc = (Button) findViewById(R.id.btnNuoc);
        tvQuantity = (TextView) findViewById(R.id.tvQuantityCart);
        sumQuantity = (ImageView) findViewById(R.id.sumQuantity);
        subQuantity = (ImageView) findViewById(R.id.subQuantity);
        db = new MyDatabase(ProductInfo.this);

    }

    public void SumQuantityOnclick(View view) {
        String quantity = tvQuantity.getText().toString();
        int intQuantity = Integer.parseInt(quantity);
        intQuantity++;
        tvQuantity.setText(String.valueOf(intQuantity));
    }

    public void SubQuantityOnclick(View view) {
        String quantity = tvQuantity.getText().toString();
        int intQuantity = Integer.parseInt(quantity);
        if(intQuantity != 1){
            intQuantity--;
            tvQuantity.setText(String.valueOf(intQuantity));
        }
    }

    public void IconCartInInfoOnclickListener(View view) {
        Intent intent = new Intent(ProductInfo.this, CartActivity.class);
        startActivity(intent);
    }

    public void BackInfoOnclickListener(View view) {
        onBackPressed();
    }

    public void btnMuaNgayOnclick(View view) {

        if(btnNuoc.getText().toString().equals("Nước")){
            Toast.makeText(ProductInfo.this, "Vui lòng chọn nước!", Toast.LENGTH_LONG).show();
        } else if (btnAnkem.getText().toString().equals("Đồ ăn kèm")) {
            Toast.makeText(ProductInfo.this, "Vui lòng chọn đồ ăn kèm!", Toast.LENGTH_LONG).show();
        } else {

            if(Login.getLogin() == 0) {
                Dialog dialog = new Dialog(ProductInfo.this);

                dialog.setContentView(R.layout.item_layout_thongtin);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                Button btnXacNhan = dialog.findViewById(R.id.btnXacnhan);
                TextInputEditText edtName = dialog.findViewById(R.id.edtName);
                TextInputEditText edtAddress = dialog.findViewById(R.id.edtAddress);
                TextInputEditText edtPhone = dialog.findViewById(R.id.edtPhone);
                TextView tvLoginInCart = dialog.findViewById(R.id.tvLoginInCart);

                tvLoginInCart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(ProductInfo.this, Login.class);
                        startActivity(intent);
                    }
                });

                btnXacNhan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Cart cart = new Cart(pro.getId(), Integer.parseInt(tvQuantity.getText().toString()), btnAnkem.getText().toString(), btnNuoc.getText().toString());
                        ArrayList<Cart> arrCart = new ArrayList<Cart>();
                        arrCart.add(cart);

                        Intent intent = new Intent(ProductInfo.this, PayProductActivity.class);
                        intent.putExtra("arrCartOrder", arrCart);
                        intent.putExtra("name", edtName.getText().toString());
                        intent.putExtra("address", edtAddress.getText().toString());
                        intent.putExtra("phone", edtPhone.getText().toString());
                        startActivity(intent);


                    }
                });
                dialog.show();
            }else {
                Cart cart = new Cart(pro.getId(), Login.getLogin(), Integer.parseInt(tvQuantity.getText().toString()), btnAnkem.getText().toString(), btnNuoc.getText().toString());

                ArrayList<Cart> arrCart = new ArrayList<Cart>();
                arrCart.add(cart);
                Intent intent = new Intent(ProductInfo.this, PayProductActivity.class);
                intent.putExtra("arrCartOrder", arrCart);
                startActivity(intent);
            }

        }
    }
}