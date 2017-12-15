package com.example.alpacadh.homework1;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.alpacadh.homework1.model.SqliteDB;
import com.example.alpacadh.homework1.model.User;

import java.util.ArrayList;
import java.util.List;

public class HomeWorkActivity extends AppCompatActivity {
    private EditText accounttext;
    private EditText passwordtext;
    private Button register;
    private Button login;
    private TextView state;
    private List<User> userList;
    private List<User> dataList = new ArrayList<>();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_work);
        register = (Button) findViewById(R.id.button2);
        login = (Button) findViewById(R.id.button1);
        accounttext = (EditText) findViewById(R.id.text1);
        passwordtext = (EditText) findViewById(R.id.editText3);
        state=(TextView) findViewById(R.id.state);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=accounttext.getText().toString();
                String pass=passwordtext.getText().toString();
                int
                result= SqliteDB.getInstance(getApplicationContext()).Quer(pass,name);
                if (result==1)
                {
                    state.setText("登录成功！");
                    Intent intent2=new Intent(HomeWorkActivity.this,YourselfActivity.class);
                    startActivity(intent2);
                    finish();
                }
                else if (result==0){
                    state.setText("用户名不存在！");

                }
                else if(result==-1)
                {
                    state.setText("密码错误！");
                }
                }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeWorkActivity.this,Second.class);
                startActivity(intent);

            }
        });
    }
}


