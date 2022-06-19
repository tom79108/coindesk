package idv.tom.coindesk.table.vo;
import java.sql.Timestamp;

public class CoinDeskDataVO {
    String coinName;

    String coinCName;

    String rate;
    
    Timestamp lastUpdateDate;

	public String getCoinName() {
		return coinName;
	}

	public void setCoinName(String coinName) {
		this.coinName = coinName;
	}

	public String getCoinCName() {
		return coinCName;
	}

	public void setCoinCName(String coinCName) {
		this.coinCName = coinCName;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public Timestamp getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Timestamp lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
}