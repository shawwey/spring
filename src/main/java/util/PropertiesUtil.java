package util;

import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 配置属性工具类
 * @author Administrator
 *
 */

public class PropertiesUtil {

	private static Logger logger=LoggerFactory.getLogger(PropertiesUtil.class);
	
	public static Properties env=new Properties();
	
	static{
		InputStream is=null;
		try{
			is=Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties");
			env.load(is);
			
		}catch(Exception e){
			logger.error("Can't load application.properties in classpath!",e);
		}finally{
			IOUtils.closeQuietly(is);
		}
	}
	
	
	public static String getProperty(String key){
		return (String)env.get(key);
	}
	
	public static String getProperty(String key,String defaultValue){
		return (String)env.getProperty(key, defaultValue);
	}
}
