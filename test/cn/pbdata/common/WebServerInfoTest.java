package cn.pbdata.common;

import org.junit.Test;

/**
 * @Title:
 * @Description: 
 * @Create on: 2015年10月23日 下午10:54:48
 * @Author:ljy
 * @Version:1.0
 */
public class WebServerInfoTest {

    @Test
    public void testGetProp(){
        WebServerInfo info1 = new WebServerInfo();
        System.out.println(info1.getIp());
        WebServerInfo info2 = new WebServerInfo();
        System.out.println(info2.getPort());
        WebServerInfo info3 = new WebServerInfo();
        System.out.println(info3.getServerId());
    }
}
