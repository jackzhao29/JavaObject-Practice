package com.coldface.code.algorithm; 
/** 
 * 类Stack.java的实现描述：栈的实现 
 * @author coldface 2016年1月5日 下午3:49:23 
 */
public class Stack {

    Node top;
    
    public Node peek(){
        if(top != null){
            return top;
        }
        return null;
    }
    
    public Node pop(){
        if(top == null){
            return null;
        }else{
            Node temp=new Node(top.val);
            top=top.next;
            return temp;
        }
    }
    
    public void push(Node n){
        if(n != null){
            n.next=top;
            top=n;
        }
    }
}

