package com.coldface.code.akka.dispatcher;

import akka.actor.UntypedActor;

/**
 * 类WriterActor.java的实现描述：TODO 类实现描述
 * 
 * @author coldface
 * @date 2016年6月24日下午6:08:53
 */
public class WriterActor extends UntypedActor {

    /*
     * (non-Javadoc)
     * 
     * @see akka.actor.UntypedActor#onReceive(java.lang.Object)
     */
    @Override
    public void onReceive(Object arg0) throws Exception {
        System.out.println(Thread.currentThread().getName());

    }

}
