package com.yan.genshincard.entity;

import lombok.Data;

import java.util.List;

/**
 * @author yan
 */
@Data
public class CardData {
    public CardData() {
    }

    public CardData(Integer count, Integer have, Integer average, Integer rank5Count,
                    Integer rank4Count, List<String> rank5CardList) {
        this.count = count;
        this.have = have;
        this.average = average;
        this.rank5Count = rank5Count;
        this.rank4Count = rank4Count;
        this.rank5CardList = rank5CardList;
    }

    private Integer count;
    private Integer have;
    private Integer average;
    private Integer rank5Count;
    private Integer rank4Count;
    private List<String> rank5CardList;

}
