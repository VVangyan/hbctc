package io.renren.modules.hbctc.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DATE  util 
 * @author yan
 *
 */
public class DateFactoryUtil {
	
	/**
	 * "yyyy-MM-dd日 HH:mm:ss"
	 * @return
	 */
	public static String  getStrFullDate() {
		Date date=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
	
	/**
	 * yyyyMMdd
	 * @return
	 */
	public static String getStrYMD() {
		Date date=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(date);
	}
	
}
