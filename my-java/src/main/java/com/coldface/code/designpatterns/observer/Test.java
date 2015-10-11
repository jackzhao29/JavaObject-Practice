package com.coldface.code.designpatterns.observer;

/** 
 * 观察者模式——定义了对象之间的一对多依赖，这样一来，当一个对象改变状态时，它的所有依赖者都会收到通知并自动更新。 
 *  
 * 主题接口的实现类记录了所有的观察者列表和主题的状态，可以向一个主题注册或取消注册一个观察者， 
 * 当主题的状态发生改变时，可以通知所有订阅者做出相应的反应 
 */  
public class Test {
	
	public static void main(String[] args){
		MsgSubject msgSubject = new MsgSubject();  
        ObserverImpl1 o1 = new ObserverImpl1(msgSubject);  
        ObserverImpl2 o2 = new ObserverImpl2(msgSubject);  
          
        msgSubject.setMsg("第一条消息");//改变主题状态  
        msgSubject.notifyObservers();//通知所有观察者作出反应  
          
        msgSubject.setMsg("第二条消息");//改变主题状态  
        msgSubject.notifyObservers();//通知所有观察者作出反应  
          
        msgSubject.removeObserver(o1);//观察者1取消订阅  
        msgSubject.setMsg("第三条消息");//改变主题状态  
        msgSubject.notifyObservers();//通知所有观察者作出反应  

	}

}
