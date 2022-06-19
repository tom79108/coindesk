package idv.tom.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DataTimeType {
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd hh:mm:ss")
	@JsonProperty("updated")
	private String updated;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd hh:mm:ss")
	@JsonProperty("updatedISO")
	private String updatedISO;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd hh:mm:ss")
	@JsonProperty("updateduk")
	private String updateduk;
	
	
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
}
