package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadProperties {

	public String getProperty(String key) {
		String value = null;
		Properties prop = loadProperty("testRun");
		value = prop.getProperty(key);
		
		if (value == null) {
			String testEnv = prop.getProperty("testEnv");
			prop = loadProperty(testEnv);
			value = prop.getProperty(key);
		}
		
		return value;
	}

	public String getSaucelabsProperty(String key) {
		String value = null;
		Properties prop = loadProperty("saucelabs");
		value = prop.getProperty(key);

		return value;
	}

	private Properties loadProperty(String fileName) {
		Properties prop = new Properties();
		String filePath = "./src/main/resources/properties/" + fileName + ".properties";
		try {
			File file = new File(filePath);
			FileInputStream fileStream = new FileInputStream(file);
			prop.load(fileStream);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return prop;
	}
}
