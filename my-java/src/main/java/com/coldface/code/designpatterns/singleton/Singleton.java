package com.coldface.code.designpatterns.singleton;

/**
 * 单例模式:确保一个类只有一个实例，并提供一个全局访问点
 * 单例模式一般分为：懒汉式和饿汉式
 * 懒汉式：当第一次获取类时才进行类的初始化
 * 饿汉式：当类被加载时直接实例化
 * 定义单例模式的一般步骤如下：
 * 1.定义一个私有的构造函数，以保证这个类不能被外部程序实例化
 * 2.定义一个类的实例变量，以保证这个类的唯一实例
 * 3.定义一个获取类唯一的静态方法，使外部程序可以获取这个类的唯一实例
 * @author guanxin
 *
 */
public class Singleton {
	
	/**
	 * 懒汉式
	 */
	private static Singleton uniqueInstance;

	private Singleton(){}
	
	//使用synchronized关键字保证获取实例事，如果实例为null，只有一个线程去创建该实例，但是这样做会导致效率底下，下面有更好的解决办法(getInstance01())
	private static synchronized Singleton getInstance(){
		if(uniqueInstance == null){
			uniqueInstance = new Singleton();
		}
		return uniqueInstance;
	}
	
	
	
	/**
	 * 线程安全的懒汉式
	 * 用“双重检查加锁”，在getInstance中减少使用同步。volatile关键字确保，当uniqueInstance变量被初始化成 Singleton实例时，多个线程正确的处理uniqueInstance变量。
	 * 注意，1.4及更早的Java中，许多JVM对于volatile关键 字的实现会导致双重加锁失效。
	 */
	private volatile static Singleton uniqueInstance01;
	public static Singleton getInstance01(){
		if(uniqueInstance01 == null){
			synchronized (Singleton.class){
				if(uniqueInstance01 == null){
					uniqueInstance01=new Singleton();
				}
			}
		}
		return uniqueInstance01;
	}
	
	/**
	 * 饿汉式
	 * 在加载类时进行实例化，因此不存在获取实例安全问题
	 */
	private static Singleton uniqueInstance02=new Singleton();
	public static Singleton getInstance02(){
		return uniqueInstance02;
	}
	
	

}
