package br.com.guacom.reminder.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	public static Date formatDate(String date) {
		SimpleDateFormat in = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
		Date formatDate = null;
		try {
			String data = out.format(in.parse(date));
			 formatDate = out.parse(data);
		} catch (ParseException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return formatDate;
	}
	
	public static Date getDate(String data) {
		Date parse = null;
		try {
			parse = new SimpleDateFormat("yyyy-MM-dd").parse(data);
		} catch (ParseException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return parse;
	}
}