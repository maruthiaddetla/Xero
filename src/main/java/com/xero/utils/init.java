package com.xero.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;

public class init {

	public static HashMap<String,String> propMap = new HashMap<>();

	public init() {
		try {
			//Read Master Config properties file
			File file = new File("config/masterConfig.properties");
			FileInputStream fileInputStream = new FileInputStream(file);

			Properties prop = new Properties();
			prop.load(fileInputStream);
			for (Entry<Object, Object> entry : prop.entrySet()) {
				propMap.put((String) entry.getKey(), (String) entry.getValue());
			}
		} catch (FileNotFoundException fileNotFoundException) {
			fileNotFoundException.printStackTrace();
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}
}
		

	



