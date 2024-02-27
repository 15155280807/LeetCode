package com.example.demo.top100;

import org.junit.Test;

import java.util.Stack;

/**
 * @author jl.yao
 * @className demo05
 * @description 回文链表
 * @date 2024/2/26 17:48
 **/
public class demo05 {

    @Test
    public void test(){
       ListNode listNodeC = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(1,null))));
        System.out.println(isPalindrome2(listNodeC));
    }

    // 借助栈
    public boolean isPalindrome(ListNode head) {
        //借助栈的特性 先进后出
        Stack<ListNode> stack = new Stack<>();
        ListNode node =head;
        while (node != null){
            stack.push(node);
            node = node.next;
        }
        while (head != null){
            ListNode pop = stack.pop();
            if (head.val != pop.val){
                return false;
            }
            head = head.next;
        }
        return true;
    }


    //回文链表 反转后与原链表一致
    public boolean isPalindrome2(ListNode head) {
//        ListNode currentHead = head;
//        ListNode node = reverse(currentHead);
//        while (head.next != null){
//            if (head.val != node.val){
//                return false;
//            }
//            head = head.next;
//            node = node.next;
//        }
        return true;
    }

//    private  ListNode reverse(ListNode currentHead){
//        if (node == null || node.next == null){
//            return node;
//        }
//        ListNode reverse = reverse(node.next);
//        node.next.next = node;
//        node.next = null;
//        return reverse;
//
//    }
}
