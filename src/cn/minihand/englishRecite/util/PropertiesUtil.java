package cn.minihand.englishRecite.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class PropertiesUtil {

	public final static int SERPORT = 9998;
	
	public final static String SERADDRESS = "127.0.0.1";
	
	public final static String userDir = "C:\\apache-tomcat-6.0.18\\webapps\\englishRecite\\WEB-INF";
	
	public static String getCurrentTime(){
		final TimeZone zone = TimeZone.getTimeZone("GMT+8");
		TimeZone.setDefault(zone);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		Calendar c = Calendar.getInstance();
		String currentTime = df.format(c.getTime());
		
		return currentTime;
	}
}
