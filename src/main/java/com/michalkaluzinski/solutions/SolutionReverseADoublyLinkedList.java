package com.michalkaluzinski.solutions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author Michal
 * @url https://www.hackerrank.com/challenges/reverse-a-doubly-linked-list
 */
public class SolutionReverseADoublyLinkedList {

  static class DoublyLinkedListNode {
    public int data;
    public DoublyLinkedListNode next;
    public DoublyLinkedListNode prev;

    public DoublyLinkedListNode(int nodeData) {
      this.data = nodeData;
      this.next = null;
      this.prev = null;
    }
  }

  static class DoublyLinkedList {
    public DoublyLinkedListNode head;
    public DoublyLinkedListNode tail;

    public DoublyLinkedList() {
      this.head = null;
      this.tail = null;
    }

    public void insertNode(int nodeData) {
      DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

      if (this.head == null) {
        this.head = node;
      } else {
        this.tail.next = node;
        node.prev = this.tail;
      }

      this.tail = node;
    }
  }

  public static void printDoublyLinkedList(
      DoublyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
    while (node != null) {
      bufferedWriter.write(String.valueOf(node.data));

      node = node.next;

      if (node != null) {
        bufferedWriter.write(sep);
      }
    }
  }

  // Complete the reverse function below.

  /*
   * For your reference:
   *
   * DoublyLinkedListNode {
   *     int data;
   *     DoublyLinkedListNode next;
   *     DoublyLinkedListNode prev;
   * }
   *
   */
  static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
    DoublyLinkedListNode doublyLinkedListNode = null;

    if (head == null) {
      return doublyLinkedListNode;
    }

    DoublyLinkedListNode tmp = head;
    List<DoublyLinkedListNode> doublyLinkedListNodeList = new ArrayList<>();
    doublyLinkedListNodeList.add(head);
    while (tmp != null) {
      doublyLinkedListNodeList.add(tmp);
      tmp = tmp.next;
    }
    Collections.reverse(doublyLinkedListNodeList);
    doublyLinkedListNode = doublyLinkedListNodeList.get(0);
    doublyLinkedListNode.prev = null;
    DoublyLinkedListNode currentHead = doublyLinkedListNode;
    for (int i = 1; i < doublyLinkedListNodeList.size(); i++) {
      DoublyLinkedListNode currentIndex = doublyLinkedListNodeList.get(i);
      currentHead.next = currentIndex;
      currentIndex.prev = currentHead;
      currentIndex.next = null;
      currentHead = currentIndex;
    }

    return doublyLinkedListNode;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int t = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int tItr = 0; tItr < t; tItr++) {
      DoublyLinkedList llist = new DoublyLinkedList();

      int llistCount = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int i = 0; i < llistCount; i++) {
        int llistItem = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        llist.insertNode(llistItem);
      }

      DoublyLinkedListNode llist1 = reverse(llist.head);

      printDoublyLinkedList(llist1, " ", bufferedWriter);
      bufferedWriter.newLine();
    }

    bufferedWriter.close();

    scanner.close();
  }
}
