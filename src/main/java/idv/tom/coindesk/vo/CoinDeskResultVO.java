package idv.tom.coindesk.vo;

import java.util.ArrayList;
import java.util.List;

import idv.tom.coindesk.entity.CoinDeskDataEntity;

public class CoinDeskResultVO {
	List<CoinDeskDataEntity> fieldDataList = new ArrayList();
	//0正常 1錯誤 2 查無資料 3資料重複
	String Status = "0";
	
	String ResultMSG = "";

	public CoinDeskResultVO() {
		
	}
	
	public CoinDeskResultVO(List<CoinDeskDataEntity> fieldDataList, String Status, String ResultMSG) {
		super();
		this.fieldDataList = fieldDataList;
		this.Status = Status;
		this.ResultMSG = ResultMSG;
	}
	
	public List<CoinDeskDataEntity> getFieldDataList() {
		return fieldDataList;
	}

	public void setFieldDataList(List<CoinDeskDataEntity> fieldDataList) {
		this.fieldDataList = fieldDataList;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getResultMSG() {
		return ResultMSG;
	}

	public void setResultMSG(String resultMSG) {
		ResultMSG = resultMSG;
	}
}
