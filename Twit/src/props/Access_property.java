package props;



import java.util.Properties;


public class Access_property {

	static Properties properties;

	public static void initialize(Properties properties) {
		Access_property.properties = properties;
	}
	
	public static Object get(String propertyName) {
		return properties.get(propertyName);
	}

	public static String getProperty(String propertyName) {
		return properties.getProperty(propertyName);
	}

	public static Properties getAllProperties() {
		return properties;
	}

	
	
	
	
}
