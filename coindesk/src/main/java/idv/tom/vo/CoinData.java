package idv.tom.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoinData {
	@JsonProperty("code")
	private String code;
	@JsonProperty("symbol")
	private String symbol;
	@JsonProperty("rate")
	private String rate;
	@JsonProperty("description")
	private String description;
	@JsonProperty("rate_float")
	private String rate_float;
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRate_float() {
		return rate_float;
	}
	public void setRate_float(String rate_float) {
		this.rate_float = rate_float;
	}
}
