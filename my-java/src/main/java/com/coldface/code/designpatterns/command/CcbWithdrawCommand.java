package com.coldface.code.designpatterns.command;

/**
 * 将建行系统取钱方法封装成命令
 * @author coldface
 *
 */
public class CcbWithdrawCommand implements ICommand {

	private Ccb ccb=new Ccb();

	public void execute() {
		// TODO Auto-generated method stub
		ccb.quqian(100);
	}

	public void undo() {
		// TODO Auto-generated method stub
		ccb.cunqian(100);
	}

}
