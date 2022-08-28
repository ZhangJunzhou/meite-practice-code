package com.zjz.dataTransfer0005;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName JsonTest
 * @Author Junzhou Zhang
 * @Create 2022/8/28 15:06
 */
public class JsonTest {

    static String jsonStr = "{\n" +
            "    \"sites\": [\n" +
            "        {\n" +
            "            \"name\": \"蚂蚁课堂\",\n" +
            "            \"url\": \"www.itmayiedu.com\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"每特教育\",\n" +
            "            \"url\": \"http://meiteedu.com/\"\n" +
            "        }\n" +
            "    ]\n" +
            "}\n";
    public static void main(String[] args) {

////        // 解析json
//        JSONObject jsonObject = new JSONObject().parseObject(jsonStr);
//
//        JSONArray jsonArray = jsonObject.getJSONArray("sites");
//        for (Object object : jsonArray) {
//            JSONObject stObject = (JSONObject) object;
//            String name = stObject.getString("name");
//            String url = stObject.getString("url");
//            System.out.println(name + "---" + url);
//        }

        // 组装Json
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        JSONObject stObject = new JSONObject();
        stObject.put("name", "蚂蚁课堂");
        stObject.put("url", "http://www.itmayiedu.com");
        jsonArray.add(stObject);

        JSONObject stObject2 = new JSONObject();
        stObject2.put("name", "每特教育");
        stObject2.put("url", "http://www.itmayiedu.com");
        jsonArray.add(stObject2);
        jsonObject.put("sites", jsonArray);

        System.out.println(jsonObject.toJSONString());
    }

}
