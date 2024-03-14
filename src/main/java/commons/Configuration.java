package commons;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 * Config that is supplied to tests via a properties file. Holds data that is used by the tests and the
 * url of the environment under test.
 */
public class Configuration {

//    url,
//    username,
//    password;
//
//    private final String configPath = System.getProperty("configPath");
//
//    private Properties properties;
//
//    private String value;
//
//    private void init() {
//        if (properties == null) {
//
//            // Check config path is available.
//            if (configPath == null) {
//                throw new RuntimeException("You must pass configPath as a system property.");
//            }
//
//            properties = new Properties();
//
//            try {
//                properties.load(new FileInputStream(configPath));
//            } catch (Exception e) {
//                throw new RuntimeException("Unable to load test properties from:" + configPath + ".", e);
//            }
//        }
//        value = (String) properties.get(this.toString());
//    }
//
//    public Object getValue() {
//        if (value == null) {
//            init();
//        }
//        return value;
//    }
//
//    public String asString() {
//        return (String) getValue();
//    }
	
	
	
		static	Properties prop = new Properties();
		static String path =System.getProperty("user.dir");
		
		public static String URL;
		public static String browserN;
		public static String userName;
		public static String password;
		
		public static void getProperties(){
			
			try {
				
				
				InputStream input = new FileInputStream(path+"/src/main/java/Config/config.properties");
				prop.load(input);
				String browser=prop.getProperty("Browser");
				String Url=prop.getProperty("url");
				userName=prop.getProperty("username");
				password=prop.getProperty("password");
	          browserN=browser;
	          URL =Url;
	          
			} catch (Exception exp) {
				exp.printStackTrace();
			}
		}

		public static void setProperties(String browser,String url) {
			try {
				OutputStream out=new FileOutputStream(path+"/src/main/java/Config/config.properties");
				prop.setProperty("Browser", browser);
				prop.setProperty("url", url);
				prop.store(out, null);
				
			} catch (Exception e) {
				
			}
		}
}
