package idv.tom.coindesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import idv.tom.coindesk.entity.CoinDeskDataEntity;

@Repository
public interface CoinDataBaseRepository extends JpaRepository<CoinDeskDataEntity, Long> {
//	public CoinDeskDataEntity findByCoinName(String username);
}