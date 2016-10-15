package com.ming.boomweather.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ming.boomweather.model.City;
import com.ming.boomweather.model.County;
import com.ming.boomweather.model.Province;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by temp on 2016/10/13.
 * 数据库操作类
 */

public class BoomWeatherDB {
    /**
     * 数据库名称
     */
    public static final String  DB_NAME = "boom_weather";
    public static final int DB_VERSION = 1;
    private static BoomWeatherDB boomWeatherDB;
    private SQLiteDatabase db;

    public BoomWeatherDB(Context context) {
        BoomWeatherOpenHelper boomWeatherOpenHelper = new BoomWeatherOpenHelper(context,DB_NAME,null,DB_VERSION);
        db = boomWeatherOpenHelper.getWritableDatabase();
    }
    public synchronized static BoomWeatherDB getInstance(Context context){
        if(boomWeatherDB==null){
            boomWeatherDB = new BoomWeatherDB(context);
        }
        return boomWeatherDB;
    }
    public void saveProvince(Province province){
        if(province!=null){
            ContentValues values = new ContentValues();
            values.put("province_name",province.getProvinceName());
            values.put("province_code",province.getProvinceCode());
            db.insert("Province",null,values);
        }
    }
    public List<Province> loadProvinces(){
        List<Province> list = new ArrayList<Province>();
        Cursor cursor = db.query("Province",null,null,null,null,null,null);
        if(cursor.moveToNext()){
            Province province = new Province();
            province.setId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));
            province.setProvinceName(cursor.getString(cursor.getColumnIndexOrThrow("province_name")));
            province.setProvinceCode(cursor.getString(cursor.getColumnIndexOrThrow("province_code")));
            list.add(province);
        }while (cursor.moveToNext());
        return list;
    }
    public void saveCity(City city){
        if(city!=null){
            ContentValues values = new ContentValues();
            values.put("city_name",city.getCityName());
            values.put("city_code",city.getCityCode());
            db.insert("City",null,values);
        }
    }
    public List<City> loadCities(){
        List<City> list = new ArrayList<City>();
        Cursor cursor = db.query("Province",null,null,null,null,null,null);
        if(cursor.moveToNext()){
            City city = new City();
            city.setId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));
            city.setCityName(cursor.getString(cursor.getColumnIndexOrThrow("city_name")));
            city.setCityCode(cursor.getString(cursor.getColumnIndexOrThrow("city_code")));
            list.add(city);
        }while (cursor.moveToNext());
        return list;
    }
    public void saveCounty(County county){
        if(county!=null){
            ContentValues values = new ContentValues();
            values.put("county_name",county.getCountyName());
            values.put("county_code",county.getCountyCode());
            db.insert("county",null,values);
        }

    }
    public List<County> loadCounties(){
        List<County> list = new ArrayList<County>();
        Cursor cursor = db.query("County",null,null,null,null,null,null,null);
        if(cursor.moveToNext()){
            County county = new County();
            county.setId(cursor.getInt(cursor.getColumnIndexOrThrow("county_id")));
            county.setCountyName(cursor.getString(cursor.getColumnIndexOrThrow("county_name")));
            county.setCountyCode(cursor.getString(cursor.getColumnIndexOrThrow("county_code")));
            list.add(county);
        }while (cursor.moveToNext());
        return list;
    }
}
