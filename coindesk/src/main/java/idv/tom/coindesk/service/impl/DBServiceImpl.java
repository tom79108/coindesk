package idv.tom.coindesk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idv.tom.coindesk.entity.CoinDeskDataEntity;
import idv.tom.coindesk.repositories.CoinDataBaseRepository;
import idv.tom.coindesk.service.DBService;

@Service
public class DBServiceImpl implements DBService{

	@Autowired
	private CoinDataBaseRepository coinDatabaseRepository;
//
//	public void insert(CoinDeskDataVO insertData) {
//		CoinDeskDataVO coinDeskDataVO = new CoinDeskDataVO();
//		coinDeskDataVO.setCoinName(insertData.getCoinCName());
//		coinDeskDataVO.setCoinCName(insertData.getCoinCName());
//		coinDeskDataVO.setRate(insertData.getRate());
//		coinDatabaseRepository.save(coinDeskDataVO);
//	}
//
	public List<CoinDeskDataEntity> findAll() {
		List<CoinDeskDataEntity> coindeskdata = coinDatabaseRepository.findAll();
		if(coindeskdata != null) {
			System.out.println(coindeskdata.toString());
		}
		return coindeskdata;
	}
//
//	public void update(CoinDeskDataVO updateData) {
//		CoinDeskDataVO coinDeskDataVO = coinDatabaseRepository.findByCoinName(updateData.getCoinName());
//		coinDeskDataVO.setCoinCName(updateData.getCoinCName());
//		coinDeskDataVO.setRate(updateData.getRate());
//		coinDatabaseRepository.save(coinDeskDataVO);
//	}
//	
//	public void delete(String key) {
//		CoinDeskDataVO coinDeskDataVO = coinDatabaseRepository.findByCoinName(key);
//		if(coinDeskDataVO != null) {
//			coinDatabaseRepository.deleteById(null);
//		}
//		showRecord();
//	}
}