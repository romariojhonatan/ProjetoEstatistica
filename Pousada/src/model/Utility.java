package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {

	/** Formatador da Date */
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	/**
	 * Retorna uma String da date.
	 * 
	 * @param date
	 *            Date para converter.
	 * @return String da data.
	 */
	public static String dateToString(Date date) {
		return sdf.format(date);
	}
	
	public static java.sql.Date dateToSql(Date date) {
		return  new java.sql.Date(date.getTime());
	}
	
	public static Date stringToDate(String date) {
		try {
			return (Date)sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		};
		return null;
	}
	

}
