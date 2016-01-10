package com.coldface.code.cache; 

import java.util.Hashtable;

/** 
 * 类LRUCacheByHashTable.java的实现描述：双链表+hashtable实现LRU缓存 
 * @author coldface 2016年1月9日 下午10:29:32 
 */
public class LRUCacheByHashTable {
    
    private final  int cacheSize; //缓存大小
    private final  Hashtable<Object,Entry> nodes; //缓存容器
    private  int currentSize; //当前缓存对象数量
    private Entry first; //链表头
    private Entry last; //链表尾
    
    public LRUCacheByHashTable(int size){
        currentSize=0;
        cacheSize=size;
        nodes=new Hashtable<Object,Entry>(size);
    }
    
    /**
     * 获取缓存中对象，并把它放在最前面
     */
    public Entry get(Object key){
        Entry node=nodes.get(key);
        if(node!=null){
            moveToHead(node);
            return node;
        }else{
            return null;
        }
    }
    
    /**
     * 添加entry到hashtable
     */
    public void put(Object key,Object value){
        //先查看hashtable是否存在该entry，如果存在，则只能更新其value值
        Entry node=nodes.get(key);
        if(node==null){
            //缓存容器是否已经超过大小
            if(currentSize >= cacheSize){
                //将最少使用的删除
                nodes.remove(last.key);
                removeLast();
            }else{
                currentSize++;
            }
            node=new Entry();
        }
        node.value=value;
        //将最新使用的节点放到链表投，表示最新使用的
        moveToHead(node);
        nodes.put(key, node);
    }
    
    /**
     * 将entry删除，注意：删除操作只有在cache满了才会被执行
     */
    public void remove(Object key){
        Entry node=nodes.get(key);
        //在链表中删除
        if(node!=null){
            if(node.prev!=null){
                node.prev.next=node.next;
            }
            if(node.next!=null){
                node.next.prev=node.prev;
            }
            if(first==node){
                first=node.next;
            }
            if(last==node){
                last=node.prev;
            }
            //在hashtable中删除
            nodes.remove(key);
        }
    }
    
    /**
     * 删除链表尾部节点
     * 表示删除最少使用的缓存对象
     */
    private void removeLast(){
        //链表尾不为空，则将链表尾指向null，删除链表尾(删除最使用的缓存对象)
        if(last !=null){
            if(last.prev!=null){
                last.prev.next=null;
            }else{
                first=null;
            }
            last=last.prev;
        }
    }
    
    /**
     * 移动到链表头，表示这个节点是最新使用过的
     */
    private void moveToHead(Entry node){
        if(node == first){
            return;
        }
        if(node.prev!=null){
            node.prev.next=node.next;
        }
        if(node.next!=null){
            node.next.prev=node.prev;
        }
        if(last==node){
            last=node.prev;
        }
        if(first!=null){
            node.next=first;
            first.prev=node;
        }
        first=node;
        node.prev=null;
        if(last == null){
            last=first;
        } 
    }
    
    /**
     * 清空缓存
     */
    public void clear(){
        first=null;
        last=null;
        currentSize=0;
    }
    
    

}

/**
 * 链表节点
 */
class Entry{
    Entry prev; //前一节点
    Entry next; //后一节点
    Object key; //键
    Object value; //值
    
    public Entry(){}
}

