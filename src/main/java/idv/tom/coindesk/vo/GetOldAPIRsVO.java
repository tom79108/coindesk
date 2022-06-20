package idv.tom.coindesk.vo;

public class GetOldAPIRsVO {

	private DataTimeType time;

	private String disclaimer;

	private String chartName;

	private CoinType bpi;

	
	public GetOldAPIRsVO() {
		
	}
	
	
    public GetOldAPIRsVO(
		DataTimeType time, String disclaimer, String chartName,
		CoinType bpi
    ) {
        super();
        this.time = time;
        this.disclaimer = disclaimer;
        this.chartName = chartName;
        this.bpi = bpi;
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
}
