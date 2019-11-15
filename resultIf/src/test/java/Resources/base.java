package Resources;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
//parent for every class so that they can use the config file
public class base {
	
	
	
public static Properties prop;
	
	public base()
	{
		try {
			prop = new Properties();
			//System.out.println(System.getProperty("user.dir"));
			FileInputStream ip = new FileInputStream("C:\\Users\\vipanshuw\\eclipse-workspace\\resultIf\\src\\test\\java\\Config\\config.properties");
			prop.load(ip);
	
			
		} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
	}
	
	

}
