package com.coldface.code.designpatterns.command;
/**
 * 命令接口，只有两个方法
 * @author coldface
 *
 */
public interface ICommand {
	//执行命令的方法
	public void execute();
	//撤销命令的方法
	public void undo();

}
