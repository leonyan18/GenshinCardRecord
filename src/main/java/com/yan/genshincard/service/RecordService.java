package com.yan.genshincard.service;

import com.yan.genshincard.entity.Card;

import java.util.List;
import java.util.Map;

public interface RecordService {

    public List<Card> getNoviceRecordService();

    public List<Card> getUpRecordService();

    public List<Card> getPermanentRecordService();

    public List<Card> getWeaponRecordService();
}
