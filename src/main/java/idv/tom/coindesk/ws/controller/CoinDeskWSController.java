package idv.tom.coindesk.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import idv.tom.coindesk.entity.CoinDeskDataEntity;
import idv.tom.coindesk.service.CoinDeskService;

@RestController
@RequestMapping("/ws")
public class CoinDeskWSController {
	@Autowired
	CoinDeskService coinDeskService;
	
	@GetMapping({"/OldAPIData", "/OldAPIData/*"})
	public Object OldCoinDeskData() {
		return coinDeskService.getCoinDeskData();
	}
	
	@PostMapping({"/OldAPIToNewAPI", "/OldAPIToNewAPI/*"})
	public List<CoinDeskDataEntity> OldAPIToNewAPI() {
		return coinDeskService.TodoOldAPIToNewAPI();
	}
	
	@GetMapping("/CoinDeskAPI/{coinname}")
	public CoinDeskDataEntity CoinDeskDataSelect(@PathVariable String coinname) {
		return coinDeskService.getCoinDeskDataSearch(coinname);
	}
	
	@GetMapping("/CoinDeskAPI")
	public List<CoinDeskDataEntity> CoinDeskDataSelect() {
		return coinDeskService.getCoinDeskDataSearchAll();
	}
	
	@PostMapping("/CoinDeskAPI/{coinname}&{coincname}&{rate}")
	public CoinDeskDataEntity CoinDeskDataInsert(@PathVariable String coinname,@PathVariable String coincname,@PathVariable String rate) {
		CoinDeskDataEntity coinDeskDataEntity = new CoinDeskDataEntity();
		coinDeskDataEntity.setCoinName(coinname);
		coinDeskDataEntity.setCoinCName(coincname);
		coinDeskDataEntity.setRate(rate);
		return coinDeskService.setCoinDeskDataInsert(coinDeskDataEntity);
	}
	
	@PutMapping("/CoinDeskAPI/{coinname}&{coincname}&{rate}")
	public CoinDeskDataEntity CoinDeskDataUpdate(@PathVariable String coinname, @PathVariable String coincname, @PathVariable String rate) {
		CoinDeskDataEntity coinDeskDataEntity = new CoinDeskDataEntity();
		coinDeskDataEntity.setCoinName(coinname);
		coinDeskDataEntity.setCoinCName(coincname);
		coinDeskDataEntity.setRate(rate);
		return coinDeskService.setCoinDeskDataUpdate(coinDeskDataEntity);
	}
	
	@DeleteMapping("/CoinDeskAPI/{coinname}")
	public String CoinDeskDataDelete(@PathVariable String coinname) {
		return coinDeskService.setCoinDeskDataDelete(coinname);
	}
	
	
	@GetMapping(value="/Json/OldAPIData", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object OldCoinDeskData(@RequestBody CoinDeskDataEntity requestBody) {
		return coinDeskService.getCoinDeskData();
	}
	
	@GetMapping(value="/CoinDeskAPI/Json", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object CoinDeskDataSelect(@RequestBody CoinDeskDataEntity requestBody) {
		if(null == requestBody.getCoinName()) {
			return coinDeskService.getCoinDeskDataSearchAll();
		} else {
			return coinDeskService.getCoinDeskDataSearch(requestBody.getCoinName());
		}
	}
	
	@PostMapping(value="/CoinDeskAPI/Json", produces = MediaType.APPLICATION_JSON_VALUE)
	public CoinDeskDataEntity CoinDeskDataInsert(@RequestBody CoinDeskDataEntity requestBody) {
		CoinDeskDataEntity coinDeskDataEntity = new CoinDeskDataEntity();
		coinDeskDataEntity.setCoinName(requestBody.getCoinName());
		coinDeskDataEntity.setCoinCName(requestBody.getCoinCName());
		coinDeskDataEntity.setRate(requestBody.getRate());
		return coinDeskService.setCoinDeskDataInsert(coinDeskDataEntity);
	}
	
	
	@PutMapping("/CoinDeskAPI/Json")
	public CoinDeskDataEntity CoinDeskDataUpdate(@RequestBody CoinDeskDataEntity requestBody) {
		CoinDeskDataEntity coinDeskDataEntity = new CoinDeskDataEntity();
		coinDeskDataEntity.setCoinName(requestBody.getCoinName());
		coinDeskDataEntity.setCoinCName(requestBody.getCoinCName());
		coinDeskDataEntity.setRate(requestBody.getRate());
		return coinDeskService.setCoinDeskDataUpdate(coinDeskDataEntity);
	}
	
	@DeleteMapping("/CoinDeskAPI/Json")
	public String CoinDeskDataDelete(@RequestBody CoinDeskDataEntity requestBody) {
		return coinDeskService.setCoinDeskDataDelete(requestBody.getCoinName());
	}
}
