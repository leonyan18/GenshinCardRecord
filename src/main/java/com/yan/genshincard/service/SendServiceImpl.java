package com.yan.genshincard.service;

import com.yan.genshincard.entity.CardData;
import com.yan.genshincard.util.HttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yan
 */
@Service
public class SendServiceImpl implements SendService {
    @Value("${send.key}")
    private String sendKey;
    @Value("${template}")
    private String template;
    @Value(("${sendurl}"))
    private String url;
    @Override
    public void sendMessage(CardData novice, CardData up, CardData permanent,CardData weapon) {
        String result=makeTemplate(template,novice,"novice");
        result=makeTemplate(result,up,"up");
        result=makeTemplate(result,permanent,"permanent");
        result=makeTemplate(result,weapon,"weapon");
        Map<String, Object> map=new HashMap<>(2);
        map.put("title","原神抽卡统计");
        map.put("desp",result);
        HttpClient.doPost(url,map);
    }

    private String makeTemplate(String template,CardData data,String type){
        String result= template;
        result=result.replace(type+".count",String.valueOf(data.getCount()));
        result=result.replace(type+".average",String.valueOf(data.getAverage()));
        result=result.replace(type+".have",String.valueOf(data.getHave()));
        result=result.replace(type+".rank4count",String.valueOf(data.getRank4Count()));
        result=result.replace(type+".rank5count",String.valueOf(data.getRank5Count()));
        StringBuilder list= new StringBuilder();
        for (String s:data.getRank5CardList()) {
            list.append("   ");
            list.append(s);
        }
        result=result.replace(type+".list",list);
        return result;
    }
}
