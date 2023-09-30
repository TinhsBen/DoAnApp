package com.example.a4foods.Activity;
import com.example.a4foods.ui.Login;
import com.squareup.picasso.Picasso;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.a4foods.adapter.BrandAdapter;
import com.example.a4foods.adapter.ProductAdapter;
import com.example.a4foods.db.MyDatabase;
import com.example.a4foods.model.Brand;
import com.example.a4foods.model.Cart;
import com.example.a4foods.model.Products;
import com.example.doanapp.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ProductAdapter.Listener, BrandAdapter.Listener {

    Toolbar toolbarMain;
    DrawerLayout drawerLayoutMain;
    NavigationView nvMain;
    ImageView iconSearch, iconCart;
    RecyclerView rcvMonmoi, rcvGoiy, rcvMuanhieu, rcvNgaunhien, rcvBrand;
    ArrayList<Products> sneakerPro, theThaoPro, bongDaPro, runningPro;
    ProductAdapter sneakerAdapter, theThaoAdapter, bongDaAdapter, runningAdapter;
    ArrayList<Brand> brand;
    BrandAdapter brandAdapter;
    ViewFlipper viewFlipper;
    TextView tvHomeMenu, tvAllProMenu, tvCartMenu, tvFavoriteMenu, tvLoginMain, tvLogoutMain;
    public static MyDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        ActionToolBar();

        RecyclerViewMain();

        ViewPagerProduct();
        ActionViewFlipper();

        tvLoginMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        });


        if(Login.getLogin() != 0){
            tvLoginMain.setText(Login.getName());
            tvLogoutMain.setVisibility(View.VISIBLE);

            tvLogoutMain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Login.setLogin(0);
                    tvLoginMain.setText("Đăng nhập");
                    tvLogoutMain.setVisibility(View.GONE);
                    Toast.makeText(MainActivity.this, "Đã đăng xuất", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void ActionViewFlipper() {
        ArrayList<String> mangquangcao = new ArrayList<>();
        mangquangcao.add("https://lh3.googleusercontent.com/oHgn8XtjmSgcuOfw-gN5I51hKAH9wt4B5D5_TL9GAcXPV93zoe-2jsE6WVJbJJWObpTlZ-2stjO2PGSnJOTHyNAtWhiDJ1s_WnICcIkv-UG64HQv7dUrdkS7IF8hlphA3Fmwih8leEVomfkzeaNl78rz2uHrW5KkLXvE8-DhUVqBskDXxrHuZ9ubFiACpznrhffdliQhKEtavE6KTNtsWAFPfFDhx2PuC-a_wYtJ2FskxKpR12lBXHyFBQL0p8xQ7es0dkEsAgJdg7A-_YpG8RXA1OAdInjbGsK_o1NQB-JPDfbeixO9ejmKj2DpnaPZvBtsoB3W8f3orK8mfF53t7JuJAzxRZ3aHollouDFMg7VXRsFvrRX8R4Y9P6tRhSzhupZAvnkW3je5WV1Sg4Soj0tB-0SfVw4qyTkmMrjt1bAK9mBq94_3GE1BEPM_PABBJ7xUFfPg16ey9kQKYoqkyeTed103Q3TDMCLOy6C-00lsxFrj6tLO4GhEK6a8_k9c6BuBQBtYlqNLS_a2rEIlL-weNaPQlykRtIib81hiiK63Nmu_GK83Fh9GcbBoWb9I3xzCehUmMtH0jWLtZZb0idZpURhewC8jZxQXobZ5lQLNdkoPedbRjT-4Jl9GsU4gJMv9jUTSqO4AEhqSzPcZAPJtth_bCvR98JJbIK4ajWsAisfbhZSEDdk_OnwEJGb61s3JQz3BMAl20NvFqCiB16pLcPhCIWtrsEXo_9N1kWVOuw1Y1bS80mvEFhaE2TaGjFxHYMlKkuxWq00FlA1Ufp89MCZ5a8o9TX_1L8UJzsonjLihLtbvgPv0Y6pBfnb2capD7UIrN8A7Gr0MK_Da7lKvz5apqX4FodpJZUBnwIfjccaw5idVc1X9iVMAo_xppGUnvueE-rrXpaO5JWFecqbbISBDVTh0sE9bD1Wbj7cDedxnjuFAYO5U5iBqu6PQytSEVByJ7uPA8wceHauu7JLtF6bnr0toCaxVTr3Uqiw92U3i21nCIWfIC0OM15Pd8G_4ZvQB5tuo5sL2rqWUHkGmbBhasTXl-0HOknkj07G-M0tR-qrY-SBlr2Y0EbwTUKHRjwpZ76mICwq3GI0wGA0NfBDPildid_4HKjF8HwPA_mt6Hhwq3xDBSFo-zDJ4hyQM997D3bdYMuB7ybn2-FTSVmzL941HLpE1qHRBXnw=w626-h392-s-no?authuser=0");
        mangquangcao.add("https://lh3.googleusercontent.com/M6hgCZtshVvBPi9tW6J9_wQY9aCRw6o8RwAH3XyVY5vAgfdxZE74fpPrZ_31t5kn0qdusHMreXH_8fxQOXVxVyhEeXwUcRNjXU8YDaejiFDszFrQd_im3gOovCd64GQAzfCE9VFiXXg6BVLwTmtYowbTqZFEVszHflavd9fBmfetE2_ttJSMvCLH0bVob_5zre4VH7o9ajQMm9pzMFZeZNFYh2CFYjQh3_kdRiP2TilaIoVmYR36B9G2NP-roV6Nz3RoOapFNYR2B6v-ky3HaiB1QgLBNCABvmSckb7ptGzHMLeivHfZAcoLC6Ihf2ciUC4G0a7vG9vbrLEK2VFYqFA7xxDcFAKPybxQEfcOOVT6Omzk0tKW2-EC4WFn-4WMhZCndzI0twJ7yi8kx5vHhNFUYavcBbFF72UrOfTHco8JDi4TUQRl_GJcHlqw0a3mbRvrVF5RPbeMRoUUyzaasWwEibe9GaOAtLn_nLcX01gfT2xG7F9trLvIVmo8GjlO0rpn2YwEV_btMnW3f_MDZd_i_aF2YjUR6fqy44tcCzgifkft0xReq7g-fax-GxaciEPgBK0DM9dEE-kfYOUEAtQBS1eZljTgAx0Wde5Ga2oBGmBwKqWBGWi9QRj7HN_87AMnuFSVWRpNVvbmvGdBQ5fP3LJoZf6Q-FvyjINLYTPiAm_xJ67St6doB59fs29rFBrd838LrSaxEqAu9ulcJP0lSnAV_JznIet1OVRPWMEq5YeSAGdlkYCk_WwMwhPc8MxKqtYWeVW82AeOgrUUs_togOkF-GWSVuf29H8Ie3r9wESyNi_xHPr32JuXsREqRnw8WC2k8XhYcAvVPuRr56IPn3LC4w_c-c9dviuBgI7eBeQG9TZjinC_cnK2ynKDA7Nw-eXNZ21cYIOczMh9RGzHyhzrsYF4_iH6nT3AVllB0wBQApl83bLnfOhWM4Ra-rJBcMKWT9coxlCswZGFy51oF1UAFrUYZVJF6_slTySNgZLxI79apDylnoPxQ3edxCGYXqKQG6h-v5h0Q_2oyKY6neoRHuuoMgRHOSPSkCooMi_ubEuNQ9bFJunfNzIu9Hq67IWN3U8VRuWW3H3DhxvrZsmll2W_K4U3Rwnvq7oDEcFjWMQ_oqQbN_kQA13qvuNmYrtwn3mA8BPTnE6kGD7rQd83J5SpN-zKEmWco_YJ=w1425-h893-s-no?authuser=0");
        mangquangcao.add("https://lh3.googleusercontent.com/dgZNjbyfK5KsN-FAJglmVWUOPNzOXeRdEzC0JQJdrncAXR-65ieoT2Xxe-3bQYIxsh_jeGuFLktazIiGi1s5scQNVR_U8Kj-0Wn8rNkDK_WruAMVqwr79rUJa4j4AlKI5KhPHn3ZV45aSMW36z6RfNZ8lVg2C9a-npG_IO_Z94HmIkrgqJRN6EenTZBdSsidThlkMaOzYRcpoVZKl0IlFCPKNTujyMqKzyOBjnuj5ci8yCVzMWDn_ZoNtoWT3RIYw4jkEbsaVOmGJwTchX9_H_GTcxxZDSaedjypcbrrQV33TA8KzEY6kLIuNnJAwe1jEUS6yekuby3uF7BW7GEMkRUY9_Ms9JHGgGucijPRCnf9NyATk_I7obN_wO_buWwrRa1vU-ErDhpGFVwuoKbmooHhz35ZQ14vyToObEmgmLTfeP55zXZCEH2mS59dEqLvUL__gyhL_tWyGK3MdpKy4mxJPay7H275Ng__5KrXLNd7gyTgm5gkF1XKwb_ucyGDXYMR84L4HlK35Pbmgluy9ae5uFwuGbSbjahaBtDOz4y660hWWQ1ERSJg0_di1pVWWY4nhNDhny8Sjgurd9RGIRAJCxLAagqG0Diygm91dEjClhoAiD8iPEO8SeQcG1bp6Wwmyd6Bc1ef5qNiAotIuZvGTQzFs1fUNK0_Yz4SlqrTYWhn4aDfeZC1ixcMFmzxGBr4nhUASndLGnEuGyJq_sPng7xRcZRO9S1CmcJhH4YBknjPoSSPcRgEUhQ-59LKAlXOv_tu5zt73sfugrkJifc0GmXQ0g6HsM9bZvYHb-X8KkfFhx0FMK90wyhJwU8k_TJsrT4cxrP-JG6kGitEXoGnvS-04TkbAYaLUUUsxaWirW3U_s5fZQlANyjCc_PPYNXajE2uObzljuBvPKbXTyp7ody-2fE-LoKwo34y-z2-SzVzQZ2t7IbY3en0Dxi4_QvppjzgkpiUovSNOVPsh-rvgo4uQSOh5syzUJh9s3ZtO4rqBmC96jYDkPRuBiDmgBlnL2xkY6Yx8m1wt5TYfSoqjRsX6dM0CqOm_7xaDfVuwkMTq_CplfGlS5TUsfpZWEtMbeqW3Du4jVbYAWH2nnKfpqScbbBsDmbwbLUl7jhOkBRG5_KZPHlxrbJNuNY-9Z3AcrshmNzkd8JWCfwrfSR7uRyi7KgFY_IPw_J6AwLT=w1425-h893-s-no?authuser=0");
        mangquangcao.add("https://lh3.googleusercontent.com/E4xegl76ukAj-AOUcdzjchMSCdttVamh6LVffLSBkwUCNAIOJRR6Y5blEK2J_O-DpHUarBJ9Tc0qcuz5vPmSvnz65CQ4aMtYrMed4W4NL3d0IQXqBA0ZD3qcRURrsMvtUSt0QDn1NRjXzdFAKgpQcv25lci4-lAWKrvfH0Cg_Q-TGAWPQ_OawjrGsRRb13fa75N2uPO-6Xc7KlvFA0711_9Wp4MRzvWfiBgUNH8bCXvxL9K6ui7vxTtwTphiG6N2CiwRw1_OD0EBx_fyxSHBJTBe-M3Qd7VE8v4TRDq5seo7e4ujiPuQj_KK7c7PtRBjJ0ivsX2RRlIboJb9_Gz4SGEo98goRpom7FRu2kadxMOfStiaOJ2SB67EtMQsRukZwbPYf3M68jmM5NUIoYilVjKjP4dwqa5-8gUq-XqyzElIes03XngBkbJjbRXXrhKF0TeAy3ad6ayt0EUOfY-c8BrcxjJsUiwOSepA8zVqP0Kh_adTMzt3mm9s-wdTd7T3cvd4K2X5lZXIn-Pn2xhwhi39x6QV-cLjC1uPz6jRj-pHfhiFqayZQs1iOEmu7dwqKBTxuy28-OEiL54vXfZHya1K80YlCCl07yQTYbO7hBLGdVvE5Wf120yf9062bhoQQAnLzfhxQSuhruyL-G_DLs8LiZ4aoQoKTETvIA_IT7YPKWRMFl8_mN6thC1KCwnALFB3SDIvBhzqD0DmamXmS3ouHcwi_P4uVPctGD_GL1G-a9JMpTF-K7Y7Yqg-BdznEyY2Rot227pg6Os9-2bSE2YqxqNqwe8bgXeCHaTeu5vLiNrOmOou2qCFSwa6Q7OmgaZ7XtEjlY-Xq4kv8wVkaAWfzp0PfIkMaSyV_zKppEMnMImIultBEUbfg5kpiyZDKFB2HnfIEO3dWyEe-AOvVYW5O7Exz0R-7i0L5udmHR0gaDpVLICqq6Glqqm6W__sBu5Xzq8P19lTIijuXaF2n9WKD2oNme6QcpN1tzyy0UjueHKrTozDsP_gFSPWmbM0ie7d7dQh41OGdPxlh5hvtKbEzRkg1HBmf068hV1ylnavWlYhB_JWw-jx1Z1oPChyO0opsxU8mtwh0szAcBIwsW0mX_KSFZfgmue88evdwRnD-cAq1o8S9ed-VAkyO9o0q8pvuGDDdoWjTSXjq8UEZgCn-GzFtIJkEtrfvU8MeLK-=w626-h392-s-no?authuser=0");
        for (int i =0; i<mangquangcao.size();i++){
            ImageView imageView = new ImageView(getApplicationContext());
            Picasso.get().load(mangquangcao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(5000);
        viewFlipper.setAutoStart(true);
        Animation animation_slide_in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_right);
        Animation animation_slide_out = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_out_right);
        viewFlipper.setInAnimation(animation_slide_in);
        viewFlipper.setOutAnimation(animation_slide_out);
    }

    private void ViewPagerProduct() {
    }

    private void RecyclerViewMain() {

//        rcvTheThao.setHasFixedSize(true);
//        rcvSneaker.setHasFixedSize(true);
//        rcvRunning.setHasFixedSize(true);
//        rcvBongDa.setHasFixedSize(true);


        brand = database.brands();
        brandAdapter = new BrandAdapter(brand, MainActivity.this, MainActivity.this);
        rcvBrand.setAdapter(brandAdapter);
        rcvBrand.setLayoutManager(new GridLayoutManager(this, 2));


        sneakerPro = database.layDuLieuCategory(2);
        sneakerAdapter = new ProductAdapter(MainActivity.this, sneakerPro, MainActivity.this);
        rcvMuanhieu.setAdapter(sneakerAdapter);
        rcvMuanhieu.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));
        // rcvTheThao.addItemDecoration(new DividerItemDecoration(MainActivity.this, LinearLayoutManager.VERTICAL));


        theThaoPro = database.layDuLieuCategory(1);
        theThaoAdapter = new ProductAdapter(MainActivity.this, theThaoPro, MainActivity.this);
        rcvGoiy.setAdapter(theThaoAdapter);
        rcvGoiy.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));


        bongDaPro = database.layDuLieuCategory(4);
        bongDaAdapter = new ProductAdapter(MainActivity.this, bongDaPro, MainActivity.this);
        rcvNgaunhien.setAdapter(bongDaAdapter);
        rcvNgaunhien.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));


        runningPro = database.layDuLieuCategory(3);
        runningAdapter = new ProductAdapter(MainActivity.this, runningPro, MainActivity.this);
        rcvMonmoi.setAdapter(runningAdapter);
        rcvMuanhieu.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));




    }

    private void ActionToolBar() {
        setSupportActionBar(toolbarMain);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarMain.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayoutMain.openDrawer(GravityCompat.START);
            }
        });
    }

    private void AnhXa() {
        toolbarMain = (Toolbar) findViewById(R.id.toolbarMain);
        drawerLayoutMain = (DrawerLayout) findViewById(R.id.drawerMain);
        nvMain = (NavigationView) findViewById(R.id.nvMenu);
        iconSearch = (ImageView) findViewById(R.id.imvSearch);
        iconCart = (ImageView) findViewById(R.id.imgCart);
        rcvGoiy = (RecyclerView)findViewById(R.id.rcvGoiy);
        rcvMuanhieu = (RecyclerView)findViewById(R.id.rcvMuanhieu);
        rcvMonmoi = (RecyclerView)findViewById(R.id.rcvMonmoi);
        rcvNgaunhien = (RecyclerView)findViewById(R.id.rcvNgaunhien);
        rcvBrand = (RecyclerView) findViewById(R.id.rcvBrand);
        tvAllProMenu = (TextView) findViewById(R.id.tvMenuAllPro);
        tvHomeMenu = (TextView) findViewById(R.id.tvMenuHome);
        tvCartMenu = (TextView) findViewById(R.id.tvMenuCart);
        tvFavoriteMenu = (TextView) findViewById(R.id.tvMenuFavority);
        tvLoginMain = (TextView) findViewById(R.id.tvLoginMain);
        tvLogoutMain = (TextView) findViewById(R.id.tvLogoutMain);
        viewFlipper = findViewById(R.id.viewlipper);
        database = new MyDatabase(this);
    }

    @Override
    public void setOnItemClickListener(Products product) {

        Intent intentPro = new Intent(MainActivity.this, ProductInfo.class);
        intentPro.putExtra("product", product);
        startActivity(intentPro);

    }

    @Override
    public void setOnItemBrandClick(Brand brand) {

        Intent intentPro = new Intent(MainActivity.this, ShopActivity.class);
        ArrayList<Products> tmp = new ArrayList<Products>();
        tmp = database.layDuLieuBrand(brand.getId());
        intentPro.putExtra("pro", tmp);
        startActivity(intentPro);
    }

    public void itemMenuHomeOnClick(View view) {
    }

    public void itemMenuAllProOnClick(View view) {
        Intent intent = new Intent(this, ShopActivity.class);
        ArrayList<Products> tmp = new ArrayList<Products>();
        tmp = database.layTatCaDuLieu();
        intent.putExtra("pro", tmp);
        startActivity(intent);
    }

    public void itemMenuCartOnClick(View view) {
        Intent intent = new Intent(MainActivity.this, CartActivity.class);
        startActivity(intent);

    }


    public void IconSearchOnclickListener(View view) {
        Intent intent = new Intent(MainActivity.this, SearchActivity.class);
        intent.putExtra("flag", "user");
        startActivity(intent);
    }

    public void IconCartOnclickListener(View view) {

        Cart cart = null;
        Intent intent = new Intent(MainActivity.this, CartActivity.class);
        intent.putExtra("cart", cart);
        startActivity(intent);
    }

    public void itemMenuOrderOnClick(View view) {
        Intent intent = new Intent(MainActivity.this, OrderDetailActivity.class);
        startActivity(intent);
    }
}