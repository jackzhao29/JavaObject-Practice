package com.coldface.code.algorithm.tree;

/**
 * 类TreeNodeMain.java的实现描述：TODO 类实现描述
 * 
 * @author zhaofei
 * @date 2017年12月17日上午10:18:16
 */
public class TreeNodeMain {

  public static void main(String[] args) {

  }

  /**
   * 求二叉树中的节点个数
   * 递归解法：
   * 1).如果二叉树为空，节点个数为0
   * 2).如果二叉树不为空，二叉树节点个数=左子节点数+右子节点数+1(根节点)
   * @author coldface
   * @date 2017年12月17日上午10:20:47
   * @param root
   * @return
   */
  public static int getNodeNum(BinaryTreeNode root) {
    if (root == null) {
      return 0;
    }
    return getNodeNum(root.getLeft()) + getNodeNum(root.getRight()) + 1;
  }

}
