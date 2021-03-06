package com.ming.boomweather.db;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by temp on 2016/10/13.
 * 数据库帮助类
 */

public class BoomWeatherOpenHelper extends SQLiteOpenHelper {
    /**
     * Province表的创建
     */
    public static final String CREATE_PROVINCE = "create table Province("
            +"id integer primary key autoincrement, "
            +"province_name text, "
            +"province_code text)";
    /**
     * City表的创建
     */
    public static final String CREATE_CITY = "create table City("
            +"id integer primary key autoincrement, "
            +"city_name text, "
            +"city_code text, "
            +"province_id integer) ";
    /**
     * County表的创建
     */
    public static final String CREATE_COUNTY = "create table County("
            +"id integer primary key autoincrement, "
            +"county_name text, "
            +"county_code text, "
            +"city_id integer)";
    public BoomWeatherOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public BoomWeatherOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_PROVINCE);//创建省表
        db.execSQL(CREATE_CITY);//创建城市表
        db.execSQL(CREATE_COUNTY);//创建区县表
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
