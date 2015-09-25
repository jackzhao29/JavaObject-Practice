package com.coldface.code.designpatterns.command;

/**
 * 将招行的取款方法封装成命令对象
 * @author coldface
 *
 */
public class CmbWithdrawCommand implements ICommand {

	private Cmb cmb=new Cmb();
	public void execute() {
		// TODO Auto-generated method stub
		cmb.getMoney(200);

	}

	public void undo() {
		// TODO Auto-generated method stub
		cmb.saveMoney(200);

	}

}
