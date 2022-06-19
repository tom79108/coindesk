package idv.tom.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetOldAPIRsVO {
	@JsonProperty("time")
	private List<TimeType> time;
	@JsonProperty("disclaimer")
	private String disclaimer;
	@JsonProperty("charName")
	private String charName;
	@JsonProperty("bpi")
	private List<CoinType> bpi;
	
	
	public List<TimeType> getTime() {
		return time;
	}
	public void setTime(List<TimeType> time) {
		this.time = time;
	}
	public String getDisclaimer() {
		return disclaimer;
	}
	public void setDisclaimer(String disclaimer) {
		this.disclaimer = disclaimer;
	}
	public String getCharName() {
		return charName;
	}
	public void setCharName(String charName) {
		this.charName = charName;
	}
	public List<CoinType> getBpi() {
		return bpi;
	}
	public void setBpi(List<CoinType> bpi) {
		this.bpi = bpi;
	}	
}