package com.rs.fer.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String getCurrentDate() {
		SimpleDateFormat  simpleDateFormat = new SimpleDateFormat("dd/mm/yyyy");
		return simpleDateFormat.format(new Date());
	}

	
}
