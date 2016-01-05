package com.coldface.code.algorithm; 
/** 
 * 类Queue.java的实现描述：队列的实现
 * @author coldface 2016年1月5日 下午3:54:21 
 */
public class Queue {
    Node first, last;
    
    public void enqueue(Node n){
        if(first == null){
            first = n;
            last = first;
        }else{
            last.next=n;
            last=n;
        }
    }
    
    public Node dequeu(){
        if(first == null){
            return null;
        }else{
            Node temp=new Node(first.val);
            first = first.next;
            return temp;
        }
    }

}

