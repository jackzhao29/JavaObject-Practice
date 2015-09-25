package com.coldface.code.designpatterns.command;

/**
 * 命令模式——将“请求”封装成对象，以便使用不同的请求、队列或者日志来参数化其他对象。 
 * 命令模式也支持科撤销的操作。 
 * @author coldface
 *
 */
public class Test {
	
	public static void main(String[] args){
		
		//调用者来执行命令  
        Atm atm = new Atm();  
        ICommand[] commands = new ICommand[3];  
        commands[0] = new CcbDepositCommand();  
        commands[1] = new CcbWithdrawCommand();  
        commands[2] = new CmbWithdrawCommand();  
        atm.setCommand(commands);  
        atm.action(0);  
        atm.cancel(0);  
        atm.action(1);  
        atm.cancel(1);  
        atm.action(2);  
        atm.cancel(2);  
		
	}

}
