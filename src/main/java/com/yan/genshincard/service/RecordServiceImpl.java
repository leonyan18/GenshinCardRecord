package com.yan.genshincard.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yan.genshincard.entity.Card;
import com.yan.genshincard.entity.GacheType;
import com.yan.genshincard.util.HttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author yan
 */
@Service
public class RecordServiceImpl implements RecordService {
    @Value("${get.url}")
    private String getUrl;
    @Value("${base.url}")
    private String baseUrl;

    public List<Card> getRecordService(int gachaType) {
        List<Card> cardList = new ArrayList<>();
        int page = 1;
        Map<String, String> map = makeMap();
        map.put("gacha_type",String.valueOf(gachaType));
        Long end_id=0L;
        while (true) {
            map.put("end_id",String.valueOf(end_id));
            map.put("page", String.valueOf(page));
            String result=HttpClient.doGet(makeUrl(getUrl,map));
            if(JSONObject.parseObject(result).getString("data")==null){
                System.out.println("==============================");
                System.out.println("+++++++++地址错误或失效,请重新填写+++++++++");
                System.out.println("==============================");
                return cardList;
            }
            JSONArray jsonArray=JSONObject.parseObject(result).getJSONObject("data").getJSONArray("list");
            List<Card> pageCardData=jsonArray.toJavaList(Card.class);
            if(pageCardData.size()==0){
                break;
            }
            end_id=pageCardData.get(pageCardData.size()-1).getId();
            cardList.addAll(pageCardData);
            page++;
        }
        return cardList;
    }

    private Map<String, String> makeMap() {
        Map<String, String> map = new HashMap<>(10);
        baseUrl=baseUrl.replace("#/log","");
        String[] values = baseUrl.split("\\u003F");
        String[] keys = values[1].split("&");
        for (String key : keys) {
            String[] pair = key.split("=");
            map.put(pair[0], pair[1].replaceAll("%25","%"));
        }
        map.put("size", "20");
        return map;
    }

    private String makeUrl(String url, Map<String, String> map) {
        if(map.size()==0){
            return url;
        }
        StringBuilder temp=new StringBuilder("");
        for (Map.Entry<String, String> entry:map.entrySet()) {
            temp.append("&"+entry.getKey()+"="+entry.getValue());
        }
        temp.setCharAt(0, '?');
        String param=temp.toString();
        return url+param;

    }

    @Override
    public List<Card> getNoviceRecordService() {
        return getRecordService(GacheType.NOVICE.getValue());
    }

    @Override
    public List<Card> getUpRecordService() {
        return getRecordService(GacheType.UP.getValue());
    }

    @Override
    public List<Card> getPermanentRecordService() {
        return getRecordService(GacheType.PERMANENT.getValue());
    }

    @Override
    public List<Card> getWeaponRecordService() {
        return getRecordService(GacheType.WEAPON.getValue());
    }

}
