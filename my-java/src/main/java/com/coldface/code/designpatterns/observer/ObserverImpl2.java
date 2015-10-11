package com.coldface.code.designpatterns.observer;

/**
 * 观察者2
 * @author coldface
 *
 */
public class ObserverImpl2 implements IObserver {

	//记录主题的引用，当主题状态发生变化时，可向主题获取状态信
	private MsgSubject msgSubject;
	
	public ObserverImpl2(MsgSubject msgSubject){
		this.msgSubject=msgSubject;
		//向主题注册此观察者
		msgSubject.registerObserver(this);
	}
	
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("ObserverImpl2收到通知:"+msgSubject.getMsg());

	}

}
