package edu.vinaenter.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static Date convertStringToDate(String str) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dateTL = null;
		try {
			dateTL = sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return dateTL;
	}

}
