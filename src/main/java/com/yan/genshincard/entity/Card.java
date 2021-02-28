package com.yan.genshincard.entity;

import lombok.Data;

import java.util.Date;
/**
 * @author yan
 */
@Data
public class Card {
    int gachaType;
    String itemType;
    String name;
    int rankType;
    Date time;
}
