package idv.tom.coindesk.service;

import java.util.List;

import idv.tom.coindesk.entity.CoinDeskDataEntity;

public interface DBService {
	public CoinDeskDataEntity findByCoinName(String coinName);
	public List<CoinDeskDataEntity> findAll();
	public String deleteByKey(String coinName);
	public CoinDeskDataEntity insert(CoinDeskDataEntity coinDeskDataEntity);
	public CoinDeskDataEntity update(CoinDeskDataEntity coinDeskDataEntity);
}
