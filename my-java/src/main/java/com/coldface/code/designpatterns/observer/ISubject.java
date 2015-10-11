package com.coldface.code.designpatterns.observer;

/**
 * 主题接口
 * @author coldface
 *
 */
public interface ISubject {
	
	//注册一个观察者
	public void registerObserver(IObserver observer);
	
	//移除一个观察者
	public void removeObserver(IObserver observer);
	
	//通知所有观察者
	public void notifyObservers();
	

}
