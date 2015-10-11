package com.coldface.code.designpatterns.decorator;

/**
 * 装饰者模式——动态地将责任附加到对象上。若要扩展功能，装饰者提供了比继承更有弹性的替代方案。 
 *  
 * 装饰者模式就是给一个对象动态的添加新的功能，装饰者和被装饰者实现同一个接口，装饰者持有被装饰者的实例。 
 * 
 * Java中IO就使用了装饰者模式(InputStream in=new BufferedInputStream(new FileInputStream("test.txt")));
 * 
 * 其中FileInputStream、BufferedInputStream都实现了InputStream，BufferedInputStram就是一个装饰者，增加利用缓冲输入来改进性能，以及FileInputStream
 * 所没有的readLine()方法来增强接口
 * 
 * 假如我们有一个系统监控的接口，它的功能很简单，就是当系统发生异常时进行处理动作。然后我们实现了一个能够日志记录的实现类，当系统发生异常只要把日志 记录好就可以了。
 * 可是后来我们又想记录完日志后需要给维护人员发邮件，根据开闭原则，我们不能去修改记录日志的类啊，所以这时就需要用到装饰模式了，
 * 定义一个能发送邮件的监控接口实现类，它其中保持了一个监控接口的实例（那个能记日志的实现类），这时，我们调用本实现类时，就即能记录日志，又能发邮件了。
 * 再后来，老大又想加一个系统发生严重异常时能电话通知的功能，没关系，再写一个能电话通知的实现类，什么都不用改，OK了！
 * @author coldface
 *
 */
public class Test {
	
	public static void main(String[] args){
		
		//既想记录日志，又想发送邮件
		IMonitor monitor=new EmailMonitor(new LoggerMonitor());
		monitor.handle();
		System.out.println("--------------------");
		
		//既想记录人日志，又想打电话
		monitor=new PhoneMonitor(new LoggerMonitor());
		monitor.handle();
		System.out.println("---------------------");
		
		//既想记录日志，又想打电话，还想发送邮件
		monitor=new PhoneMonitor(new EmailMonitor(new LoggerMonitor()));
		monitor.handle();
		
	}
	
	

}
