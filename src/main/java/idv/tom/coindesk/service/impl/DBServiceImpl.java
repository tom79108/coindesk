package idv.tom.coindesk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idv.tom.coindesk.entity.CoinDeskDataEntity;
import idv.tom.coindesk.repositories.CoinDataBaseRepository;
import idv.tom.coindesk.service.DBService;
import idv.tom.coindesk.utils.CommonDataUtil;

@Service
public class DBServiceImpl implements DBService{

	private CommonDataUtil getConnonDataUtil;
	
	@Autowired
	private CoinDataBaseRepository coinDatabaseRepository;

	public List<CoinDeskDataEntity> findAll() {
		System.out.println("empty");
		List<CoinDeskDataEntity> coinDeskDataEntity = coinDatabaseRepository.findAll();
		return coinDeskDataEntity;
	}
	
	public CoinDeskDataEntity findByCoinName(String coinName) {
		CoinDeskDataEntity coinDeskDataEntity = new CoinDeskDataEntity();
		coinDeskDataEntity.setCoinName(coinName);
		System.out.println("empty" + coinName);
		return coinDatabaseRepository.findByCoinName(coinName);
	}

	public CoinDeskDataEntity insert(CoinDeskDataEntity insertData) {
		System.out.println(insertData.getCoinName() + "_" + insertData.getCoinCName() + "_" + insertData.getRate());
		CoinDeskDataEntity coinDeskDataEntity = new CoinDeskDataEntity();
		coinDeskDataEntity.setCoinName(insertData.getCoinName());
		coinDeskDataEntity.setCoinCName(insertData.getCoinCName());
		coinDeskDataEntity.setRate(insertData.getRate());
		coinDeskDataEntity.setLastUpdateDate(getConnonDataUtil.getTimestamp());
		return coinDatabaseRepository.save(coinDeskDataEntity);
	}

	public CoinDeskDataEntity update(CoinDeskDataEntity updateData) {
		CoinDeskDataEntity coinDeskDataEntity = new CoinDeskDataEntity();
		coinDeskDataEntity.setCoinName(updateData.getCoinName());
		coinDeskDataEntity.setCoinCName(updateData.getCoinCName());
		coinDeskDataEntity.setRate(updateData.getRate());
		return coinDatabaseRepository.save(coinDeskDataEntity);
	}
	
	public void deleteByKey(String coinname) {
		CoinDeskDataEntity coinDeskDataEntity = new CoinDeskDataEntity();
		coinDeskDataEntity.setCoinName(coinname);
		if(coinDeskDataEntity != null) {
			coinDatabaseRepository.delete(coinDeskDataEntity);
		}
	}
}