package com.example.alpacadh.homework1;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.alpacadh.homework1.model.User;

import java.util.ArrayList;
import java.util.List;

public class YourselfActivity extends AppCompatActivity {
      private EditText nickname;
      private EditText phone;
      private EditText gender;
      private Spinner sexx;
      private Button backk;
      private MY dbHelper;
    private List<User> userList;
    private List<User> dataList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yourself);
        nickname =(EditText)findViewById(R.id.nickname);
        phone=(EditText)findViewById(R.id.phone);
        sexx=(Spinner)findViewById(R.id.sexx);
        backk=(Button)findViewById(R.id.backk);

        String name=nickname.getText().toString();
        String number=phone.getText().toString();
        String sex=sexx.getSelectedItem().toString();
        SQLiteDatabase db=dbHelper.getWritableDatabase();


        backk.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent3=new Intent(YourselfActivity.this,HomeWorkActivity.class);
                startActivity(intent3);
                finish();
            }
        });
    }
}
