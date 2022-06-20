package idv.tom.coindesk.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import idv.tom.coindesk.entity.CoinDeskDataEntity;

@Repository
public interface CoinDataBaseRepository extends JpaRepository<CoinDeskDataEntity, Long> {
	public List<CoinDeskDataEntity> findByCoinName(String coinName);
}