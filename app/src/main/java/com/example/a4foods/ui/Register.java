package com.example.a4foods.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.a4foods.db.MyDatabase;
import com.example.a4foods.model.User;
import com.example.doanapp.R;
import com.google.android.material.textfield.TextInputEditText;

public class Register extends AppCompatActivity {

    TextInputEditText edtName, edtPhone, edtEmail, edtPass, edtPassConfirm;
    MyDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtName = (TextInputEditText) findViewById(R.id.edtNameDki);
        edtPhone = (TextInputEditText) findViewById(R.id.edtPhoneDki);
        edtEmail = (TextInputEditText) findViewById(R.id.edtEmailDki);
        edtPass = (TextInputEditText) findViewById(R.id.edtPassDki);
        edtPassConfirm = (TextInputEditText) findViewById(R.id.edtPassDki2);
        db = new MyDatabase(Register.this);


    }

    public void btnLogIn1_onclick(View view) {
        Intent intent = new Intent(Register.this, Login.class);
        startActivity(intent);
    }

    public void RegisterOnclick(View view) {

        String name = edtName.getText().toString();
        String phone = edtPhone.getText().toString();
        String mail = edtEmail.getText().toString();
        String pass = edtPass.getText().toString();
        String passConfirm = edtPassConfirm.getText().toString();


        if(db.CheckRegister(mail)){
            Toast.makeText(this, "Email đã tồn tại!", Toast.LENGTH_SHORT).show();
        }
        else if(name.trim() == ""){
            edtName.setError("Tên không được bỏ trống!");
            edtName.setFocusableInTouchMode(true);
            edtName.setFocusable(true);
            edtName.requestFocus();
        }
        else if (phone.trim().length() != 10) {
            edtPhone.setError("Sđt phải gồm 10 số!");
            edtPhone.setFocusableInTouchMode(true);
            edtPhone.setFocusable(true);
            edtPhone.requestFocus();
        }
        else if (mail.trim() == "") {
            edtEmail.setError("Email không được bỏ trống!");
            edtEmail.setFocusableInTouchMode(true);
            edtEmail.setFocusable(true);
            edtEmail.requestFocus();
        }
        else if (pass.trim() == "") {
            edtPass.setError("Mật khẩu không được bỏ trống!");
            edtPass.setFocusableInTouchMode(true);
            edtPass.setFocusable(true);
            edtPass.requestFocus();
        }
        else if(!passConfirm.equals(pass)){
            Toast.makeText(this, "Mật khẩu xác nhận không hợp lệ!", Toast.LENGTH_SHORT).show();
        }
        else {
            User user = new User(name, mail, pass, phone, null, 0);
            db.AddUser(user);
            Toast.makeText(this, "Tạo tài khoản thành công", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Register.this, Login.class);
            startActivity(intent);
        }

    }
}