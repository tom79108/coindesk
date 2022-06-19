package idv.tom.coindesk.service;

import java.util.List;

import idv.tom.coindesk.entity.CoinDeskDataEntity;

public interface DBService {
	public List<CoinDeskDataEntity> findAll();
}
