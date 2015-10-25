package cn.pbdata.common;


/**
 * @Title:
 * @Description: 
 * @Create on: 2015年10月23日 下午3:44:50
 * @Author:ljy
 * @Version:1.0
 */
public class WebServerInfo {

    private static String configFilePath = "config/webserverinfo.properties";
    private static PropertiesUtil util = new PropertiesUtil(configFilePath);
    private String serverId;
    
    private String ip;
    private String port;
    public WebServerInfo(){
        load();
    }
    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
    public String getPort() {
        return port;
    }
    public void setPort(String port) {
        this.port = port;
    }
    public String getServerId() {
        return serverId;
    }
    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    private void load(){
       setServerId( util.get("serverid"));
       setIp( util.get("ip"));
       setPort( util.get("port"));
    }
    
}
