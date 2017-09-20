package com.star.sud;
/*@Author Sudarshan*/
import java.text.ParseException;
import java.text.SimpleDateFormat;
/*@Author Sudarshan*/
import java.util.Calendar;
import java.util.Date;

public class StarDateUtil {

	public static String getTodayDateAsRev(String splitter) {

		Integer[] dateArr = getTodayDateAsArr();
		return dateArr[2] + splitter + dateArr[1] + splitter + dateArr[0];
	}

	public static Integer[] getTodayDateAsArr() {

		Integer[] dateArr = new Integer[3];
		Calendar cal = Calendar.getInstance();

		dateArr[0] = cal.get(Calendar.DAY_OF_MONTH);
		dateArr[1] = cal.get(Calendar.MONTH) + 1;
		dateArr[2] = cal.get(Calendar.YEAR);

		return dateArr;
	}

	public static Date getDateFromString(String strDate, Boolean isDate) {
		strDate = getProperStringDate(strDate);

		Date dateVal = null;

		if (strDate == null || strDate.equals(""))
			return dateVal;

		String format = "dd/MM/yyyy";

		if (!isDate) {
			format = "dd/MM/yyyy hh:mm:ss";
		}

		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			dateVal = (Date) sdf.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dateVal;
	}

	public static String getProperStringDate(String date) {

		String[] str = date.split("-");
		return str[2] + "/" + str[1] + "/" + str[0];

	}
}
