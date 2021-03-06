package com.example.demo.stack;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

/**
 * @author jl.yao
 * @className Demo03
 * @description 化栈为队
 * @date 2021/7/1 11:04
 **/
@Slf4j
public class Demo03 {


    /**
     * 需求：实现一个MyQueue类，该类用两个栈来实现一个队列。
     *
     *
     * 示例：
     *
     * MyQueue queue = new MyQueue();
     *
     * queue.push(1);
     * queue.push(2);
     * queue.peek();  // 返回 1
     * queue.pop();   // 返回 1
     * queue.empty(); // 返回 false
     *
     * 说明：
     *
     * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size 和 is empty 操作是合法的。
     * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
     * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
     *
     *
     */


    public void test(){


    }

    //方法一 ：辅助栈写法
    class MyQueue {
        Stack<Integer> stack1;
        Stack<Integer> helper;

        /** Initialize your data structure here. */
        public MyQueue() {
            stack1 = new Stack<>();
            helper = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            stack1.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {

            if (helper.isEmpty()){
                while (!stack1.isEmpty()){
                    helper.push(stack1.pop());
                }
            }
            if (helper.isEmpty()){
                return -1;
            }else {
                return helper.pop();
            }
        }

        /** Get the front element. */
        public int peek() {
            if (helper.isEmpty()){
                while (!stack1.isEmpty()){
                    helper.push(stack1.pop());
                }
            }
            if (helper.isEmpty()){
                return -1;
            }else {
                return helper.peek();
            }
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stack1.isEmpty() && helper.isEmpty();
        }
    }


}
