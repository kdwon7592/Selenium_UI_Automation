package test.wa.automation.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoadConfig {

	public String getProperty(String string) {
		String resource = "src/test/resources/config.properties";
		Properties properties  = new Properties();
		String prop = null;
		try {
			properties.load(new FileInputStream(resource));
			prop = properties.getProperty(string);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	public static void main(String[] args) {
		LoadConfig loadConfig = new LoadConfig();
		
		System.out.println(loadConfig.getProperty("test"));
	}
}
