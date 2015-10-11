package com.coldface.code.designpatterns.observer;

import java.util.ArrayList;

/**
 * 一个消息主题(主题接口的实现类)
 * 主题记录了所有的观察者列表和主题的状态，当主题的状态发生改变时，可以通知所有订阅者作出相应的反应
 * @author guanxin
 *
 */
public class MsgSubject implements ISubject {
	
	//观察者列表
	private ArrayList<IObserver> observers;
	//消息状态
	private String msg;
	
	

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public MsgSubject(){  
        this.observers = new ArrayList<IObserver>();  
    }  

	public void registerObserver(IObserver observer) {
		// TODO Auto-generated method stub
		observers.add(observer);

	}

	public void removeObserver(IObserver observer) {
		// TODO Auto-generated method stub
		int index=observers.indexOf(observer);
		if(index >= 0){
			observers.remove(observer);
		}

	}

	public void notifyObservers() {
		// TODO Auto-generated method stub
		for(IObserver o:this.observers){
			o.update();
		}

	}

}
