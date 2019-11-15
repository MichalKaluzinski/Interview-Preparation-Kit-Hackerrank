package com.michalkaluzinski.solutions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * @author Michal
 * @url https://www.hackerrank.com/challenges/find-the-merge-point-of-two-joined-linked-lists
 */
public class SolutionFindTheMergePointOfTwoLists {

  static class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int nodeData) {
      this.data = nodeData;
      this.next = null;
    }
  }

  static class SinglyLinkedList {
    public SinglyLinkedListNode head;
    public SinglyLinkedListNode tail;

    public SinglyLinkedList() {
      this.head = null;
      this.tail = null;
    }

    public void insertNode(int nodeData) {
      SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

      if (this.head == null) {
        this.head = node;
      } else {
        this.tail.next = node;
      }

      this.tail = node;
    }
  }

  public static void printSinglyLinkedList(
      SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
    while (node != null) {
      bufferedWriter.write(String.valueOf(node.data));

      node = node.next;

      if (node != null) {
        bufferedWriter.write(sep);
      }
    }
  }

  // Complete the findMergeNode function below.

  /*
   * For your reference:
   *
   * SinglyLinkedListNode {
   *     int data;
   *     SinglyLinkedListNode next;
   * }
   *
   */
  static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

    int mergePoint = 0;
    SinglyLinkedListNode head2Tmp = head2;
    while (head1 != null) {
      while (head2Tmp != null) {
        if (head1 == head2Tmp && head1.data == head2Tmp.data) {
          mergePoint = head1.data;
          head1 = null;
          head2 = null;
          head2Tmp = null;
        }
        if (head2Tmp != null) {
          head2Tmp = head2Tmp.next;
        }
      }
      if (head1 != null) {
        head1 = head1.next;
        head2Tmp = head2;
      }
    }
    return mergePoint;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int tests = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int testsItr = 0; testsItr < tests; testsItr++) {
      int index = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      SinglyLinkedList llist1 = new SinglyLinkedList();

      int llist1Count = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int i = 0; i < llist1Count; i++) {
        int llist1Item = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        llist1.insertNode(llist1Item);
      }

      SinglyLinkedList llist2 = new SinglyLinkedList();

      int llist2Count = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int i = 0; i < llist2Count; i++) {
        int llist2Item = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        llist2.insertNode(llist2Item);
      }

      SinglyLinkedListNode ptr1 = llist1.head;
      SinglyLinkedListNode ptr2 = llist2.head;

      for (int i = 0; i < llist1Count; i++) {
        if (i < index) {
          ptr1 = ptr1.next;
        }
      }

      for (int i = 0; i < llist2Count; i++) {
        if (i != llist2Count - 1) {
          ptr2 = ptr2.next;
        }
      }

      ptr2.next = ptr1;

      int result = findMergeNode(llist1.head, llist2.head);

      bufferedWriter.write(String.valueOf(result));
      bufferedWriter.newLine();
    }

    bufferedWriter.close();

    scanner.close();
  }
}
