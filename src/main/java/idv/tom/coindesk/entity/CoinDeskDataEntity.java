package idv.tom.coindesk.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.ToString;

@Entity
@Table(name="COINDESKDATA")
@ToString
public class CoinDeskDataEntity implements Serializable{
	@Id
	@Column(name="coinname", columnDefinition = "varchar(10)")
	
    String coinName;

    @Column(name="coincname", nullable=false, columnDefinition = "varchar(20)")
    String coinCName;

    @Column(name="rate", nullable=false, columnDefinition = "varchar(20)")
    String rate;

    @Column(name="lastupdatedate", columnDefinition = "TIMESTAMP(0) not null default current_timestamp")
    String lastUpdateDate;

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

	public String getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
}