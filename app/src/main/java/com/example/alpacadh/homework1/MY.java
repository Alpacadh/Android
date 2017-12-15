package com.example.alpacadh.homework1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Alpacadh on 2017/12/14.
 */

public class MY extends SQLiteOpenHelper {
    public static final String CREATE_USER = "create table User ("
            + "id integer primary key autoincrement, "
            + "username text, "
            +"phonenumber text,"
            +"sex text,"
            + "userpwd text)";

    public MY(Context context, String name, SQLiteDatabase.CursorFactory factory,
              int version) {
        super(context, name, factory, version);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub

        db.execSQL(CREATE_USER);//创建用户表
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub

    }

}
