package com.example.a4foods.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.a4foods.Activity.MainActivity;
import com.example.a4foods.Admin.MainActivityAdmin;
import com.example.a4foods.db.MyDatabase;
import com.example.a4foods.model.User;
import com.example.doanapp.R;
import com.google.android.material.textfield.TextInputEditText;

public class Login extends AppCompatActivity {

    TextInputEditText edtEmail, edtPassword;
    MyDatabase db;
    static int login = 0;
    static String name = null;
    static String phone = null;
    static String address = null;


    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Login.name = name;
    }

    public static String getPhone() {
        return phone;
    }

    public static void setPhone(String phone) {
        Login.phone = phone;
    }

    public static String getAddress() {
        return address;
    }

    public static void setAddress(String address) {
        Login.address = address;
    }

    public static int getLogin() {
        return login;
    }

    public static void setLogin(int login) {
        Login.login = login;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new MyDatabase(Login.this);
        edtEmail = (TextInputEditText) findViewById(R.id.edtEmailLogin);
        edtPassword = (TextInputEditText) findViewById(R.id.edtPasswordLogin);

    }

    public void btnDK_onclick(View view) {
        Intent intent = new Intent(Login.this, Register.class);
        startActivity(intent);
    }

    public void btnLoginOnclick(View view) {
        String email = edtEmail.getText().toString().trim();
        String pass = edtPassword.getText().toString().trim();
        User user = db.Login(email, pass);
        if(user == null){
            Toast.makeText(Login.this, "Email hoặc mật khẩu không đúng!", Toast.LENGTH_LONG).show();
        } else {
            if(user.getRole() == 1){
                Intent intent = new Intent(Login.this, MainActivityAdmin.class);
                startActivity(intent);
            }else {
                setLogin(user.getIdUser());
                setName(user.getNameUser());
                setPhone(user.getPhone());
                setAddress(user.getAddress());
                Intent intent = new Intent(Login.this, MainActivity.class);
                intent.putExtra("user", user);
                startActivity(intent);
            }

        }
    }
}