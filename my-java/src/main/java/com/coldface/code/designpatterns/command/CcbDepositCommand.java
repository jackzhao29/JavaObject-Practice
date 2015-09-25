package com.coldface.code.designpatterns.command;

/**
 * 将建设银行系统存款命令封装成命令对象
 * @author coldface
 *
 */
public class CcbDepositCommand implements ICommand {

	private Ccb ccb=new Ccb();
	
	public void execute() {
		// TODO Auto-generated method stub
		ccb.cunqian(100);

	}

	public void undo() {
		// TODO Auto-generated method stub
		ccb.quqian(100);

	}

}
