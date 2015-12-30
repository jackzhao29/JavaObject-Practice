package oom; 

import java.util.ArrayList;
import java.util.List;

/** 
 * 类JavaOutOfMemoryError.java的实现描述：Java堆溢出OutOfMemoryError代码示例
 * @author coldface 2015年12月30日 上午11:15:50 
 */
public class JavaOutOfMemoryError {
    
    static class OomObject{}
    
    public static void main(String[] args){
        List<OomObject> list=new ArrayList<OomObject>();
        
        while(true){
            list.add(new OomObject());
        }
    }

}

