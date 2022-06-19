package idv.tom.coindesk.service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CoinDeskService {
	
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
	
	public String getCoinDeskDataSearch() {
		return "Select";
	}
	
	public String setCoinDeskDataInsert() {
		return "Insert";
	}
	
	public String setCoinDeskDataUpdate() {
		return "Update";
	}
	
	public String setCoinDeskDataDelete() {
		return "Delete";
	}
}