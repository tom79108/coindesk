package idv.tom.coindesk.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.*;
import lombok.experimental.Accessors;

@Entity
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name="COINDESKDATA")
@ToString
public class CoinDeskDataEntity implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="no")
	private long no;
	
    @Column(name="coinname", nullable=false, columnDefinition = "varchar(10)")
    String coinName;

    @Column(name="coincname", nullable=false, columnDefinition = "varchar(20)")
    String coinCName;

    @Column(name="rate", nullable=false, columnDefinition = "varchar(20)")
    String rate;

//    @Column(name="lastupdatedate", columnDefinition = "TIMESTAMP not null default current_timestamp")
//    @Temporal(TemporalType.TIMESTAMP)
//    @LastModifiedDate
//    Date lastUpdateDate;

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

//	public Date getLastUpdateDate() {
//		return lastUpdateDate;
//	}
//
//	public void setLastUpdateDate(Date lastUpdateDate) {
//		this.lastUpdateDate = lastUpdateDate;
//	}
}