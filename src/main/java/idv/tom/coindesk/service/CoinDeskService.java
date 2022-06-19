package idv.tom.coindesk.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import idv.tom.coindesk.entity.CoinDeskDataEntity;

@Service
public class CoinDeskService {
	
	@Autowired
	DBService dbService;
	
	public Object getCoinDeskData() {
		final String url = "https://api.coindesk.com/v1/bpi/currentprice.json";
		ObjectMapper mapper = new ObjectMapper();
		Object jsonData = null;
		
		try {
			RestTemplate restTemplate = new RestTemplate();
			JsonNode jsonNodeData = mapper.readTree(restTemplate.getForObject(url, String.class));
			jsonData = jsonNodeData;
			System.out.println(jsonNodeData);
       	} catch (IOException e) {
           e.printStackTrace();
       	}
		return jsonData;
	}
	
	public CoinDeskDataEntity getCoinDeskDataSearch(String coinname) {
		return dbService.findByCoinName(coinname);
	}
	
	public List<CoinDeskDataEntity> getCoinDeskDataSearchAll() {
		return dbService.findAll();
	}
	
	public CoinDeskDataEntity setCoinDeskDataInsert(CoinDeskDataEntity requestData) {
		CoinDeskDataEntity coinDeskDataEntity = new CoinDeskDataEntity();
		coinDeskDataEntity.setCoinName(requestData.getCoinName());
		coinDeskDataEntity.setCoinCName(requestData.getCoinCName());
		coinDeskDataEntity.setRate(requestData.getRate());
		return dbService.insert(coinDeskDataEntity);
	}
	
	public CoinDeskDataEntity setCoinDeskDataUpdate(CoinDeskDataEntity requestData) {
		CoinDeskDataEntity coinDeskDataEntity = new CoinDeskDataEntity();
		coinDeskDataEntity.setCoinName(requestData.getCoinName());
		coinDeskDataEntity.setCoinCName(requestData.getCoinCName());
		coinDeskDataEntity.setRate(requestData.getRate());
		return dbService.insert(coinDeskDataEntity);
	}
	
	public void setCoinDeskDataDelete(String key) {
		dbService.deleteByKey(key);
	}
}