package idv.tom.coindesk.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonDataUtil {
	public static String getTimestamp() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Timestamp now = new Timestamp(new Date().getTime());
		return dateFormat.format(now);
	}
	
	public static String getTimestamp(String date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String convertDate = date.substring(1, 11)+ " " + date.substring(12, 20);
		Timestamp timestamp = Timestamp.valueOf(convertDate);
		return dateFormat.format(timestamp);
	}
}
