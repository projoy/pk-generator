package cn.pbdata.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.Logger;

/**
 * @Title:
 * @Description: 
 * @Version:1.0
 */
public class PKGenerator {
  //顺序号
    private static int iIndex = 0;

    private static Logger log = Logger.getLogger(PKGenerator.class);
    private static WebServerInfo serverInfo = new WebServerInfo();
    //全局实体类
    private static PKGenerator gen ;
//    private  Calendar cal = Calendar.getInstance();
    private static SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
    private PKGenerator(){       
    }
    public static PKGenerator getInstance() {
        if(gen == null){
           gen = new PKGenerator();
        }
        return gen;
    }
 /**
  * @description 根据时间，IP，端口号，流水号等生成全局唯一的主键
        年(2位) + 月(2位) + 日期(2位) + IP(后2位)+端口号(后2位)+时(2位)+分(2位)+秒(2位)+流水号(4位); 共计20位
       IP/端口号指服务器信息，从配置文件中取
  * @version 1.0
  * @return 20位的主键
  */
    public synchronized String generateStringPk(){
        String strSeqDate = "";
         try {
             //生成的主键
             String strDateTemp = "";
             //取得当前时间
             Calendar cal = Calendar.getInstance();
             String strDate = formatter.format(cal.getTime());

             //主键根据规则生成
             strDateTemp = strDate + serverInfo.getServerId();
             //主键增加流水号;
             if(iIndex > 9999)iIndex = 0;
             
             //对流水号补齐4位. 10以下补3个0；[10<= xxx < 100]补2个0;[100<= xxx < 1000]补1个0;
             if(iIndex < 10){
                 strSeqDate = strDateTemp + "000" +  String.valueOf(iIndex);                 
             }else if(iIndex >=10 && iIndex < 100){
                 strSeqDate = strDateTemp + "00" +  String.valueOf(iIndex);                 
             }else if(iIndex >=100 && iIndex < 1000){
                 strSeqDate = strDateTemp + "0" +  String.valueOf(iIndex);                 
             }else{
                     strSeqDate = strDateTemp + String.valueOf(iIndex);                 
             }
             
             
             iIndex ++;
             
         }catch(Exception ex) {
             log.error("主键生成错误！", ex);
         }
        return strSeqDate;
    }
}
