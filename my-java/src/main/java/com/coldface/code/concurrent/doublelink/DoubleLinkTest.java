package com.coldface.code.concurrent.doublelink;

/**
 * 类DoubleLinkTest.java的实现描述：双向链表实现测试
 * 
 * @author coldface 2016年1月8日 下午3:01:24
 */
public class DoubleLinkTest {

    public static void main(String[] args) {
        DoubleLink<Integer> dlink = new DoubleLink<Integer>();
        dlink.insert(0, 20);
        dlink.appendLast(10);
        dlink.insertFirst(30);

        //链表是否为空
        System.out.printf("isEmpty()=%b\n", dlink.isEmpty());
        //链表的大小
        System.out.printf("size()=%d\n", dlink.size());

        //打印出全部节点
        for (int i = 0; i < dlink.size(); i++) {
            System.out.println("dlink(" + i + ")=" + dlink.get(i));
        }
    }

}
