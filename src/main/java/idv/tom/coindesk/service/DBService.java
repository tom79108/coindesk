package idv.tom.coindesk.service;

import java.util.List;

import idv.tom.coindesk.entity.CoinDeskDataEntity;

public interface DBService {
	public CoinDeskDataEntity findByCoinName(String coinname);
	public List<CoinDeskDataEntity> findAll();
	public String deleteByKey(String coinname);
	public CoinDeskDataEntity insert(CoinDeskDataEntity coinDeskDataEntity);
	public CoinDeskDataEntity update(CoinDeskDataEntity coinDeskDataEntity);
}
