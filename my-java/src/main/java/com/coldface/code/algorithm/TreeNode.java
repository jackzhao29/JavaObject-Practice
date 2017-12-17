package com.coldface.code.algorithm;

/**
 * 类TreeNode.java的实现描述：TODO 类实现描述
 * @author coldface
 * @date 2017年8月7日上午10:21:36
 */
public class TreeNode {
  
  private int value;
  private TreeNode left;
  private TreeNode right;
  
  public TreeNode(int x){
    value = x;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public TreeNode getLeft() {
    return left;
  }

  public void setLeft(TreeNode left) {
    this.left = left;
  }

  public TreeNode getRight() {
    return right;
  }

  public void setRight(TreeNode right) {
    this.right = right;
  }
  
  

}
