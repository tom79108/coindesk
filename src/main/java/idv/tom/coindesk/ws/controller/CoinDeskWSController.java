package idv.tom.coindesk.ws.controller;

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
import idv.tom.coindesk.vo.CoinDeskResultVO;

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
	public CoinDeskResultVO OldAPIToNewAPI() {
		return coinDeskService.TodoOldAPIToNewAPI();
	}
	
	@GetMapping("/CoinDeskAPI/{coinname}")
	public CoinDeskResultVO CoinDeskDataSelect(@PathVariable String coinname) {
		return coinDeskService.getCoinDeskDataSearch(coinname);
	}
	
	@GetMapping("/CoinDeskAPI")
	public CoinDeskResultVO CoinDeskDataSelect() {
		return coinDeskService.getCoinDeskDataSearchAll();
	}
	
	@PostMapping("/CoinDeskAPI/{coinname}&{coincname}&{rate}")
	public CoinDeskResultVO CoinDeskDataInsert(@PathVariable String coinname,@PathVariable String coincname,@PathVariable String rate) {
		CoinDeskDataEntity coinDeskDataEntity = new CoinDeskDataEntity();
		coinDeskDataEntity.setCoinName(coinname);
		coinDeskDataEntity.setCoinCName(coincname);
		coinDeskDataEntity.setRate(rate);
		return coinDeskService.setCoinDeskDataInsert(coinDeskDataEntity);
	}
	
	@PutMapping("/CoinDeskAPI/{coinname}&{coincname}&{rate}")
	public CoinDeskResultVO CoinDeskDataUpdate(@PathVariable String coinname, @PathVariable String coincname, @PathVariable String rate) {
		CoinDeskDataEntity coinDeskDataEntity = new CoinDeskDataEntity();
		coinDeskDataEntity.setCoinName(coinname);
		coinDeskDataEntity.setCoinCName(coincname);
		coinDeskDataEntity.setRate(rate);
		return coinDeskService.setCoinDeskDataUpdate(coinDeskDataEntity);
	}
	
	@DeleteMapping("/CoinDeskAPI/{coinname}")
	public CoinDeskResultVO CoinDeskDataDelete(@PathVariable String coinname) {
		return coinDeskService.setCoinDeskDataDelete(coinname);
	}
	
	
	@GetMapping(value="/CoinDeskAPI/Json", produces = MediaType.APPLICATION_JSON_VALUE)
	public CoinDeskResultVO CoinDeskDataSelect(@RequestBody(required=false) CoinDeskDataEntity requestBody) {
		CoinDeskResultVO coinDeskResultVO = new CoinDeskResultVO();
		if(null == requestBody) {
			coinDeskResultVO.setStatus("1");
			coinDeskResultVO.setResultMSG("Request data Error");
		} else {
			if(null == requestBody.getCoinName()) {
				coinDeskResultVO = coinDeskService.getCoinDeskDataSearchAll();
			} else {
				coinDeskResultVO = coinDeskService.getCoinDeskDataSearch(requestBody.getCoinName());
			}
		}
		return coinDeskResultVO;
	}
	
	@PostMapping(value="/CoinDeskAPI/Json", produces = MediaType.APPLICATION_JSON_VALUE)
	public CoinDeskResultVO CoinDeskDataInsert(@RequestBody(required=false) CoinDeskDataEntity requestBody) {
		CoinDeskResultVO coinDeskResultVO = new CoinDeskResultVO();
		if(null == requestBody || (
			requestBody.getCoinName().isEmpty() || requestBody.getCoinCName().isEmpty() || requestBody.getRate().isEmpty()
		)) {
			coinDeskResultVO.setStatus("1");
			coinDeskResultVO.setResultMSG("Request data Error");
		} else {
			CoinDeskDataEntity coinDeskDataEntity = new CoinDeskDataEntity();
			coinDeskDataEntity.setCoinName(requestBody.getCoinName());
			coinDeskDataEntity.setCoinCName(requestBody.getCoinCName());
			coinDeskDataEntity.setRate(requestBody.getRate());
			coinDeskResultVO = coinDeskService.setCoinDeskDataInsert(coinDeskDataEntity);
		}
		return coinDeskResultVO;
	}
	
	
	@PutMapping("/CoinDeskAPI/Json")
	public CoinDeskResultVO CoinDeskDataUpdate(@RequestBody(required=false) CoinDeskDataEntity requestBody) {
		CoinDeskResultVO coinDeskResultVO = new CoinDeskResultVO();
		if(null == requestBody || (
			requestBody.getCoinName().isEmpty() || requestBody.getCoinCName().isEmpty() || requestBody.getRate().isEmpty()
		)) {
			coinDeskResultVO.setStatus("1");
			coinDeskResultVO.setResultMSG("Request data Error");
		} else {
			CoinDeskDataEntity coinDeskDataEntity = new CoinDeskDataEntity();
			coinDeskDataEntity.setCoinName(requestBody.getCoinName());
			coinDeskDataEntity.setCoinCName(requestBody.getCoinCName());
			coinDeskDataEntity.setRate(requestBody.getRate());
			coinDeskResultVO = coinDeskService.setCoinDeskDataUpdate(coinDeskDataEntity);
		}
		return coinDeskResultVO;
	}
	
	@DeleteMapping("/CoinDeskAPI/Json")
	public CoinDeskResultVO CoinDeskDataDelete(@RequestBody(required=false) CoinDeskDataEntity requestBody) {
		CoinDeskResultVO coinDeskResultVO = new CoinDeskResultVO();
		if(null == requestBody || requestBody.getCoinName().isEmpty()) {
			coinDeskResultVO.setStatus("1");
			coinDeskResultVO.setResultMSG("Request data Error");
		} else {
			coinDeskResultVO = coinDeskService.setCoinDeskDataDelete(requestBody.getCoinName());
		}
		return coinDeskResultVO;
	}
}
