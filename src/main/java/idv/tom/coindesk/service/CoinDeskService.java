package idv.tom.coindesk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import idv.tom.coindesk.entity.CoinDeskDataEntity;
import idv.tom.vo.GetOldAPIRsVO;

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
			JsonNodeDataMappingToDB(jsonNodeData);
       	} catch (JsonProcessingException e) {
           e.printStackTrace();
       	}
		return jsonData;
	}
	
	enum CoinCname
	{
		USD("美元"), EUR("歐元"), GBP("英鎊");
		private final String cName;
	    private CoinCname(String cName) {
	        this.cName = cName;
	    }
	    
	    public String getCoinCname() {
	    	return cName;
	    }
	}
	public void JsonNodeDataMappingToDB(JsonNode jsonNodeData) {
		ObjectMapper mapper = new ObjectMapper();
		CoinDeskDataEntity coinDeskDataEntity = new CoinDeskDataEntity();
		for(JsonNode coinData : jsonNodeData.findParents("code")) {
			try {
				String jsonString = mapper.writeValueAsString(coinData);
				GetOldAPIRsVO getOldAPIRsVO = mapper.readValue(jsonString, GetOldAPIRsVO.class);
				coinDeskDataEntity.setCoinName(getOldAPIRsVO.getCode());
				coinDeskDataEntity.setCoinCName(CoinCname.valueOf(getOldAPIRsVO.getCode().toString()).getCoinCname());
				coinDeskDataEntity.setRate(getOldAPIRsVO.getRate_float());
				coinDeskDataEntity.setLastUpdateDate(jsonNodeData.get("time").get("updatedISO").toString());
				setCoinDeskDataInsert(coinDeskDataEntity);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
	}
	
	public CoinDeskDataEntity getCoinDeskDataSearch(String coinname) {
		return dbService.findByCoinName(coinname);
	}
	
	public List<CoinDeskDataEntity> getCoinDeskDataSearchAll() {
		return dbService.findAll();
	}
	
	public CoinDeskDataEntity setCoinDeskDataInsert(CoinDeskDataEntity requestData) {
		return dbService.insert(requestData);
	}
	
	public CoinDeskDataEntity setCoinDeskDataUpdate(CoinDeskDataEntity requestData) {
		return dbService.update(requestData);
	}
	
	public String setCoinDeskDataDelete(String key) {
		return dbService.deleteByKey(key);
	}
}