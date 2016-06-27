package com.coldface.code.akka;

import akka.actor.UntypedActor;

/**
 * 类Greeter.java的实现描述：打招呼的Actor
 * @author coldface
 * @date   2016年6月21日下午3:05:53
 */
public class Greeter extends UntypedActor {
    
    String greeting=null;

    /* (non-Javadoc)
     * @see akka.actor.UntypedActor#onReceive(java.lang.Object)
     */
    @Override
    public void onReceive(Object message) throws Exception {
       if(message instanceof WhoToGreet){
           greeting="hello, "+((WhoToGreet)message).who;
       }else if(message instanceof Greet){
           //发送招呼消息给发消息这个Actor的Actor
           getSender().tell(new Greeting(greeting), getSelf());
       }else unhandled(message);

    }

}