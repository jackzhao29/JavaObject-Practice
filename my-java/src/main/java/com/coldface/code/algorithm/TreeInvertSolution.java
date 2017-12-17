package com.coldface.code.algorithm;

import java.util.Stack;

/**
 * 类TreeInvertSolution.java的实现描述：采用递归反转二叉树
 * @author coldface
 * @date 2017年8月7日上午10:20:43
 */
public class TreeInvertSolution {
  
  /**
   * 
   * @author coldface
   * @date 2017年8月7日上午10:26:37
   * @param root
   * @return
   */
  public TreeNode invertTree(TreeNode root){
    if(root == null){
      return root;
    }
    
    TreeNode temp = root.getLeft();
    root.setLeft(root.getRight());
    root.setRight(temp);
    invertTree(root.getLeft());
    invertTree(root.getRight());
    return root;
  }
  
  /**
   * 采用遍历反转二叉树
   * @author zhaofei
   * @date 2017年8月7日上午10:37:01
   * @param root
   * @return
   */
  public TreeNode invertTree1(TreeNode root){
    if(root == null){
      return root;
    }
    Stack<TreeNode> stack = new Stack<TreeNode>();
    stack.push(root);
    while(!stack.isEmpty()){
      TreeNode node = stack.peek();
      stack.pop();
      if(node.getLeft() != null){
        stack.push(node.getLeft());
      }
      if(node.getRight() != null){
        stack.push(node.getRight());
      }
      TreeNode temp = node.getLeft();
      node.setLeft(node.getRight());
      node.setRight(temp);
      
    }
    return root;
    
  }
  

}
