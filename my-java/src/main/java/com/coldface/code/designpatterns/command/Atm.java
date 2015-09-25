package com.coldface.code.designpatterns.command;

public class Atm {
	
	private ICommand[] command;  
    
    public Atm(){  
        this.command = new ICommand[]{new NoCommand()};  
    }  
    //设置一组要执行的命令  
    public void setCommand(ICommand command[]) {  
        this.command = command;  
    }  
    //执行命令的方法  
    public void action(int i) {  
        this.command[i].execute();  
    }  
    //撤销命令的方法  
    public void cancel(int i) {  
        this.command[i].undo();  
    }  

}
