package com.example.demo.stack;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Stack;

/**
 * @author jl.yao
 * @className Demo01
 * @description 最小栈
 * @date 2021/7/1 9:15
 **/
@Slf4j
public class Demo01 {

    /**
     * 需求：定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
     *
     *  
     *
     * 示例:
     *
     * MinStack minStack = new MinStack();
     * minStack.push(-2);
     * minStack.push(0);
     * minStack.push(-3);
     * minStack.min();   --> 返回 -3.
     * minStack.pop();
     * minStack.top();      --> 返回 0.
     * minStack.min();   --> 返回 -2.
     *  
     *
     * 提示：
     *
     * 各函数的调用总次数不超过 20000 次
     *
     */

    @Test
    public void  test(){

    }



    class MinStack {
        Stack<Integer> stack1;
        Stack<Integer> helper;


        /** initialize your data structure here. */
        public MinStack() {
            stack1 = new Stack<>();
            helper = new Stack<>();
        }

        public void push(int x) {
            stack1.push(x);
            if (helper.isEmpty() || helper.peek() >= x){
                helper.push(x);
            }

        }

        public void pop() {
            if (stack1.peek().equals(helper.peek())){
                helper.pop();
            }
            stack1.pop();
        }

        public int top() {
            return stack1.peek();
        }

        public int min() {
            return helper.peek();
        }
    }

    class MinStack2 {
        Stack<Integer> stack1;
        Stack<Integer> helper;


        /** initialize your data structure here. */
        public MinStack2() {
            stack1 = new Stack<>();
            helper = new Stack<>();
            helper.push(Integer.MAX_VALUE);
        }

        public void push(int x) {
            stack1.push(x);
            helper.push(Math.min(helper.peek(),x));

        }

        public void pop() {
            stack1.pop();
            helper.pop();
        }

        public int top() {
            return stack1.peek();
        }

        public int min() {
            return helper.peek();
        }
    }
}
