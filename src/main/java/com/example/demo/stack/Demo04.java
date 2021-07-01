package com.example.demo.stack;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Stack;

/**
 * @author jl.yao
 * @className Demo05
 * @description 最大栈
 * @date 2021/7/1 11:13
 **/
@Slf4j
public class Demo04 {


    /**
     * 需求：设计一个最大栈数据结构，既支持栈操作，又支持查找栈中最大元素。
     *
     * 实现 MaxStack 类：
     *
     * MaxStack() 初始化栈对象
     * void push(int x) 将元素 x 压入栈中。
     * int pop() 移除栈顶元素并返回这个元素。
     * int top() 返回栈顶元素，无需移除。
     * int peekMax() 检索并返回栈中最大元素，无需移除。
     * int popMax() 检索并返回栈中最大元素，并将其移除。如果有多个最大元素，只要移除 最靠近栈顶 的那个。
     *  
     *
     * 示例：
     *
     * 输入
     * ["MaxStack", "push", "push", "push", "top", "popMax", "top", "peekMax", "pop", "top"]
     * [[], [5], [1], [5], [], [], [], [], [], []]
     * 输出
     * [null, null, null, null, 5, 5, 1, 5, 1, 5]
     *
     * 解释
     * MaxStack stk = new MaxStack();
     * stk.push(5);   // [5] - 5 既是栈顶元素，也是最大元素
     * stk.push(1);   // [5, 1] - 栈顶元素是 1，最大元素是 5
     * stk.push(5);   // [5, 1, 5] - 5 既是栈顶元素，也是最大元素
     * stk.top();     // 返回 5，[5, 1, 5] - 栈没有改变
     * stk.popMax();  // 返回 5，[5, 1] - 栈发生改变，栈顶元素不再是最大元素
     * stk.top();     // 返回 1，[5, 1] - 栈没有改变
     * stk.peekMax(); // 返回 5，[5, 1] - 栈没有改变
     * stk.pop();     // 返回 1，[5] - 此操作后，5 既是栈顶元素，也是最大元素
     * stk.top();     // 返回 5，[5] - 栈没有改变
     *  
     *
     * 提示：
     *
     * -107 <= x <= 107
     * 最多调用 104 次 push、pop、top、peekMax 和 popMax
     * 调用 pop、top、peekMax 或 popMax 时，栈中 至少存在一个元素
     *
     */

    @Test
    public void test(){
        MaxStack stk = new MaxStack();
        stk.push(5);
        stk.push(1);
        stk.push(5);
        int top = stk.top();//5
        int i = stk.popMax();//5
        int top1 = stk.top();//1
        int i1 = stk.peekMax();//5
        int pop = stk.pop();//1
        int top2 = stk.top();//5
        log.info("输出结果：top:{},popMax:{},top:{},peekMax:{},pop:{},top:{}",top,i,top1,i1,pop,top2);
    }
    @Test
    public void test2(){
        MaxStack stk = new MaxStack();
        stk.push(5);
        stk.push(1);
        int i = stk.popMax();
        int i1 = stk.peekMax();
        log.info("输出结果：{},{}",i,i1);
    }

//    辅助栈解法
    class MaxStack {
        Stack<Integer> stack;
        Stack<Integer> helper;

        /** initialize your data structure here. */
        public MaxStack() {
            stack = new Stack<>();
            helper = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            int max = helper.isEmpty() ? x : helper.peek();
            helper.push(Math.max(max,x));

        }

        public int pop() {
                helper.pop();
            return stack.pop();

        }

        public int top() {
            return stack.peek();
        }

        public int peekMax() {
            return helper.peek();
        }

        public int popMax() {
            //弹出最大值时 找出原始栈中最大的值（依次弹出） 再还原其他不是最大值
            Stack<Integer> buffer = new Stack();
            //最大
            int max = peekMax();
            while (top()!=max  ){
                buffer.push(pop());
            }
            pop();
            while (!buffer.isEmpty()){
               push(buffer.pop());
            }

            return max;
        }

    }
//    辅助栈解法
    class MaxStack2 {
        Stack<Integer> stack;
        Stack<Integer> maxStack;

        public MaxStack2() {
            stack = new Stack();
            maxStack = new Stack();
        }

        public void push(int x) {
            int max = maxStack.isEmpty() ? x : maxStack.peek();
            maxStack.push(max > x ? max : x);
            stack.push(x);
        }

        public int pop() {
            maxStack.pop();
            return stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int peekMax() {
            return maxStack.peek();
        }

        public int popMax() {
            int max = peekMax();
            Stack<Integer> buffer = new Stack();
            while (top() != max) buffer.push(pop());
            pop();
            while (!buffer.isEmpty()) push(buffer.pop());
            return max;
        }
    }

}
