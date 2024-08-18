package conectores;

import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {

	private static Properties properties = new Properties();

	static {
		try (InputStream input = ConfigLoader.class.getClassLoader().getResourceAsStream("jdbc.properties")) {
			if (input == null) {
				System.out.println("No se encuentra el  .properties");
				// return;
			} else {

				// Load the properties file from the class path
				properties.load(input);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static String getProperty(String key) {
		return properties.getProperty(key);
	}

}
