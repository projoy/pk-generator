package cn.pbdata.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

/**
 * @Title:
 * @Description: 
 * @Create on: 2015年10月23日 下午4:13:31
 * @Author:ljy
 * @Version:1.0
 */
public class PKGeneratorTest {

    @Test
    public void date(){
        Calendar cal = Calendar.getInstance();
        //日期格式化
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        
        String strDate = formatter.format(cal.getTime());
        System.out.println(strDate);
    }
    
    @Test
    public void testStrPk(){
        PKGenerator pk = PKGenerator.getInstance();
        Set<String> set = new HashSet<String>();
        int total = 100000;
        long start = System.currentTimeMillis();
        
        for(int i = 0; i < total; i++){
            String key = pk.generateStringPk();
           System.out.println(key);
           set.add(key);
        }
        long end = System.currentTimeMillis();
        System.out.println("用时：" + (end - start) +" ms,计划生成key" + total + "个;实际生成key " + set.size()+"个" );
        Iterator<String> it = set.iterator();
        int i = 0;
        while(it.hasNext()){
//            System.out.println("--------"+it.next());
            i++;
            if(i == 10){
                break;
            }
        }
        
    }
    
}
