package com.waterspringer.commonutils.map;

import com.alibaba.fastjson.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author Katie Qu
 * @date 2021/4/25
 */
public class BaiduMapGeocoderUtil {

    /**
     * 百度地图 Api调用相关的百度AK
     */
    public final static String BAIDU_MAP_AK = "fGMgRpveQAMOLaRGxolxqYi4QNzB3slT";
    /**
     * 根据经纬度调用百度API获取 地理位置信息，根据经纬度
     * @param longitude 经度
     * @param latitude 纬度
     * @return
     */
    public static String getAddressInfoByLngAndLat(String longitude,String latitude){
        JSONObject obj = new JSONObject();
        String location=latitude+","+longitude;
        //百度url  coordtype :bd09ll（百度经纬度坐标）、bd09mc（百度米制坐标）、gcj02ll（国测局经纬度坐标，仅限中国）、wgs84ll（ GPS经纬度）
        String url ="http://api.map.baidu.com/reverse_geocoding/v3/?ak="+BAIDU_MAP_AK+"&output=json&coordtype=wgs84ll&location="+location;
        String country = null;
        String province = null ;
        String city  = null;
        String district = null ;
        String town = null;
        try {
            String json = loadJSON(url);
            obj = JSONObject.parseObject(json);
            System.out.println(obj.toString());
            // status:0 成功
            String success="0";
            String status = String.valueOf(obj.get("status"));
            if(success.equals(status)){
                String result = String.valueOf(obj.get("result"));
                JSONObject resultObj = JSONObject.parseObject(result);
                String addressComponent = String.valueOf(resultObj.get("addressComponent"));
                JSONObject jsonObject = JSONObject.parseObject(addressComponent);
                country = (String) jsonObject.get("country");
                province = (String) jsonObject.get("province");

                city = (String) jsonObject.get("city");
                district = (String) jsonObject.get("district");
                town = (String) jsonObject.get("town");
                //JSON字符串转换成Java对象
                // AddressComponent addressComponentInfo = JSONObject.parseObject(addressComponent, AddressComponent.class);
                System.out.println("addressComponentInfo:"+addressComponent);
            }
        } catch (Exception e) {
            System.out.println("未找到相匹配的经纬度，请检查地址！");
        }
        return country + province + city + district + town;
    }

    public static String loadJSON(String url) {
        StringBuilder json = new StringBuilder();
        try {
            URL oracle = new URL(url);
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream(), "UTF-8"));
            String inputLine = null;
            while ((inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
            in.close();
        } catch (MalformedURLException e) {} catch (IOException e) {}
        return json.toString();
    }
}

