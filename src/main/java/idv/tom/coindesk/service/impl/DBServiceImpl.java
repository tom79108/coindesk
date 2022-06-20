package idv.tom.coindesk.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idv.tom.coindesk.entity.CoinDeskDataEntity;
import idv.tom.coindesk.repositories.CoinDataBaseRepository;
import idv.tom.coindesk.service.DBService;
import idv.tom.coindesk.utils.CommonDataUtil;
import idv.tom.coindesk.vo.CoinDeskResultVO;

@Service
public class DBServiceImpl implements DBService {

	private CommonDataUtil getConnonDataUtil;
	
	@Autowired
	private CoinDataBaseRepository coinDatabaseRepository;

	public CoinDeskResultVO findAll() {
		CoinDeskResultVO coinDeskResultVO = new CoinDeskResultVO();
		try {
			coinDeskResultVO.setFieldDataList(coinDatabaseRepository.findAll());
		} catch (Exception e) {
			coinDeskResultVO.setStatus("1");
			e.printStackTrace();
		}
		return coinDeskResultVO;
	}
	
	public CoinDeskResultVO findByCoinName(String coinName) {
		CoinDeskResultVO coinDeskResultVO = new CoinDeskResultVO();
		try {
			coinDeskResultVO.setFieldDataList(coinDatabaseRepository.findByCoinName(coinName)); 
		} catch (Exception e) {
			coinDeskResultVO.setStatus("1");
			e.printStackTrace();
		}
		return coinDeskResultVO;
	}

	public CoinDeskResultVO insert(CoinDeskDataEntity insertData) {
		CoinDeskResultVO coinDeskResultVO = new CoinDeskResultVO();
		CoinDeskResultVO tmpResultVO = new CoinDeskResultVO();
		List<CoinDeskDataEntity> result = new ArrayList();
		try {
			tmpResultVO = findByCoinName(insertData.getCoinName());
			if(tmpResultVO.getFieldDataList().size() > 0) {
				coinDeskResultVO.setStatus("3");
				coinDeskResultVO.setResultMSG("Data was save");
			} else {
				insertData.setLastUpdateDate(
						insertData.getLastUpdateDate() == null || insertData.getLastUpdateDate().isEmpty() ?
						CommonDataUtil.getTimestamp() : CommonDataUtil.getTimestamp(insertData.getLastUpdateDate()) 
					);
				result.add(coinDatabaseRepository.save(insertData));
				coinDeskResultVO.setFieldDataList(result);
				coinDeskResultVO.setResultMSG("Insert Finish");
			}
		} catch (Exception e) {
			coinDeskResultVO.setStatus("1");
			e.printStackTrace();
		}
		return coinDeskResultVO;
	}

	public CoinDeskResultVO update(CoinDeskDataEntity updateData) {
		CoinDeskResultVO coinDeskResultVO = new CoinDeskResultVO();
		CoinDeskResultVO tmpResultVO = new CoinDeskResultVO();
		List<CoinDeskDataEntity> result = new ArrayList();
		try {
			tmpResultVO = findByCoinName(updateData.getCoinName());
			if(tmpResultVO.getFieldDataList().size() > 0) {
				updateData.setLastUpdateDate(getConnonDataUtil.getTimestamp());
				result.add(coinDatabaseRepository.save(updateData));
				coinDeskResultVO.setFieldDataList(result);
				coinDeskResultVO.setResultMSG("Update Finish");
			} else {
				coinDeskResultVO.setStatus("2");
				coinDeskResultVO.setResultMSG("Data undefind");
			}
		} catch (Exception e) {
			coinDeskResultVO.setStatus("1");
			e.printStackTrace();
		}
		return coinDeskResultVO;
	}
	
	public CoinDeskResultVO deleteByKey(String coinName) {
		CoinDeskResultVO coinDeskResultVO = new CoinDeskResultVO();
		CoinDeskResultVO tmpResultVO = new CoinDeskResultVO();
		CoinDeskDataEntity coinDeskDataEntity = new CoinDeskDataEntity();
		try {
			tmpResultVO = findByCoinName(coinName);
			if(tmpResultVO.getFieldDataList().size() > 0) {
				coinDeskDataEntity.setCoinName(tmpResultVO.getFieldDataList().get(0).getCoinName());
				coinDatabaseRepository.delete(coinDeskDataEntity);
				coinDeskResultVO.setResultMSG("Delete Finish");
			} else {
				coinDeskResultVO.setStatus("2");
				coinDeskResultVO.setResultMSG("Data undefind");
			}
		} catch (Exception e) {
			coinDeskResultVO.setStatus("1");
			e.printStackTrace();
		}
		return coinDeskResultVO;
	}
}