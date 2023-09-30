package com.example.a4foods.Admin;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a4foods.adapter.OrderAdapter;
import com.example.a4foods.db.MyDatabase;
import com.example.doanapp.R;
import com.example.a4foods.model.Order;

import java.util.ArrayList;

public class OrderDetailAdminActivity extends AppCompatActivity {

    ArrayList<Order> arrOrder;
    RecyclerView rcvOrder;
    OrderAdapter orderAdapter;
    TextView tvMaDon, tvNameOrder, tvPhoneUserOrder, tvAddressUserOrder, tvTongTienHang;
    Order order;
    MyDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail_admin);

        db = new MyDatabase(OrderDetailAdminActivity.this);
        rcvOrder = (RecyclerView) findViewById(R.id.rcvOrderForAdmin);
        tvMaDon = (TextView) findViewById(R.id.tvMaDonForAdmin);
        tvNameOrder = (TextView) findViewById(R.id.tvNameForAdmin);
        tvPhoneUserOrder = (TextView) findViewById(R.id.tvSdtForAdmin);
        tvAddressUserOrder = (TextView) findViewById(R.id.tvDiaChiForAdmin);

        Intent intent = getIntent();
        order = (Order) intent.getSerializableExtra("orderAdmin");
        arrOrder = db.selectOrder(order.getIdUserOrder(), 0);


        tvMaDon.setText("Mã đơn hàng: 0" + String.valueOf(order.getIdOrder()));
        tvNameOrder.setText("Tên: " + order.getName());
        tvPhoneUserOrder.setText("SĐT: " + order.getPhone());
        tvAddressUserOrder.setText("Địa chỉ: " + order.getAddress());

        orderAdapter = new OrderAdapter(OrderDetailAdminActivity.this, arrOrder, R.layout.item_info_pro);
        rcvOrder.setAdapter(orderAdapter);

        rcvOrder.setLayoutManager(new LinearLayoutManager(OrderDetailAdminActivity.this, LinearLayoutManager.VERTICAL, false));
        rcvOrder.addItemDecoration(new DividerItemDecoration(OrderDetailAdminActivity.this, LinearLayoutManager.VERTICAL));
    }

    public void backOnclickListener(View view) {
        onBackPressed();
    }

    public void IconHomeAdminOnclickListener(View view) {
        Intent intent = new Intent(OrderDetailAdminActivity.this, MainActivityAdmin.class);
        startActivity(intent);
    }

    public void btnDaGiaoHangOnclick(View view) {
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setTitle("Xác nhận");
        b.setMessage("Đơn hàng đã hoàn thành?");
        b.setPositiveButton("Xác nhận", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                db.EditOrder(order, 1);
                Toast.makeText(OrderDetailAdminActivity.this, "Thành công!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(OrderDetailAdminActivity.this, ListOrderForAdmin.class);
                startActivity(intent);
            }
        });
        b.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        AlertDialog al = b.create();
        al.show();

    }
}