package idv.tom.coindesk.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idv.tom.coindesk.entity.CoinDeskDataEntity;
import idv.tom.coindesk.repositories.CoinDataBaseRepository;
import idv.tom.coindesk.service.DBService;
import idv.tom.coindesk.utils.CommonDataUtil;

@Service
public class DBServiceImpl implements DBService {

	private CommonDataUtil getConnonDataUtil;
	
	@Autowired
	private CoinDataBaseRepository coinDatabaseRepository;

	public List<CoinDeskDataEntity> findAll() {
		List<CoinDeskDataEntity> result = new ArrayList();
		try {
			result = coinDatabaseRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public CoinDeskDataEntity findByCoinName(String coinName) {
		CoinDeskDataEntity result = new CoinDeskDataEntity();
		try {
			result = coinDatabaseRepository.findByCoinName(coinName); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public CoinDeskDataEntity insert(CoinDeskDataEntity insertData) {
		System.out.println(insertData.getLastUpdateDate());
		System.out.println(insertData.getLastUpdateDate() == null || insertData.getLastUpdateDate().isEmpty());
		insertData.setLastUpdateDate(
			insertData.getLastUpdateDate() == null || insertData.getLastUpdateDate().isEmpty() ?
			CommonDataUtil.getTimestamp() : CommonDataUtil.getTimestamp(insertData.getLastUpdateDate()) 
		);
		System.out.println(insertData.getLastUpdateDate());
		CoinDeskDataEntity result = new CoinDeskDataEntity();
		try {
			result = coinDatabaseRepository.save(insertData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public CoinDeskDataEntity update(CoinDeskDataEntity updateData) {
		updateData.setLastUpdateDate(getConnonDataUtil.getTimestamp());
		CoinDeskDataEntity result = new CoinDeskDataEntity();
		try {
			result = coinDatabaseRepository.save(updateData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public String deleteByKey(String coinname) {
		CoinDeskDataEntity coinDeskDataEntity = new CoinDeskDataEntity();
		String result = "Data undefind";
		try {
			CoinDeskDataEntity selectData = findByCoinName(coinname);
			if(selectData != null) {
				coinDeskDataEntity.setCoinName(selectData.getCoinName());
				coinDatabaseRepository.delete(coinDeskDataEntity);
				result = "Delete Finish";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}