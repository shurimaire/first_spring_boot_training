package com.awesome.promotion.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.awesome.contents.vo.Content;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service("promotionService")
public class PromotionService {
	
	@Value("${api.services.url}")
	private String serviceUrl;
	
	private RestTemplate restTemplate;
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	public PromotionService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
//	@HystrixCommand(fallbackMethod="getPromotionFallBackStubbed")
//	@HystrixCommand(fallbackMethod="getPromotionFallBackViaNetwork")
	public Content getPromotion() {		
		log.info("#### getPromotion is started");
//		return restTemplate.getForObject(String.format("%s/v1/promotion", serviceUrl), Content.class);
		return restTemplate.getForObject(String.format("%s/v1/promotions", serviceUrl), Content.class);
    }
	
//	@HystrixCommand(fallbackMethod="getPromotionFallBackStubbed")
//	public Content getPromotionFallBackViaNetwork() {
//		log.info("#### getPromotionFallBackViaNetwork is started");
//		return restTemplate.getForObject(String.format("%s/v1/promotiond", serviceUrl), Content.class);
//	}
//	
//	
//	public Content getPromotionFallBackStubbed() {
//		log.info("exec getPromotionFallBackStubbed");
//		Content content = new Content();
//		content.setCategory("action");
//		content.setGrade(5);
//		content.setHasEpisodes(false);
//		content.setId(70);
//		content.setPoster("https://occ-0-1007-1009.1.nflxso.net/art/45d17/fcfe82644f60b74072a0214a28c1f6d88aa45d17.webp");
//		content.setRate("12");
//		content.setRegDate("2018-04-18");
//		content.setRuntime(148);
//		content.setStillcut("https://occ-0-1007-1009.1.nflxso.net/art/c59d1/cae8d57e1483ba8d427575903d26be411f9c59d1.webp");
//		content.setSummary("정부의 개입이 불러온 어벤져스의 분열. 슈퍼히어로의 독립성을 위해 싸울 것인가. 아니면 정부의 입장에 따를 것인가.한 치의 양보도 없는 양편, 이 팽팽한 대립의 결말은?");
//		content.setTitle("캡틴아메리카: 시빌 워");
//		content.setVideo("dKrVegVI0Us");
//		content.setView(13);
//		content.setYear(2018);
//		return content;
//		}
	
}
