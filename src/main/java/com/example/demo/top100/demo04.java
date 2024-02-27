package com.example.demo.top100;

import org.junit.Test;

/**
 * @author jl.yao
 * @className demo04
 * @description 反转链表
 * @date 2024/2/26 16:29
 **/
public class demo04 {

    @Test
    public void test(){
        ListNode listNodeC = new ListNode(1,new ListNode(8,new ListNode(4,new ListNode(5,null))));
        ListNode listNodeA = new ListNode(4,listNodeC);
        ListNode listNodeB = new ListNode(5,new ListNode(6,listNodeC));
        ListNode listNode = reverseList2(listNodeA);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
//        reverseList2(listNodeB);
    }


    //反转链表。首先处理当前节点。他的next 节点 为下一次要处理的节点。将当前节点 只想上一个节点 即完成反转；
    public ListNode reverseList(ListNode head) {
        //上一个节点
        ListNode lastNode = null;
        //当前待处理的节点
        ListNode currentNode = head;
        while (currentNode != null){
            //先将下一个需要处理的节点弄出来
            ListNode nextCode = currentNode.next;
            //将当前节点的next 指向上一个节点 即完成反转
            currentNode.next = lastNode;
            lastNode = currentNode;
            currentNode = nextCode;
        }
        return lastNode;
    }


    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null){
            System.out.println(head.val);
           return head;
        }
        System.out.println(head.val);
        ListNode node = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
