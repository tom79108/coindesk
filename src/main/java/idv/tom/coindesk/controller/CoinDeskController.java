package idv.tom.coindesk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import idv.tom.coindesk.entity.CoinDeskDataEntity;
import idv.tom.coindesk.service.CoinDeskService;
import idv.tom.coindesk.utils.CommonDataUtil;

@Controller
public class CoinDeskController {
	@Autowired
	private CoinDeskService coinDeskService;
	
	@GetMapping("/OldAPIData*")
	public Object OldCoinDeskData(Model model) {
		model.addAttribute("APIResult", coinDeskService.getCoinDeskData());
		return "index";
	}
	
	@GetMapping("/CoinDeskAPI/{coinname}")
	public String CoinDeskDataSelect(Model model, @PathVariable String coinname) {
		
		model.addAttribute("APISearch", coinDeskService.getCoinDeskDataSearch(coinname).toString());
		System.out.println(CommonDataUtil.JavaObject2JsonString(coinDeskService.getCoinDeskDataSearch(coinname)));
		return "index";
	}

	@GetMapping("/CoinDeskAPI")
	public String CoinDeskDataSelect(Model model) {
		model.addAttribute("APISearch", coinDeskService.getCoinDeskDataSearchAll());
		System.out.println(model);
		return "index";
	}
	
	@PostMapping("/CoinDeskAPI/{coinname}&{coincname}&{rate}")
	public String CoinDeskDataInsert(Model model, @PathVariable String coinname,@PathVariable String coincname,@PathVariable String rate) {
		CoinDeskDataEntity coinDeskDataEntity = new CoinDeskDataEntity();
		coinDeskDataEntity.setCoinName(coinname);
		coinDeskDataEntity.setCoinCName(coincname);
		coinDeskDataEntity.setRate(rate);
		model.addAttribute("APIInsert", coinDeskService.setCoinDeskDataInsert(coinDeskDataEntity));
		System.out.println(model);
		return "index";
	}
	
	@PutMapping("/CoinDeskAPI/{coinname}&{coincname}&{rate}")
	public String CoinDeskDataUpdate(Model model, @PathVariable String coinname,@PathVariable String coincname,@PathVariable String rate) {
		CoinDeskDataEntity coinDeskDataEntity = new CoinDeskDataEntity();
		coinDeskDataEntity.setCoinName(coinname);
		coinDeskDataEntity.setCoinCName(coincname);
		coinDeskDataEntity.setRate(rate);
		model.addAttribute("APIUpdate", coinDeskService.setCoinDeskDataUpdate(coinDeskDataEntity));
		System.out.println(model);
		return "index";
	}
	
	@DeleteMapping("/CoinDeskAPI/{coinname}")
	public String CoinDeskDataDelete(Model model, @PathVariable String coinname) {
		model.addAttribute("APIDelete", coinDeskService.setCoinDeskDataDelete(coinname));
		System.out.println(model);
		return "index";
	}
}