package com.auc.common.schedule;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AucSchedule {
	
	private static Logger log = LoggerFactory.getLogger(AucSchedule.class);
	
	//	1 2 3 4 5 6  // 순서
	//	* * * * * *  // 실행주기 문자열
	//
	//	// 순서별 정리
	//	1. 초(0-59)
	//	2. 분(0-59)
	//	3. 시간(0-23)
	//	4. 일(1-31)
	//	5. 월(1-12)
	//	6. 요일(0-7)
	
	@Scheduled(cron = "0 20 * * * *")
	public void sch1()  throws Exception{		
		//현재날짜 -1
		String reqDate = LocalDate.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyyMMdd"));				
		log.info("scheduled sch1  : " + reqDate);
		
	}
	
}
