package com.example.demo.linkedList;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Stack;

/**
 * @author jl.yao
 * @className demo01
 * @description
 * @date 2021/6/30 18:48
 **/
@Slf4j
public class Demo01 {


    @Test
    public void test(){
        ListNode node3 = new ListNode(1,null);
        ListNode node2 = new ListNode(2,node3);
        ListNode node5 = new ListNode(3,node2);
        ListNode node1 = new ListNode(2,node5);
        ListNode node = new ListNode(1,node1);

        boolean palindrome = isPalindrome2(node);
        System.out.println(palindrome);
    }


    /**
     * 请判断一个链表是否为回文链表。
     *
     * 示例 1:
     *
     * 输入: 1->2
     * 输出: false
     * 示例 2:
     *
     * 输入: 1->2->2->1
     * 输出: true
     * 进阶：
     * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
     */

    //方法一 ：快慢指针
    public boolean isPalindrome(ListNode head) {
        if (head == null ||head.next == null){
            return false;
        }
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null ){
            fast = fast.next.next;
            //慢指针的下一位
            ListNode next = slow.next;

            //修改慢指针走过的节点指向前一个节点
            slow.next = pre;
            pre = slow;
            slow = next;
        }
        if(fast != null){
            //当长度为奇数是，慢指针需要再走一个单位
            slow = slow.next;
        }
        while(pre!=null) {
            //判断是否为回文串
            if(pre.value!=slow.value){
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }

        return true;

    }

    //方法二 ：不在意空间，时间提示
    public boolean isPalindrome2(ListNode head) {
        if (head == null ||head.next == null){
            return false;
        }
        //压栈
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur!=null){
            stack.add(cur);
            cur = cur.next;
        }

        //出栈比较
        boolean flag = true;
        while (!stack.empty()){
            ListNode pop = stack.pop();
            if (head.value != pop.value){
                flag = false;
            }
            head = head.next;
        }

        return flag;

    }






     class  ListNode{
        private int value;
        private ListNode next;

        public ListNode(int value,ListNode next) {
            this.value = value;
            this.next = next;
        }


        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }


}
