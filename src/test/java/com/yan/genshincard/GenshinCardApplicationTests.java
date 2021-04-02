package com.yan.genshincard;

import com.yan.genshincard.entity.Card;
import com.yan.genshincard.entity.CardData;
import com.yan.genshincard.service.DataService;
import com.yan.genshincard.service.RecordService;
import com.yan.genshincard.service.SendService;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.util.List;

@SpringBootTest
class GenshinCardApplicationTests {
	@Autowired
	private RecordService recordService;

	@Autowired
	private DataService dataService;

	@Autowired
	private SendService sendService;
	@Test
	void contextLoads() {
	}
	@Test
	void testRecordService(){
		List<Card> cardList=recordService.getPermanentRecordService();
		CardData permanent=dataService.getCardData(cardList);
		cardList=recordService.getUpRecordService();
		CardData up=dataService.getCardData(cardList);
		cardList=recordService.getWeaponRecordService();
		CardData weapon=dataService.getCardData(cardList);
		cardList=recordService.getNoviceRecordService();
		CardData novice=dataService.getCardData(cardList);
		String ans=sendService.makeTemplate(novice,up,permanent,weapon);
		System.out.println("==============================");
		System.out.println(ans);
		System.out.println("==============================");
		if(permanent.getCount()+up.getCount()+weapon.getCount()>0)
			System.out.println(sendService.sendMessage(ans));
	}

}
