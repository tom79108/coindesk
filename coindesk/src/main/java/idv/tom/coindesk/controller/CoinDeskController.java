package idv.tom.coindesk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import idv.tom.coindesk.entity.CoinDeskDataEntity;
import idv.tom.coindesk.repositories.CoinDataBaseRepository;
import idv.tom.coindesk.service.CoinDeskService;
import idv.tom.coindesk.service.impl.DBServiceImpl;


@Controller
public class CoinDeskController {
	
	private CoinDeskService CoinDeskService;
	@Autowired
	private DBServiceImpl dbServiceImpl;
//	@Autowired
//    public CoinDeskController(CoinDeskService CoinDeskService) {
//		this.CoinDeskService = CoinDeskService;
//    }
	
    @GetMapping("/")
    public Object hello(Model model){
    	System.out.println(dbServiceImpl.findAll());
    	model.addAttribute("APIResult", dbServiceImpl.findAll());
        return "index";
    }
	
	@GetMapping("/OldAPIData")
	public Object OldCoinDeskData(Model model) {
		model.addAttribute("APIResult", CoinDeskService.getCoinDeskData());
		return "index";
	}
	
	@GetMapping("/CoinDeskAPI")
	public String CoinDeskDataSelect(Model model) {
		model.addAttribute("APISearch", CoinDeskService.getCoinDeskDataSearch());
		return "index";
	}
	
	@PostMapping("/CoinDeskAPI")
	public String CoinDeskDataInsert(Model model) {
		model.addAttribute("APIInsert", CoinDeskService.setCoinDeskDataInsert());
		return "index";
	}
	
	@PutMapping("/CoinDeskAPI")
	public String CoinDeskDataUpdate(Model model) {
		model.addAttribute("APIUpdate", CoinDeskService.setCoinDeskDataUpdate());
		return "index";
	}
	
	@DeleteMapping("/CoinDeskAPI")
	public String CoinDeskDataDelete(Model model) {
		model.addAttribute("APIDelete", CoinDeskService.setCoinDeskDataDelete());
		return "index";
	}
}