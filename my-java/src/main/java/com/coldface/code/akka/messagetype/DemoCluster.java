package com.coldface.code.akka.messagetype;

/**
 * 类DemoCluster.java的实现描述：TODO Demo的入口
 * @author coldface
 * @date 2016年7月17日上午10:56:18
 */
public class DemoCluster {
  public static void main(String[] args) throws Exception {

    // 启动一个Client
    EventClient.main(new String[0]);
    
    // 启动两个Interceptor
    EventInterceptorMain.main(new String[] { "2851" });
    EventInterceptorMain.main(new String[] { "2852" });
    
    // 启动两个Processor
    EventProcessorMain.main(new String[]{"2951"});
    EventProcessorMain.main(new String[]{"2952"});
    EventProcessorMain.main(new String[]{"2953"});
    EventProcessorMain.main(new String[]{"2954"});
    EventProcessorMain.main(new String[]{"2955"});
    
}

}
