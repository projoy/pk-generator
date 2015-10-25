package cn.pbdata.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * @Title:
 * @Description:
 * @Create on: 2015年10月23日 下午5:20:38
 * @Author:ljy
 * @Version:1.0
 */
public class PropertiesUtil {

    Logger log = Logger.getLogger(this.getClass());
    private static Properties pro = null;


    public PropertiesUtil(String propertiesFilePath) {
            pro = new Properties();
            InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream(propertiesFilePath);
            log.info("加载属性文件：filePath="+propertiesFilePath); 
            try {
                pro.load(in);
            } catch (IOException e) {
                log.error("加载属性文件错误! filePath=" + propertiesFilePath, e);
            }
    }
    
    public String get(String key){
        return pro.getProperty(key);
    }

}
