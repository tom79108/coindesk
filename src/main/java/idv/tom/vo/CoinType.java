package idv.tom.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoinType {
	@JsonProperty("USD")
	private CoinData USD;
	@JsonProperty("GBP")
	private CoinData GBP;
	@JsonProperty("EUR")
	private CoinData EUR;
	public CoinData getUSD() {
		return USD;
	}
	public void setUSD(CoinData uSD) {
		USD = uSD;
	}
	public CoinData getGBP() {
		return GBP;
	}
	public void setGBP(CoinData gBP) {
		GBP = gBP;
	}
	public CoinData getEUR() {
		return EUR;
	}
	public void setEUR(CoinData eUR) {
		EUR = eUR;
	}
	
	
}
