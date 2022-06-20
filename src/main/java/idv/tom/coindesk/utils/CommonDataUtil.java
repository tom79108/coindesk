package idv.tom.coindesk.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CommonDataUtil {
	public static String getTimestamp() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Timestamp now = new Timestamp(new Date().getTime());
		return dateFormat.format(now);
	}
	
	public static String getTimestamp(String date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String convertDate = date.substring(0, 10)+ " " + date.substring(11, 19);
		Timestamp timestamp = Timestamp.valueOf(convertDate);
		return dateFormat.format(timestamp);
	}
	
	public static String JavaObject2JsonString(Object JO) {
		ObjectMapper mapper = new ObjectMapper();
		String result = "";
		try {
			result = mapper.writeValueAsString(JO);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}
}
