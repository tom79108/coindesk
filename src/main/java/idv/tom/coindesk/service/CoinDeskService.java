package idv.tom.coindesk.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.devtools.remote.client.HttpHeaderInterceptor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import idv.tom.coindesk.entity.CoinDeskDataEntity;
import idv.tom.coindesk.utils.CommonDataUtil;
import idv.tom.coindesk.vo.CoinData;
import idv.tom.coindesk.vo.DataTimeType;
import idv.tom.coindesk.vo.GetOldAPIRsVO;

@Service
public class CoinDeskService {
	@Autowired
	DBService dbService;
	
	public Object getCoinDeskData() {
		final String url = "https://api.coindesk.com/v1/bpi/currentprice.json";
		ObjectMapper mapper = new ObjectMapper();
		GetOldAPIRsVO getOldAPIRsVO = new GetOldAPIRsVO();
		JsonNode jsonNodeData = null;
		try {
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.setInterceptors(
				Collections.singletonList(
					new HttpHeaderInterceptor("Accept", MediaType.APPLICATION_JSON.toString())
				)
			);
			jsonNodeData = mapper.readTree(restTemplate.getForObject(url, String.class));
			String jsonString = CommonDataUtil.JavaObject2JsonString(jsonNodeData);
			getOldAPIRsVO = mapper.readValue(jsonString, GetOldAPIRsVO.class);
			JsonNodeDataMappingToDB(jsonNodeData, getOldAPIRsVO.getTime());
       	} catch (JsonProcessingException e) {
           e.printStackTrace();
       	}
		return jsonNodeData;
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
	public void JsonNodeDataMappingToDB(JsonNode jsonNodeData, DataTimeType dataTimeType) {
		ObjectMapper mapper = new ObjectMapper();
		CoinDeskDataEntity coinDeskDataEntity = new CoinDeskDataEntity();
		for(JsonNode coinData : jsonNodeData.findParents("code")) {
			try {
				String jsonString = mapper.writeValueAsString(coinData);
				CoinData coinDataVO = mapper.readValue(jsonString, CoinData.class);
				coinDeskDataEntity.setCoinName(coinDataVO.getCode());
				coinDeskDataEntity.setCoinCName(CoinCname.valueOf(coinDataVO.getCode()).getCoinCname());
				coinDeskDataEntity.setRate(coinDataVO.getRate_float());
				coinDeskDataEntity.setLastUpdateDate(dataTimeType.getUpdatedISO());
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