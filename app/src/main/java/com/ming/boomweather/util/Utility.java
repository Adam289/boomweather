package com.ming.boomweather.util;

import android.text.TextUtils;

import com.ming.boomweather.db.BoomWeatherDB;
import com.ming.boomweather.db.BoomWeatherOpenHelper;
import com.ming.boomweather.model.City;
import com.ming.boomweather.model.County;
import com.ming.boomweather.model.Province;

/**
 * Created by temp on 2016/10/15.
 * 处理返回结果保存到数据库
 */

public class Utility {
    public synchronized static boolean handleProvinceResponse(BoomWeatherDB boomWeatherDB, String response) {
        if (!TextUtils.isEmpty(response)) {
            String[] allProvinces = response.split(",");
            if (allProvinces != null && allProvinces.length > 0) {
                for (String p :
                        allProvinces) {
                    String[] array = p.split("\\|");
                    Province province = new Province();
                    province.setProvinceCode(array[0]);
                    province.setProvinceName(array[1]);
                    boomWeatherDB.saveProvince(province);
                }
                return true;
            }
        }
        return false;
    }

    public synchronized static boolean handleCityResponse(BoomWeatherDB boomWeatherDB, String response) {
        if (!TextUtils.isEmpty(response)) {
            String[] allCities = response.split(",");
            if (allCities != null && allCities.length > 0) {
                for (String c :
                        allCities) {
                    String[] array = c.split("\\|");
                    City city = new City();
                    city.setCityCode(array[0]);
                    city.setCityName(array[1]);
                    boomWeatherDB.saveCity(city);
                }
                return true;
            }
        }
        return false;
    }

    public synchronized static boolean handleCountyResponse(BoomWeatherDB boomWeatherDB, String response) {
        if (!TextUtils.isEmpty(response)) {
            String[] allCounties = response.split(",");
            if (allCounties != null && allCounties.length > 0) {
                for (String c :
                        allCounties) {
                    String[] array = c.split("\\|");
                    County county = new County();
                    county.setCountyCode(array[0]);
                    county.setCountyName(array[1]);
                    boomWeatherDB.saveCounty(county);
                }
                return true;
            }
        }
        return false;
    }

}
