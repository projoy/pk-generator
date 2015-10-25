package cn.pbdata.common;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 * @Title:
 * @Description: 
 * @Create on: 2015年10月23日 下午6:13:25
 * @Author:ljy
 * @Version:1.0
 */

public class PropertiesUitlTest {

    @Test
    public void testGet(){
        String filePath = "config/webserverinfo.properties";
        PropertiesUtil util = new PropertiesUtil(filePath);
        
        assertEquals("10001",util.get("serverid"));
        assertEquals("192.168.1.191",util.get("ip"));
        assertEquals("8080",util.get("port"));
    }
}
