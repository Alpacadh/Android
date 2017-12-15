package com.example.alpacadh.homework1;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.alpacadh.homework1.model.SqliteDB;
import com.example.alpacadh.homework1.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alpacadh on 2017/12/11.
 */


public  class Second extends AppCompatActivity {
    private MY deHelper;
    private Button back;
    private Button register;
    private EditText username;
    private EditText password;
    private Spinner sex;
    private EditText phonenumber;
    private TextView statett;
    private List<User> userList;
    private List<User> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        username = (EditText) findViewById(R.id.editText2);
        password = (EditText) findViewById(R.id.editText5);
        phonenumber = (EditText) findViewById(R.id.editText4);
        sex = (Spinner) findViewById(R.id.spinner);
        register = (Button) findViewById(R.id.button);
        back = (Button) findViewById(R.id.button123);
        statett=(TextView) findViewById(R.id.statet);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = username.getText().toString();
                String pass = password.getText().toString();
                String number = phonenumber.getText().toString();
                String se=sex.getSelectedItem().toString();
                User user=new User();
                user.setUsername(name);
                user.setUserpwd(pass);
                user.setPhonenumber(number);
                user.setSex(se);
                int result = SqliteDB.getInstance(getApplicationContext()).saveUser(user);
                if (result == 1) {
                    {
                        statett.setText("注册成功！");
                        Intent intent=new Intent(Second.this,HomeWorkActivity.class);
                        startActivity(intent);
                        finish();
                    }
                } else if (result == -1) {
                    statett.setText("用户名已经存在！");
                } else {
                    statett.setText("！");
                }

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Second.this,HomeWorkActivity.class);
                finish();
            }
        });
    }
}



