package com.coldface.code.algorithm;

import java.util.Stack;

/**
 * 类StackPushPopDemo.java的实现描述： java 用两个栈来实现一个队列，完成队列的Push和Pop操作,队列中的元素为String类型。
 * 实现思路：放入元素时使用stack1,获取元素时使用stack2
 * @author coldface
 * @date 2017年5月24日下午5:20:26
 */
public class StackPushPopDemo {
  
  private static Stack<String> stack1 = new Stack<String>();
  private static Stack<String> stack2 = new Stack<String>();
  
  public static void  push(String element){
    stack1.push(element);
  }
  
  public static String pop(){
    String ele;
    if(!stack1.isEmpty()){
      stack2.push(stack1.pop());
    }
    ele = stack2.pop();
    if(!stack2.isEmpty()){
      stack1.push(stack2.pop());
    }
    return ele;
  }

}
