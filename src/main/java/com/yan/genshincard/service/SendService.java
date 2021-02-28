package com.yan.genshincard.service;

import com.yan.genshincard.entity.CardData;

/**
 * @author yan
 */
public interface SendService {
    void sendMessage(CardData novice,CardData up,CardData permanent,CardData weapon);
}
