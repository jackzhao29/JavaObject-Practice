package com.coldface.code.designpatterns.observer;

/**
 * 观察者1
 * @author coldface
 *
 */
public class ObserverImpl1 implements IObserver {
	
	//记录主题的引用，当主题状态发生变化时，可向主题获取状态信息
	private MsgSubject msgSubject;
	
	public ObserverImpl1(MsgSubject msgSubject){
		this.msgSubject=msgSubject;
		//向主题注册此观察者
		msgSubject.registerObserver(this);
	}

	public void update() {
		// TODO Auto-generated method stub
		System.out.println("ObserverImpl1收到通知:"+msgSubject.getMsg());

	}

}
