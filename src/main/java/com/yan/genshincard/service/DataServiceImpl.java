package com.yan.genshincard.service;

import com.yan.genshincard.entity.Card;
import com.yan.genshincard.entity.CardData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yan
 */
@Service
public class DataServiceImpl implements DataService {

    @Override
    public CardData getCardData(List<Card> cards) {
        Integer count = cards.size();
        Integer have = 0;
        Integer rank5Count = 0;
        Integer rank4Count = 0;
        Integer average=0;
        List<String> rank5CardList=new ArrayList<>();
        // 先倒过来算 以后好改进
        for (int i = cards.size()-1; i>=0; i--) {
            Card card = cards.get(i);
            have++;
            if (card.getRankType() == 5) {
                rank5CardList.add(makeString(card.getName(),have));
                average+=have;
                rank5Count++;
                have = 0;
            }
            if (card.getRankType() == 4) {
                rank4Count++;
            }
        }
        if(rank5Count!=0){
            average=average / rank5Count;
        }
        return new CardData(count, have, average, rank5Count, rank4Count,rank5CardList);
    }
    private String makeString(String name,int count){
        StringBuilder stringBuilder=new StringBuilder(name);
        stringBuilder.append("(");
        stringBuilder.append(count);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

}
