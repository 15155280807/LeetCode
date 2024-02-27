package com.example.demo.top100;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author jl.yao
 * @className demo03
 * @description 相交链表
 * @date 2024/2/26 15:43
 **/
public class demo03 {


    @Test
    public void test(){

        ListNode listNodeC = new ListNode(1,new ListNode(8,new ListNode(4,new ListNode(5,null))));
        ListNode listNodeA = new ListNode(4,listNodeC);
        ListNode listNodeB = new ListNode(5,new ListNode(6,listNodeC));

        ListNode node = getIntersectionNode(listNodeA, listNodeB);

        while (node != null  && node.next != null){
            System.out.println(node);
            node = node.next;
        }

    }

    //暴力迭代
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int a = 0;
        while (headA != null ){
            int b = 0;
            ListNode node = headB;
            while (node != null) {
                if (headA == node ){
                    return headA;
                }
                node = node.next;
                b++;
            }
            headA = headA.next;
            a++;
        }
        return null;
    }

    //借助辅助空间
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
       //首次遍历A的。
        Map<ListNode, Integer> map= new HashMap<>();
        int a = 0,b = 0;
        while (headA != null){
            map.put(headA,a++);
            headA = headA.next;
        }
        while (headB != null){
            if (map.containsKey(headB)){
                return headB;
            }
            headB = headB.next;
            b++;
        }
        return null;
    }


    class ListNode{
        int val;
        ListNode next;
//        ListNode(int x){
//            val = x;
//            next = null;
//        }
        ListNode(int x,ListNode y){
            val = x;
            next = y;
        }
}
}
