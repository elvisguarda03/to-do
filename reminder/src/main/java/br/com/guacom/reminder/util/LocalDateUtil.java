package br.com.guacom.reminder.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LocalDateUtil {
	
	public static String formatDate(LocalDate date) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy")
				.withLocale(new Locale("pt", "BR"));
		return date.plusDays(1).format(dtf);
	}
}
