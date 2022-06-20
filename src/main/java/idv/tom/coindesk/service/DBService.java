package idv.tom.coindesk.service;

import idv.tom.coindesk.entity.CoinDeskDataEntity;
import idv.tom.coindesk.vo.CoinDeskResultVO;

public interface DBService {
	public CoinDeskResultVO findByCoinName(String coinName);
	public CoinDeskResultVO findAll();
	public CoinDeskResultVO deleteByKey(String coinName);
	public CoinDeskResultVO insert(CoinDeskDataEntity coinDeskDataEntity);
	public CoinDeskResultVO update(CoinDeskDataEntity coinDeskDataEntity);
}
