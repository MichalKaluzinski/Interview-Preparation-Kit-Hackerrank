package com.michalkaluzinski.solutions;

import java.util.Scanner;
import com.michalkaluzinski.model.Node;
class SolutionTreeHeightOfABinaryTree {

  public static int height(Node root) {

    int rightHeight = 0;
    int leftHeight = 0;
    if (root.left != null) {
      leftHeight += height(root.left) + 1;
    }
    if (root.right != null) {
      rightHeight += height(root.right) + 1;
    }
    return Math.max(leftHeight, rightHeight);
  }

  public static Node insert(Node root, int data) {
    if (root == null) {
      return new Node(data);
    } else {
      Node cur;
      if (data <= root.data) {
        cur = insert(root.left, data);
        root.left = cur;
      } else {
        cur = insert(root.right, data);
        root.right = cur;
      }
      return root;
    }
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    Node root = null;
    while (t-- > 0) {
      int data = scan.nextInt();
      root = insert(root, data);
    }
    scan.close();
    int height = height(root);
    System.out.println(height);
  }
}
