package com.example.alpacadh.homework1.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.alpacadh.homework1.MY;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Alpacadh on 2017/12/14.
 */

    public class SqliteDB {

        public static final String DB_NAME = "sqlite_dbname";

        public static final int VERSION = 1;

        private static SqliteDB sqliteDB;

        private SQLiteDatabase db;

        private SqliteDB(Context context) {
            MY dbHelper = new MY(context, DB_NAME, null, VERSION);
            db = dbHelper.getWritableDatabase();
        }


        public synchronized static SqliteDB getInstance(Context context) {
            if (sqliteDB == null) {
                sqliteDB = new SqliteDB(context);
            }
            return sqliteDB;
        }

        public int  saveUser(User user) {
            if (user != null) {


                Cursor cursor = db.rawQuery("select * from User where username=?", new String[]{user.getUsername().toString()});
                if (cursor.getCount() > 0) {
                    return -1;
                } else {
                    try {
                        db.execSQL("insert into User(username,userpwd) values(?,?) ", new String[]{user.getUsername().toString(), user.getUserpwd().toString()});
                    } catch (Exception e) {
                        Log.d("错误", e.getMessage().toString());
                    }
                    return 1;
                }
            }
            else {
                return 0;
            }
        }

        /**
         * 从数据库读取User信息。
         */
        public List<User> loadUser() {
            List<User> list = new ArrayList<User>();
            Cursor cursor = db
                    .query("User", null, null, null, null, null, null);
            if (cursor.moveToFirst()) {
                do {
                    User user = new User();
                    user.setId(cursor.getInt(cursor.getColumnIndex("id")));
                    user.setUsername(cursor.getString(cursor
                            .getColumnIndex("username")));
                    user.setUserpwd(cursor.getString(cursor

                            .getColumnIndex("userpwd")));
                    list.add(user);
                } while (cursor.moveToNext());
            }
            return list;
        }

        public int Quer(String pwd,String name)
        {


            HashMap<String,String> hashmap=new HashMap<String,String>();
            Cursor cursor =db.rawQuery("select * from User where username=?", new String[]{name});

            // hashmap.put("name",db.rawQuery("select * from User where name=?",new String[]{name}).toString());
            if (cursor.getCount()>0)
            {
                Cursor pwdcursor =db.rawQuery("select * from User where userpwd=? and username=?",new String[]{pwd,name});
                if (pwdcursor.getCount()>0)
                {
                    return 1;
                }
                else {
                    return -1;
                }
            }
            else {
                return 0;
            }


        }
    }

