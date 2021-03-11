package com.yan.genshincard.service;

import com.yan.genshincard.entity.CardData;

/**
 * @author yan
 */
public interface SendService {
    String sendMessage(String result);

    String makeTemplate(CardData novice,CardData up,CardData permanent,CardData weapon);
}
