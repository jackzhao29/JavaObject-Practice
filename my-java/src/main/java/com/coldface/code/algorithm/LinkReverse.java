package com.coldface.code.algorithm;

/**
 * 类LinkReverse.java的实现描述：链表反转
 * 
 * @author coldface
 * @date 2017年5月11日下午4:38:10
 */
public class LinkReverse {


  /**
   * 递归反转 在反转当前结点之前先反转其后边的结点，即、从尾结点开始逆向反转各个节点的指针域指向
   * 
   * @author coldface
   * @date 2017年5月12日上午10:01:16
   * @param head
   * @return
   */
  public static NodeDemo reverse(NodeDemo head) {
    // 如果是空链表或者尾节点
    if (head == null || head.getNext() == null) {
      return head;
    }

    // 先反转后续结点
    NodeDemo reversedHead = reverse(head.getNext());
    /// 当前结点指针指向前一结点
    head.getNext().setNext(head);

    // 将前一结点的指针域置为null
    head.setNext(null);
    return reversedHead;
  }

  /**
   * 遍历反转 从前往后反转各个节点的指针域的指向
   * 
   * @author coldface
   * @date 2017年5月12日上午10:00:53
   * @param head
   * @return
   */
  public static NodeDemo reverse1(NodeDemo head) {
    if (head == null) {
      return head;
    }

    // 上一结点
    NodeDemo pre = head;
    // 当前结点
    NodeDemo currentNode = head.getNext();

    // 用于存储下一结点
    NodeDemo nextItem;

    // currentNode==null 即尾结点
    while (currentNode != null) {
      // 下一节点存储临时节点
      nextItem = currentNode.getNext();
      // 将当前结点指针指向上一节点
      currentNode.setNext(pre);

      // 移动指针
      pre = currentNode;
      currentNode = nextItem;
    }
    head.setNext(null);
    return pre;

  }

}

