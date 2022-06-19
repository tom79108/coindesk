package idv.tom.vo;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoinType {
	@JsonProperty("USD")
	private Collection<CoinData> USD;
	@JsonProperty("GBP")
	private Collection<CoinData> GBP;
	@JsonProperty("EUR")
	private Collection<CoinData> EUR;
	
	
	public Collection<CoinData> getUSD() {
		return USD;
	}
	public void setUSD(Collection<CoinData> uSD) {
		USD = uSD;
	}
	public Collection<CoinData> getGBP() {
		return GBP;
	}
	public void setGBP(Collection<CoinData> gBP) {
		GBP = gBP;
	}
	public Collection<CoinData> getEUR() {
		return EUR;
	}
	public void setEUR(Collection<CoinData> eUR) {
		EUR = eUR;
	}
}
