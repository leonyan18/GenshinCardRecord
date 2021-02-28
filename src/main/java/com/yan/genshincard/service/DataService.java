package com.yan.genshincard.service;

import com.yan.genshincard.entity.Card;
import com.yan.genshincard.entity.CardData;

import java.util.List;

/**
 * @author yan
 */
public interface DataService {
    /**
     * description: 抽卡分析
     * @param cards 1 抽卡列表
     * @return com.yan.genshincard.entity.CardData
     */
    CardData getCardData(List<Card> cards);

}
