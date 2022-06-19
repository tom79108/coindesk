package idv.tom.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;


public class GetOldAPIRsVO {
	@JsonProperty("time")
	private DataTimeType time;
	@JsonProperty("disclaimer")
	private String disclaimer;
	@JsonProperty("chartName")
	private String chartName;
	@JsonProperty("bpi")
	private CoinType bpi;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd hh:mm:ss")
	@JsonProperty("updated")
	private String updated;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd hh:mm:ss")
	@JsonProperty("updatedISO")
	private String updatedISO;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd hh:mm:ss")
	@JsonProperty("updateduk")
	private String updateduk;
	
	@JsonProperty("USD")
	private CoinData USD;
	@JsonProperty("GBP")
	private CoinData GBP;
	@JsonProperty("EUR")
	private CoinData EUR;
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


	public GetOldAPIRsVO() {
		
	}
	
    public GetOldAPIRsVO(
		DataTimeType time, String disclaimer, String chartName,
		CoinType bpi, String updated, String updatedISO,
		String updateduk, CoinData USD, CoinData GBP,
		CoinData EUR, String code, String symbol, String rate,
		String description, String rate_float
    ) {
        super();
        this.time = time;
        this.disclaimer = disclaimer;
        this.chartName = chartName;
        this.bpi = bpi;
        this.updated = updated;
        this.updatedISO = updatedISO;
        this.updateduk = updateduk;
        this.USD = USD;
        this.GBP = GBP;
        this.EUR = EUR;
        this.code = code;
        this.symbol = symbol;
        this.rate = rate;
        this.description = description;
        this.rate_float = rate_float;
    }

	public DataTimeType getTime() {
		return time;
	}

	public void setTime(DataTimeType time) {
		this.time = time;
	}

	public String getDisclaimer() {
		return disclaimer;
	}

	public void setDisclaimer(String disclaimer) {
		this.disclaimer = disclaimer;
	}

	public String getChartName() {
		return chartName;
	}

	public void setChartName(String chartName) {
		this.chartName = chartName;
	}

	public CoinType getBpi() {
		return bpi;
	}

	public void setBpi(CoinType bpi) {
		this.bpi = bpi;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

	public String getUpdatedISO() {
		return updatedISO;
	}

	public void setUpdatedISO(String updatedISO) {
		this.updatedISO = updatedISO;
	}

	public String getUpdateduk() {
		return updateduk;
	}

	public void setUpdateduk(String updateduk) {
		this.updateduk = updateduk;
	}

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
